package com.rcpcompany.uibindings.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * TAKEN FROM http://hexapixel.com/2009/06/30/creating-a-notification-popup-widget
 * 
 */
public class NotifierDialog {

	// how long the the tray popup is displayed after fading in (in milliseconds)
	private static final int DISPLAY_TIME = 3500;
	// how long each tick is when fading in (in ms)
	private static final int FADE_TIMER = 50;
	// how long each tick is when fading out (in ms)
	private static final int FADE_IN_STEP = 30;
	// how many tick steps we use when fading out
	private static final int FADE_OUT_STEP = 8;

	// how high the alpha value is when we have finished fading in
	private static final int FINAL_ALPHA = 225;

	// title foreground color
	private static Color _titleFgColor = new Color(PlatformUI.getWorkbench().getDisplay(), new RGB(40, 73, 97));

	// hyperlink color
	private static Color _hyperlinkColor = new Color(PlatformUI.getWorkbench().getDisplay(), new RGB(40, 73, 200));
	// text foreground color
	private static Color _fgColor = _titleFgColor;

	// shell gradient background color - top
	private static Color _bgFgGradient = new Color(PlatformUI.getWorkbench().getDisplay(), new RGB(226, 239, 249));
	// shell gradient background color - bottom
	private static Color _bgBgGradient = new Color(PlatformUI.getWorkbench().getDisplay(), new RGB(177, 211, 243));
	// shell border color
	private static Color _borderColor = new Color(PlatformUI.getWorkbench().getDisplay(), new RGB(40, 73, 97));

	// contains list of all active popup shells
	private static List<Shell> _activeShells = new ArrayList<Shell>();

	// image used when drawing
	private static Image _oldImage;

	private static Shell _shell;
	private static Rectangle clientArea;
	private static TimerTask task;

