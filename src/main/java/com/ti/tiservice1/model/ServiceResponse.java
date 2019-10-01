/**
 * 
 */
package com.ti.tiservice1.model;

import java.util.Objects;

/**
 * @author duansubramaniam
 *
 */
public class ServiceResponse {
	private String name;

	
	/**
	 * 
	 */
	public ServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param name
	 */
	public ServiceResponse(String name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceResponse other = (ServiceResponse) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
