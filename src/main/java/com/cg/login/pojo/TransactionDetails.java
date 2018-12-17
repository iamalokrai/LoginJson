package com.cg.login.pojo;

public class TransactionDetails {
	private String correlationId;
	private String businessId;
	private String executionTime;
	private String executionPoint;
	private String executionMessage;
	private String executionStatus;
	private String payload;
	private Extension extension;

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getExecutionTime() {		 
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}

	public String getExecutionPoint() {
		return executionPoint;
	}

	public void setExecutionPoint(String executionPoint) {
		this.executionPoint = executionPoint;
	}

	public String getExecutionMessage() {
		return executionMessage;
	}

	public void setExecutionMessage(String executionMessage) {
		this.executionMessage = executionMessage;
	}

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "TransactionDetails [correlationId=" + correlationId + ", businessId=" + businessId + ", executionTime="
				+ executionTime + ", executionPoint=" + executionPoint + ", executionMessage=" + executionMessage
				+ ", executionStatus=" + executionStatus + ", payload=" + payload + ", extension=" + extension + "]";
	}

}
