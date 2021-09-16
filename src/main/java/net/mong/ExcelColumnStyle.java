package net.mong;


import net.mong.style.ExcelCellStyle;

public @interface ExcelColumnStyle {
	Class<? extends ExcelCellStyle> excelCellStyleClass();
	String enumName() default "";
	boolean bold() default false;
}
