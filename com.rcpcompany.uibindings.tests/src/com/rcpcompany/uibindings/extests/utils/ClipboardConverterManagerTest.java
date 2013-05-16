/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager.IResult;

/**
 * Tests of {@link IClipboardConverterManager}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ClipboardConverterManagerTest {
	public Clipboard clipboard = IManager.Factory.getManager().getClipboard();

	/**
	 * Tests comma-separated-values
	 */
	@Test
	public void testCSVComma() {
		setClipboarText("1,2,3,4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 4, new String[][] { new String[] { "1,2,3,4" } });
	}

	/**
	 * Tests semicolon-separated-values
	 */
	@Test
	public void testCSVSemicolon() {
		setClipboarText("1;2;3;4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 4, new String[][] { new String[] { "1,2,3,4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV1() {
		setClipboarText("1 2 3 4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 2, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 3, new String[][] { new String[] { "1 2 3 4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV2() {
		setClipboarText("1 2\t3 4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(4, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 1, new String[][] { new String[] { "1", "2\t3", "4" } });
		testOneResult(res.get(2), 1, new String[][] { new String[] { "1 2", "3 4" } });
		testOneResult(res.get(3), 2, new String[][] { new String[] { "1 2\t3 4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV3() {
		setClipboarText("1 2 3 4\n4 3 2 1");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 2, new String[][] { new String[] { "1", "2", "3", "4" },
				new String[] { "4", "3", "2", "1" } });
		testOneResult(res.get(1), 3, new String[][] { new String[] { "1 2 3 4" }, new String[] { "4 3 2 1" } });
	}

	/**
	 * Tests tab-separated-values
	 */
	@Test
	public void testTSV() {
		setClipboarText("1\t2\t3\t4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		// Both TSV and SSV
		testOneResult(res.get(0), 2, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 3, new String[][] { new String[] { "1\t2\t3\t4" } });
	}

	/**
	 * Tests irregular text...
	 */
	@Test
	public void testIrregular() {
		setClipboarText("1 2\t3 4\n1");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 2, new String[][] { new String[] { "1 2\t3 4" }, new String[] { "1" } });
	}

	/**
	 * Tests multiple results - sorted correctly
	 */
	@Test
	public void testTwoResults() {
		setClipboarText("1,2\t3,4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(3, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2\t3", "4" } });
		testOneResult(res.get(1), 2, new String[][] { new String[] { "1,2", "3,4" } });
		testOneResult(res.get(2), 2, new String[][] { new String[] { "1,2\t3,4" } });
	}

	/**
	 * Tests tables from Excel
	 */
	@Test
	public void testTableExcel() {
		setClipboarHTML("\n" + "\n" + " <col width=64 span=2 style='width:48pt'>\n"
				+ " <tr height=17 style='height:12.75pt'>\n"
				+ "  <td height=17 align=right width=64 style='height:12.75pt;width:48pt' x:num>1</td>\n"
				+ "  <td width=64 style='width:48pt'>a</td>\n" + " </tr>\n"
				+ " <tr height=17 style='height:12.75pt'>\n"
				+ "  <td height=17 align=right style='height:12.75pt' x:num>2</td>\n" + "  <td>b</td>\n" + " </tr>\n"
				+ "\n");

		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "a" }, new String[] { "2", "b" } });
	}

	/**
	 * Tests single cell tables from Excel
	 */
	@Test
	public void testTableExcelSingleCell() {
		setClipboarHTML("\n" + "\n"
				+ "  <td height=17 align=right width=64 style='height:12.75pt;width:48pt' x:num>1</td>\n" + "\n");

		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1" } });
	}

	/**
	 * Tests tables from Word
	 */
	@Test
	public void testTableWord() {
		setClipboarHTML("\n" + "\n" + "\n" + "<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0\n"
				+ " style='border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;\n"
				+ " mso-yfti-tbllook:480;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:\n"
				+ " .5pt solid windowtext;mso-border-insidev:.5pt solid windowtext'>\n"
				+ " <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>\n"
				+ "  <td width=295 valign=top style='width:221.4pt;border:solid windowtext 1.0pt;\n"
				+ "  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>\n"
				+ "  <p class=MsoNormal>1<o:p></o:p></p>\n" + "  </td>\n"
				+ "  <td width=295 valign=top style='width:221.4pt;border:solid windowtext 1.0pt;\n"
				+ "  border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:\n"
				+ "  solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>\n" + "  <p class=MsoNormal>a<o:p></o:p></p>\n"
				+ "  </td>\n" + " </tr>\n" + " <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>\n"
				+ "  <td width=295 valign=top style='width:221.4pt;border:solid windowtext 1.0pt;\n"
				+ "  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;\n"
				+ "  padding:0cm 5.4pt 0cm 5.4pt'>\n" + "  <p class=MsoNormal>2<o:p></o:p></p>\n" + "  </td>\n"
				+ "  <td width=295 valign=top style='width:221.4pt;border-top:none;border-left:\n"
				+ "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n"
				+ "  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;\n"
				+ "  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>\n"
				+ "  <p class=MsoNormal>b<o:p></o:p></p>\n" + "  </td>\n" + " </tr>\n" + "</table>\n" + "\n" + "\n");

		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "a" }, new String[] { "2", "b" } });
	}

	/**
	 * Tests tables from a web site
	 */
	@Test
	public void testTableWeb() {
		setClipboarHTML("<span class=\"Apple-style-span\" style=\"border-collapse: separate; color: rgb(0, 0, 0); "
				+ "font-family: 'Times New Roman'; font-style: normal; font-variant: normal; font-weight: normal; "
				+ "letter-spacing: normal; line-height: normal; orphans: 2; text-align: -webkit-auto; "
				+ "text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; "
				+ "-webkit-border-horizontal-spacing: 0px; -webkit-border-vertical-spacing: 0px; "
				+ "-webkit-text-decorations-in-effect: none; -webkit-text-size-adjust: auto; "
				+ "-webkit-text-stroke-width: 0px; font-size: medium; \"><span class=\"Apple-style-span\" "
				+ "style=\"color: rgb(126, 125, 125); font-family: 'Lucida Sans', Arial, Verdana; "
				+ "font-size: 12px; text-align: -webkit-center; \"><table border=\"0\" cellspacing=\"2\" "
				+ "cellpadding=\"2\" style=\"height: 72px; \"><tbody style=\"text-align: left; \">"
				+ "<tr style=\"text-align: left; \"><td style=\"text-align: left; \">1</td>"
				+ "<td style=\"text-align: center; \">a</td></tr><tr style=\"text-align: left; \"><td style=\"text-align: "
				+ "left; \">2</td><td style=\"text-align: center; \">b</td></tr></tbody></table></span></span>"
				+ "<br class=\"Apple-interchange-newline\">");

		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "a" }, new String[] { "2", "b" } });
	}

	private void testOneResult(IResult res, int nNames, String[][] expectedTable) {
		assertNotNull(res);
		final String what = "" + res.getConverterNames();
		assertEquals(what, nNames, res.getConverterNames().size());

		assertEquals(what, expectedTable.length, res.getRows());
		assertEquals(what, expectedTable[0].length, res.getColumns());

		final String[][] t = res.getTable();

		for (int i = 0; i < res.getRows(); i++) {
			final String[] row = expectedTable[i];
			final String[] expectedRow = expectedTable[i];

			assertEquals(what, expectedRow.length, row.length);
			assertArrayEquals(what, expectedRow, row);
		}
	}

	private void setClipboarText(String t) {
		final Object[] data = new Object[] { t };
		final Transfer[] dataTypes = new Transfer[] { TextTransfer.getInstance() };
		clipboard.setContents(data, dataTypes);
	}

	private void setClipboarHTML(String t) {
		final Object[] data = new Object[] { t };
		final Transfer[] dataTypes = new Transfer[] { HTMLTransfer.getInstance() };
		clipboard.setContents(data, dataTypes);
	}
}
