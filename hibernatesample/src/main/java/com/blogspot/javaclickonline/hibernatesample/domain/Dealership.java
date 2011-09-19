package com.blogspot.javaclickonline.hibernatesample.domain;

public class Dealership extends Customer {

	private static final long serialVersionUID = -3248601548153913539L;
	private String dealerNo;
	private String dbaName;
	/**
	 * @return the dealerNo
	 */
	public String getDealerNo() {
		return dealerNo;
	}
	/**
	 * @param dealerNo the dealerNo to set
	 */
	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}
	/**
	 * @return the dbaName
	 */
	public String getDbaName() {
		return dbaName;
	}
	/**
	 * @param dbaName the dbaName to set
	 */
	public void setDbaName(String dbaName) {
		this.dbaName = dbaName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dbaName == null) ? 0 : dbaName.hashCode());
		result = prime * result
				+ ((dealerNo == null) ? 0 : dealerNo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dealership other = (Dealership) obj;
		if (dbaName == null) {
			if (other.dbaName != null)
				return false;
		} else if (!dbaName.equals(other.dbaName))
			return false;
		if (dealerNo == null) {
			if (other.dealerNo != null)
				return false;
		} else if (!dealerNo.equals(other.dealerNo))
			return false;
		return true;
	}
}
