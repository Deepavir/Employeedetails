package com.example.Employee.payloads;

public class Employeedto {
	private int id;
	private String ename;
	private int edept;
	private int esal;
	private String dateofbirth;
	boolean deleted;
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Employeedto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employeedto(int id, String ename, int edept, int esal, String dateofbirth) {
		super();
		this.id = id;
		this.ename = ename;
		this.edept = edept;
		this.esal = esal;
		this.dateofbirth = dateofbirth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEdept() {
		return edept;
	}
	public void setEdept(int edept) {
		this.edept = edept;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
}