	/**
	 * Creates and shows a notification dialog with a specific title, message and a.
	 * 
	 * @param title
	 * @param message
	 * @param type
	 */
	public static void notify(final Shell parent, final IStatus status) {
		_shell = new Shell(parent, SWT.NO_TRIM);
		_shell.setLayout(new FillLayout());
		_shell.setForeground(_fgColor);
		_shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		_shell.addListener(SWT.Dispose, new Listener() {
			@Override
			public void handleEvent(Event event) {
				_activeShells.remove(_shell);
			}
		});

		final Composite inner = new Composite(_shell, SWT.NONE);
		final Listener mouseListener = new Listener() {
			@Override
			public void handleEvent(Event e) {
				showModalDialog(parent, status);
			}

		};
		final int mouseEvents = SWT.MouseUp;
		inner.addListener(mouseEvents, mouseListener);

		final GridLayout gl = new GridLayout(2, false);
		gl.marginLeft = 5;
		gl.marginTop = 0;
		gl.marginRight = 5;
		gl.marginBottom = 5;

		inner.setLayout(gl);
		_shell.addListener(SWT.Resize, new Listener() {

			@Override
			public void handleEvent(Event e) {
				try {
					// get the size of the drawing area
					final Rectangle rect = _shell.getClientArea();
					// create a new image with that size
					final Image newImage = new Image(Display.getDefault(), Math.max(1, rect.width), rect.height);
					// create a GC object we can use to draw with
					final GC gc = new GC(newImage);

					// fill background
					gc.setForeground(_bgFgGradient);
					gc.setBackground(_bgBgGradient);
					gc.fillGradientRectangle(rect.x, rect.y, rect.width, rect.height, true);

					// draw shell edge
					gc.setLineWidth(2);
					gc.setForeground(_borderColor);
					gc.drawRectangle(rect.x + 1, rect.y + 1, rect.width - 2, rect.height - 2);
					// remember to dipose the GC object!
					gc.dispose();

					// now set the background image on the shell
					_shell.setBackgroundImage(newImage);

					// remember/dispose old used iamge
					if (_oldImage != null) {
						_oldImage.dispose();
					}
					_oldImage = newImage;
				} catch (final Exception err) {
					LogUtils.error(this, err);
				}
			}
		});

		final GC gc = new GC(_shell);

		final String message = status.getMessage();

		final int width = 350;

		final String lines[] = message.split("\n");
		Point longest = null;
		final int typicalHeight = gc.stringExtent("X").y;

		int nLines = lines.length;
		for (final String line : lines) {
			final Point extent = gc.stringExtent(line);
			if (longest == null) {
				longest = extent;
				continue;
			}

			if (extent.x > longest.x) {
				longest = extent;
			}
			if (extent.x > width) {
				// wrap
				nLines++;
			}
		}
		gc.dispose();

		final int minHeight = typicalHeight * nLines + 100;

		final CLabel imgLabel = new CLabel(inner, SWT.NONE);
		imgLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_BEGINNING));

		String title = "Info";
		final Display display = _shell.getDisplay();
		if (status.getSeverity() == IStatus.WARNING) {
			title = "Warning";
			final Image image = display.getSystemImage(SWT.ICON_WARNING);
			imgLabel.setImage(image);
		} else if (status.getSeverity() == IStatus.ERROR) {
			title = "Error";
			final Image image = display.getSystemImage(SWT.ICON_ERROR);
			imgLabel.setImage(image);
		} else {
			title = "Info";
			final Image image = display.getSystemImage(SWT.ICON_INFORMATION);
			imgLabel.setImage(image);
		}

		// if (status instanceof SIMAStatus) {
		// final SIMAStatus simaStatus = (SIMAStatus) status;
		// final String sTitle = simaStatus.getTitle();
		// if (sTitle != null && !sTitle.isEmpty()) {
		// title = sTitle;
		// }
		// }

		final CLabel titleLabel = new CLabel(inner, SWT.NONE);
		titleLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_CENTER));
		titleLabel.setText(title);

		titleLabel.setForeground(_titleFgColor);
		final Font f = titleLabel.getFont();
		final FontData fd = f.getFontData()[0];
		fd.setStyle(SWT.BOLD);
		fd.height = 11;
		// titleLabel.setFont(FontCache.getFont(fd));

		final Label txtMessage = new Label(inner, SWT.WRAP);
		final Font tf = txtMessage.getFont();
		final FontData tfd = tf.getFontData()[0];
		tfd.setStyle(SWT.BOLD);
		tfd.height = 8;
		// txtMessage.setFont(FontCache.getFont(tfd));
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		txtMessage.setLayoutData(gd);
		txtMessage.setForeground(_fgColor);
		txtMessage.setText(message);

		// if (status instanceof ResultStatus) {
		// final ResultStatus res = (ResultStatus) status;
		// addResultLink(inner, res);
		// }

		final Hyperlink openTxt = new Hyperlink(inner, SWT.WRAP);
		openTxt.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				showModalDialog(parent, status);
			}
		});

		final FontData tfd2 = openTxt.getFont().getFontData()[0];
		tfd2.setStyle(SWT.BOLD);
		tfd2.height = 8;
		// openTxt.setFont(FontCache.getFont(tfd2));
		final GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 2;
		openTxt.setLayoutData(gd2);
		openTxt.setForeground(_hyperlinkColor);
		openTxt.setText("Click to open dialog");

		_shell.setSize(width, minHeight);

		if (Display.getDefault().getActiveShell() == null || Display.getDefault().getActiveShell().getMonitor() == null)
			return;

		final int startX = clientArea.x + clientArea.width - width - 2;
		final int startY = clientArea.y + clientArea.height - minHeight - 2;

		// move other shells up
		if (!_activeShells.isEmpty()) {
			final List<Shell> modifiable = new ArrayList<Shell>(_activeShells);
			Collections.reverse(modifiable);
			for (final Shell shell : modifiable) {
				if (shell.isDisposed()) {
					System.err.println("shell is disposed");
					continue;
				}
				final Point curLoc = shell.getLocation();
				shell.setLocation(curLoc.x, curLoc.y - minHeight);
				if (curLoc.y - minHeight < 0) {
					_activeShells.remove(shell);
					shell.dispose();
				}
			}
		}

		_shell.setLocation(startX, startY);
		_shell.setAlpha(0);
		_shell.setVisible(true);

		_activeShells.add(_shell);

		fadeIn(_shell);
	}

	private static void addResultLink(Composite inner, final ResultStatus status) {
		final Hyperlink resultLink = new Hyperlink(inner, SWT.WRAP);
		final FontData tfd2 = resultLink.getFont().getFontData()[0];
		tfd2.setStyle(SWT.BOLD);
		tfd2.height = 8;
		resultLink.setFont(FontCache.getFont(tfd2));
		final GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 2;
		resultLink.setLayoutData(gd2);
		resultLink.setForeground(_hyperlinkColor);

		String linkName = (String) status.getProperty(ResultStatus.LINKNAME);
		if (linkName == null) {
			linkName = "Show result";
		}
		resultLink.setText(linkName);
		resultLink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				final Object sel = status.getProperty(ResultStatus.SELECTION);
				if (sel instanceof MOAO) {
					ViewUtil.openEditor((MOAO) sel);
				} else if (sel instanceof IAdaptable) {
					final SIMAOpenEditorHandler handler = (SIMAOpenEditorHandler) ((IAdaptable) sel)
							.getAdapter(SIMAOpenEditorHandler.class);
					if (handler != null) {
						handler.open(new StructuredSelection(sel));
					}
				}
			}
		});

	}

	private static void showModalDialog(final Shell parent, final IStatus status) {
		// if(status instanceof ResultStatus){
		// ResultStatus res = (ResultStatus) status;
		// Object sel = res.getProperty(ResultStatus.SELECTION);
		// Object viewId = res.getProperty(ResultStatus.EDITOR);
		// if(sel!=null && viewId instanceof String){
		// ViewUtil.showViewWithSelection((String)viewId, sel);
		// }
		// }else{
		String dialogTitle = "";
		if (status instanceof SIMAStatus) {
			dialogTitle = ((SIMAStatus) status).getTitle();
		}
		SIMAErrorDialog.openError(parent, dialogTitle, null, status);
	}

	private static void fadeIn(final Shell _shell) {
		final Runnable run = new Runnable() {

			@Override
			public void run() {
				try {
					if (_shell == null || _shell.isDisposed()) return;

					int cur = _shell.getAlpha();
					cur += FADE_IN_STEP;

					if (cur > FINAL_ALPHA) {
						_shell.setAlpha(FINAL_ALPHA);
						startTimer(_shell);
						return;
					}

					_shell.setAlpha(cur);
					Display.getDefault().timerExec(FADE_TIMER, this);
				} catch (final Exception err) {
					SIMALogUtils.error(this, err);
				}
			}

		};
		Display.getDefault().timerExec(FADE_TIMER, run);
	}

	private static void startTimer(final Shell _shell) {
		task = new TimerTask() {
			@Override
			public void run() {
				final Runnable run = new Runnable() {
					@Override
					public void run() {
						try {
							if (_shell == null || _shell.isDisposed()) return;
							fadeOut(_shell);
						} catch (final Exception err) {
							SIMALogUtils.error(this, err);
						}
					}

				};
				Display.getDefault().syncExec(run);
			}
		};
		final Timer timer = new Timer();

		timer.schedule(task, DISPLAY_TIME);

	}

	private static void fadeOut(final Shell _shell) {
		final Runnable run = new Runnable() {

			@Override
			public void run() {
				try {
					if (_shell == null || _shell.isDisposed()) return;

					int cur = _shell.getAlpha();
					cur -= FADE_OUT_STEP;
					if (cur <= 0) {
						_shell.setAlpha(0);
						if (_oldImage != null) {
							_oldImage.dispose();
						}
						_shell.dispose();
						_activeShells.remove(_shell);
						return;
					}

					_shell.setAlpha(cur);

					Display.getDefault().timerExec(FADE_TIMER, this);

				} catch (final Exception err) {
					SIMALogUtils.error(this, err);
				}
			}

		};
		Display.getDefault().timerExec(FADE_TIMER, run);

	}

	public static void notify(Shell parent, Rectangle bounds, IStatus status) {
		clientArea = bounds;
		notify(parent, status);
	}

}
