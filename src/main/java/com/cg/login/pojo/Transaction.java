package com.cg.login.pojo;

public class Transaction {

	private String versionId;
	private Environment environment;
	private Interface iinterface;
	private TransactionDetails transactionDetails;
	private Error error;

	// private Extension extension;
	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Interface getIinterface() {
		return iinterface;
	}

	public void setIinterface(Interface iinterface) {
		this.iinterface = iinterface;
	}

	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Transaction [versionId=" + versionId + ", environment=" + environment + ", iinterface=" + iinterface
				+ ", transactionDetails=" + transactionDetails + ", error=" + error + "]";
	}

}
