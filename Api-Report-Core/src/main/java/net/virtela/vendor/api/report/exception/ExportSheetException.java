package net.virtela.vendor.api.report.exception;

public class ExportSheetException extends Exception {

	private static final long serialVersionUID = 7339029313246663473L;

	private String error;
	
	public ExportSheetException() {
		super();
		this.error = "Can't established connection to api!";
	}

	public ExportSheetException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.error = message;
	}

	public ExportSheetException(String message, Throwable cause) {
		super(message, cause);
		this.error = message;
	}

	public ExportSheetException(String message) {
		super(message);
		this.error = message;
	}

	public ExportSheetException(Throwable cause) {
		super(cause);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
