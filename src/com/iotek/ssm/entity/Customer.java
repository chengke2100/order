package com.iotek.ssm.entity;

public class Customer {
	private int id;
	private String name;
	private String cusAddress;
	public Customer() {
		super();
	}
	public Customer(int id, String name, String cusAddress) {
		super();
		this.id = id;
		this.name = name;
		this.cusAddress = cusAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", cusAddress=" + cusAddress + "]";
	}
	
	
}
