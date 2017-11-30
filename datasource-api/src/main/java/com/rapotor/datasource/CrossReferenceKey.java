package com.rapotor.datasource;

import com.raptor.datasource.node.IDataSourceNode;

public class CrossReferenceKey implements IDataSourceNode {

	private String sourceCode;
	private String sourceName;
	private String sourceType;
	
	private String targetCode;
	private String targetName;
	private String targetType;
	
	public CrossReferenceKey() {
		
	}

	@Override
	public String getId() {
		return sourceCode;
	}
	
	public void setId(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	@Override
	public String getNodeName() {
		return sourceName;
	}
	
	public void setEntityName(String sourceName) {
		this.sourceName = sourceName;
	}

	@Override
	public String getNodeType() {
		return sourceType;
	}
	
	public void setEntityType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getTargetCode() {
		return targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

}
