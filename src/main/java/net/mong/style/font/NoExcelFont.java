package net.mong.style.font;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

public final class NoExcelFont implements ExcelFont {
	@Override
	public void apply(CellStyle cellStyle, Workbook wb) {
		// Do nothing
	}
}
