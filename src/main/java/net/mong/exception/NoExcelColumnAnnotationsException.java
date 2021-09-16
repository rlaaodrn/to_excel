package net.mong.exception;

import net.mong.ExcelException;

public class NoExcelColumnAnnotationsException extends ExcelException {

	public NoExcelColumnAnnotationsException(String message) {
		super(message, null);
	}

}
