package net.mong.style.configurer;

import net.mong.style.align.ExcelAlign;
import net.mong.style.align.NoExcelAlign;
import net.mong.style.border.ExcelBorders;
import net.mong.style.border.NoExcelBorders;
import net.mong.style.color.DefaultExcelColor;
import net.mong.style.color.ExcelColor;
import net.mong.style.color.NoExcelColor;
import net.mong.style.font.ExcelFont;
import net.mong.style.font.NoExcelFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelCellStyleConfigurer {

	private ExcelAlign excelAlign = new NoExcelAlign();
	private ExcelColor foregroundColor = new NoExcelColor();
	private ExcelBorders excelBorders = new NoExcelBorders();
	private ExcelFont excelFont = new NoExcelFont();

	public ExcelCellStyleConfigurer() {

	}

	public ExcelCellStyleConfigurer excelAlign(ExcelAlign excelAlign) {
		this.excelAlign = excelAlign;
		return this;
	}

	public ExcelCellStyleConfigurer foregroundColor(int red, int blue, int green) {
		this.foregroundColor = DefaultExcelColor.rgb(red, blue, green);
		return this;
	}

	public ExcelCellStyleConfigurer excelBorders(ExcelBorders excelBorders) {
		this.excelBorders = excelBorders;
		return this;
	}

	public ExcelCellStyleConfigurer excelFont(ExcelFont excelFont) {
		this.excelFont = excelFont;
		return this;
	}


	public void configure(CellStyle cellStyle, Workbook wb) {
		excelAlign.apply(cellStyle);
		foregroundColor.applyForeground(cellStyle);
		excelBorders.apply(cellStyle);
		excelFont.apply(cellStyle, wb);
	}

}
