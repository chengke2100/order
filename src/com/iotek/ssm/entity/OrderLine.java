package com.iotek.ssm.entity;

public class OrderLine {
	private int id;
	private int oid;
	private String productName;
	private float productPrice;
	private int productNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", oid=" + oid + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productNumber=" + productNumber + "]";
	}
	
}
