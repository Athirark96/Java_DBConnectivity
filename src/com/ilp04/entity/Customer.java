package com.ilp04.entity;

public class Customer {

	private int customerCode;
	private String customerFirstname;
	private String customerLastname;
	private String address;
	private long phNumber;
	private long adhaarNo;
	public Customer(String customerFirstname, String customerLastname, String address, long phone_Number,
			long adhaar_Number) {
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.address = address;
		this.phNumber = phone_Number;
		this.adhaarNo = adhaar_Number;
	}
	public Customer(int customerCode, String customerFirstname, String customerLastname, String address, long phNumber,
			long adhaarNo) {
		super();
		this.customerCode = customerCode;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.address = address;
		this.phNumber = phNumber;
		this.adhaarNo = adhaarNo;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFirstname() {
		return customerFirstname;
	}
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}
	public String getCustomerLastname() {
		return customerLastname;
	}
	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}
	public long getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(long adhaarNo) {
		this.adhaarNo = adhaarNo;
	}
	
	
	
}
