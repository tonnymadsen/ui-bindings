package com.rcpcompany.uibindings.internal.clipboardconverters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.dnd.Clipboard;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IClipboardConverterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ClipboardConverterManager implements IClipboardConverterManager {

	private static IClipboardConverterManager MANAGER = null;

	public static IClipboardConverterManager getManager() {
		if (MANAGER == null) {
			MANAGER = new ClipboardConverterManager();
		}
		return MANAGER;
	}

	private final IClipboardConverter[] myConverters = new IClipboardConverter[] {

	new TSVConverter(), new CSVConverter(),

	new HTMLTableConverter(), new WordTableConverter(), new PDFTableConverter(),

	new SpaceSVConverter()

	};

	@Override
	public List<IResult> getClipboardConversions() {
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();
		LogUtils.debug(this, Arrays.toString(clipboard.getAvailableTypeNames()));
		final List<IResult> results = new ArrayList<IResult>();

		CC: for (final IClipboardConverter cc : myConverters) {
			final String[][] table;
			try {
				table = cc.convert(clipboard);
			} catch (final Exception ex) {
				LogUtils.error(cc, ex);
				continue CC;
			}
			if (table == null) {
				continue;
			}

			/*
			 * Check for well-formed tables
			 */
			int columns = -1;
			if (table.length == 0) {
				continue CC;
			}
			for (int y = 0; y < table.length; y++) {
				final String[] row = table[y];
				if (row == null || row.length == 0) {
					continue CC;
				}
				if (columns == -1) {
					columns = row.length;
				} else if (columns != row.length) {
					continue CC;
				}
			}

			/*
			 * Look for a match
			 */
			IResult res = null;
			T: for (final IResult r : results) {
				if (r.getRows() != table.length) {
					continue T;
				}
				if (r.getColumns() != table[0].length) {
					continue T;
				}

				final String[][] t = r.getTable();
				for (int y = 0; y < t.length; y++) {
					final String[] row1 = table[y];
					final String[] row2 = t[y];
					if (!Arrays.equals(row1, row2)) {
						continue T;
					}
				}
				res = r;
				break;
			}

			/*
			 * Create a new table
			 */
			if (res == null) {
				res = new Result(table);
				results.add(res);
			}

			res.getConverterNames().add(cc.getName());
		}
		/*
		 * Sort by
		 * 
		 * - number of columns
		 * 
		 * - number of converters with the specified result
		 */
		Collections.sort(results, new Comparator<IResult>() {
			@Override
			public int compare(IResult o1, IResult o2) {
				final int c1 = o1.getColumns();
				final int c2 = o2.getColumns();
				if (c1 != c2) return c2 - c1;
				return o2.getConverterNames().size() - o1.getConverterNames().size();
			}
		});
		return results;
	}

	/**
	 * Implementation of {@link IResult} for use with
	 * {@link IClipboardConverterManager#getClipboardConversions()}.
	 */
	public static class Result implements IResult {
		private final String[][] myTable;
		private final List<String> myNames = new ArrayList<String>();

		/**
		 * Constructs and returns a new result for the specified table.
		 * 
		 * @param table the table of this result
		 */
		public Result(String[][] table) {
			myTable = table;

		}

		@Override
		public List<String> getConverterNames() {
			return myNames;
		}

		@Override
		public String[][] getTable() {
			return myTable;
		}

		@Override
		public int getRows() {
			return myTable.length;
		}

		@Override
		public int getColumns() {
			return myTable[0].length;
		}
	}
}
