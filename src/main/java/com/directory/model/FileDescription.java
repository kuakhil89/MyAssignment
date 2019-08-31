package com.directory.model;

import java.io.Serializable;

/**
 * @author R_Legend
 *
 */
public class FileDescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937713562544652837L;
	
	private String fileName;
	private String fileDescription;
	private String fileSize;
	private String flagValue;
	
	
	public String getFlagValue() {
		return flagValue;
	}
	public void setFlagValue(String flagValue) {
		this.flagValue = flagValue;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileDescription [fileName=");
		builder.append(fileName);
		builder.append(", fileDescription=");
		builder.append(fileDescription);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", flagValue=");
		builder.append(flagValue);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @param fileName
	 * @param fileDescription
	 * @param fileSize
	 * @param flagValue
	 */
	public FileDescription(String fileName, String fileDescription, String fileSize, String flagValue) {
		super();
		this.fileName = fileName;
		this.fileDescription = fileDescription;
		this.fileSize = fileSize;
		this.flagValue = flagValue;
	}
	public FileDescription() {
		super();
	}
	
	

}
