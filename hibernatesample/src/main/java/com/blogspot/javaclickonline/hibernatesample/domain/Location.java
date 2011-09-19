package com.blogspot.javaclickonline.hibernatesample.domain;

public class Location extends Customer {

	private static final long serialVersionUID = 3884288530177834344L;
	private String locationNo;
	private String locationName;
	/**
	 * @return the locationNo
	 */
	public String getLocationNo() {
		return locationNo;
	}
	/**
	 * @param locationNo the locationNo to set
	 */
	public void setLocationNo(String locationNo) {
		this.locationNo = locationNo;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result
				+ ((locationNo == null) ? 0 : locationNo.hashCode());
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
		Location other = (Location) obj;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (locationNo == null) {
			if (other.locationNo != null)
				return false;
		} else if (!locationNo.equals(other.locationNo))
			return false;
		return true;
	}
}
