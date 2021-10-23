package com.zensar.Model;

public class Student 
{
	private int sid;
	private String sname;
	private String qualification;
	private String placed;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		System.out.println("in setter sid");
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPlaced() {
		return placed;
	}
	public void setPlaced(String placed) {
		this.placed = placed;
	}
	public Student(int sid, String sname, String qualification, String placed) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.qualification = qualification;
		this.placed = placed;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", qualification=" + qualification + ", placed=" + placed
				+ "]";
	}
	
	
}
