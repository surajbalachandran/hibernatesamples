package com.blogspot.javaclickonline.hibernatesample.domain;

import java.io.Serializable;

public class Communication implements Serializable {

	private static final long serialVersionUID = -9187195303573596589L;

	private Long communicationId;
	private String homePhoneNo;
	private String businessPhoneNo;
	private String faxNo;
	/**
	 * @return the communicationId
	 */
	public Long getCommunicationId() {
		return communicationId;
	}
	/**
	 * @param communicationId the communicationId to set
	 */
	public void setCommunicationId(Long communicationId) {
		this.communicationId = communicationId;
	}
	/**
	 * @return the homePhoneNo
	 */
	public String getHomePhoneNo() {
		return homePhoneNo;
	}
	/**
	 * @param homePhoneNo the homePhoneNo to set
	 */
	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}
	/**
	 * @return the businessPhoneNo
	 */
	public String getBusinessPhoneNo() {
		return businessPhoneNo;
	}
	/**
	 * @param businessPhoneNo the businessPhoneNo to set
	 */
	public void setBusinessPhoneNo(String businessPhoneNo) {
		this.businessPhoneNo = businessPhoneNo;
	}
	/**
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}
	/**
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessPhoneNo == null) ? 0 : businessPhoneNo.hashCode());
		result = prime * result
				+ ((communicationId == null) ? 0 : communicationId.hashCode());
		result = prime * result + ((faxNo == null) ? 0 : faxNo.hashCode());
		result = prime * result
				+ ((homePhoneNo == null) ? 0 : homePhoneNo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Communication other = (Communication) obj;
		if (businessPhoneNo == null) {
			if (other.businessPhoneNo != null)
				return false;
		} else if (!businessPhoneNo.equals(other.businessPhoneNo))
			return false;
		if (communicationId == null) {
			if (other.communicationId != null)
				return false;
		} else if (!communicationId.equals(other.communicationId))
			return false;
		if (faxNo == null) {
			if (other.faxNo != null)
				return false;
		} else if (!faxNo.equals(other.faxNo))
			return false;
		if (homePhoneNo == null) {
			if (other.homePhoneNo != null)
				return false;
		} else if (!homePhoneNo.equals(other.homePhoneNo))
			return false;
		return true;
	}
}
