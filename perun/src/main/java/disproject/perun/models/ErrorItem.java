package disproject.perun.models;

import java.io.Serializable;

public class ErrorItem implements Serializable {
	
	private String ean13;
	
	private String errorReason;

	public ErrorItem() {
		super();
	}
	
	public ErrorItem(String ean13, String errorReason) {
		super();
		this.ean13 = ean13;
		this.errorReason = errorReason;
	}

	public String getEan13() {
		return ean13;
	}

	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	
}
