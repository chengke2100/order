package com.iotek.ssm.entity;

import java.util.Date;

public class Order {
	private int id;
	private int cid;
	private String cname;
	private String address;
	private Date orderDate;//下单日期
	private Date deliverDate;//送货日期
	private String status;//订单状态
	public Order() {
		super();
	}
	public Order(int id, int cid, String cname, String address, Date orderDate, Date deliverDate, String status) {
		super();
		this.id = id;
		this.cid = cid;
		this.cname = cname;
		this.address = address;
		this.orderDate = orderDate;
		this.deliverDate = deliverDate;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cid=" + cid + ", cname=" + cname + ", address=" + address + ", orderDate="
				+ orderDate + ", deliverDate=" + deliverDate + ", status=" + status + "]";
	}
	

}
