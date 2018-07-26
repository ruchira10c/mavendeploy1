package com.ibm.model;

public class Department {
	
	private int deptId;
	private String deptName;
	private int locId;
	
	public Department(){}
	
	public Department(int deptId, String deptName, int locId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.locId = locId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	
	

}
