package com.cg.login.pojo;

public class Error {
	private String errorType;
	private String errorCode;
	private String errorText;

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	@Override
	public String toString() {
		return "Error [errorType=" + errorType + ", errorCode=" + errorCode + ", errorText=" + errorText + "]";
	}
	
	

}
