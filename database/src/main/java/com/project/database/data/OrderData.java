package com.project.database.data;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderData {
	
	int orderid;
	int customerid;
	int productid;
	String orderdate;
	String status;
	int qty;
	double gross;
	double discount;
	double nettotal;
	String payment;
	
	public OrderData() {
		
	}
	
	
	public OrderData(int orderid, int customerid, int productid, String orderdate, String status, int qty, double gross,
			double discount, double nettotal, String payment) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.orderdate = orderdate;
		this.status = status;
		this.qty = qty;
		this.gross = gross;
		this.discount = discount;
		this.nettotal = nettotal;
		this.payment = payment;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getGross() {
		return gross;
	}
	public void setGross(double gross) {
		this.gross = gross;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNettotal() {
		return nettotal;
	}
	public void setNettotal(double nettotal) {
		this.nettotal = nettotal;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	
	

}
