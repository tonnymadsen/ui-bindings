package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.swt.dnd.Clipboard;
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
public class ClipboardConverterManagerTests {
	public Clipboard clipboard = IManager.Factory.getManager().getClipboard();

	/**
	 * Tests comma-separated-values
	 */
	@Test
	public void testCSV() {
		setClipboarText("1,2,3,4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 2, new String[][] { new String[] { "1,2,3,4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV1() {
		setClipboarText("1 2 3 4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 2, new String[][] { new String[] { "1 2 3 4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV2() {
		setClipboarText("1 2\t3 4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(3, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" } });
		testOneResult(res.get(1), 1, new String[][] { new String[] { "1 2", "3 4" } });
		testOneResult(res.get(2), 1, new String[][] { new String[] { "1 2\t3 4" } });
	}

	/**
	 * Tests space-separated-values
	 */
	@Test
	public void testSSV3() {
		setClipboarText("1 2 3 4\n4 3 2 1");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2", "3", "4" },
				new String[] { "4", "3", "2", "1" } });
		testOneResult(res.get(1), 2, new String[][] { new String[] { "1 2 3 4" }, new String[] { "4 3 2 1" } });
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
		testOneResult(res.get(1), 1, new String[][] { new String[] { "1\t2\t3\t4" } });
	}

	/**
	 * Tests irregular text...
	 */
	@Test
	public void testIrregular() {
		setClipboarText("1 2\t3 4\n1");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(1, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1 2\t3 4" }, new String[] { "1" } });
	}

	/**
	 * Tests multiple results - sorted correctly
	 */
	@Test
	public void testTwoResults() {
		setClipboarText("1,2\t3,4");
		final List<IResult> res = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		assertEquals(2, res.size());

		testOneResult(res.get(0), 1, new String[][] { new String[] { "1", "2\t3", "4" } });
		testOneResult(res.get(1), 2, new String[][] { new String[] { "1,2", "3,4" } });
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
}
