package net.mong.style;

import net.mong.style.configurer.ExcelCellStyleConfigurer;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class CustomExcelCellStyle implements ExcelCellStyle {

	private ExcelCellStyleConfigurer configurer = new ExcelCellStyleConfigurer();

	public CustomExcelCellStyle() {
		configure(configurer);
	}

	public abstract void configure(ExcelCellStyleConfigurer configurer);

	@Override
	public void apply(CellStyle cellStyle, Workbook wb) {
		configurer.configure(cellStyle, wb);
	}

}
