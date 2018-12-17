package com.cg.login.pojo;

public class Interface {

	private String interfaceId;
	private String sourceId;
	private String targetId;

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	@Override
	public String toString() {
		return "Interface [interfaceId=" + interfaceId + ", sourceId=" + sourceId + ", targetId=" + targetId + "]";
	}
	
	

}
