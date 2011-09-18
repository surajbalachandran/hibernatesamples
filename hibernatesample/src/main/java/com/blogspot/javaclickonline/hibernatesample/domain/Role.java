/**
 * 
 */
package com.blogspot.javaclickonline.hibernatesample.domain;

import java.io.Serializable;

/**
 * @author suraj.balachandran
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1044247324516287377L;
	
	private Long roleId;
	private String roleName;
	private String roleDescription;
	
	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}
	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
