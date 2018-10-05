package io.shivamvk.springmongo.error;

public class Error {
	
	private int errorStatus;
	private String errorMessage;	
	
	public Error(int errorStatus, String errorMessage) {
		super();
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}
	public int getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
