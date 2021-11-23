package net.mong.excel.onesheet;

import net.mong.excel.SXSSFExcelFile;
import net.mong.excel.XSSFExcelFile;
import net.mong.resource.DataFormatDecider;

import java.util.List;

public final class OneSheetExcelFileXSSF<T> extends XSSFExcelFile<T> {

	private static final int ROW_START_INDEX = 0;
	private static final int COLUMN_START_INDEX = 0;
	private int currentRowIndex = ROW_START_INDEX;

	public OneSheetExcelFileXSSF(Class<T> type) {
		super(type);
	}

	public OneSheetExcelFileXSSF(List<T> data, Class<T> type) {
		super(data, type);
	}

	public OneSheetExcelFileXSSF(List<T> data, Class<T> type, DataFormatDecider dataFormatDecider) {
		super(data, type, dataFormatDecider);
	}

	@Override
	protected void validateData(List<T> data) {
		int maxRows = supplyExcelVersion.getMaxRows();
		if (data.size() > maxRows) {
			throw new IllegalArgumentException(
					String.format("This concrete ExcelFile does not support over %s rows", maxRows));
		}
	}

	@Override
	public void renderExcel(List<T> data) {
		// 1. Create sheet and renderHeader
		sheet = wb.createSheet();
		renderHeadersWithNewSheet(sheet, currentRowIndex++, COLUMN_START_INDEX);

		if (data.isEmpty()) {
			return;
		}

		// 2. Render Body
		for (Object renderedData : data) {
			renderBody(renderedData, currentRowIndex++, COLUMN_START_INDEX);
		}

		// 3. Auto Size
		int idx=0;
		for (String dataFieldName : resource.getDataFieldNames()) {
			//sheet.trackAllColumnsForAutoSizing();
			sheet.autoSizeColumn(idx);
			sheet.setColumnWidth(idx,sheet.getColumnWidth(idx)+500);
			idx++;
		}
	}

	@Override
	public void addRows(List<T> data) {
		renderBody(data, currentRowIndex++, COLUMN_START_INDEX);
	}

}
