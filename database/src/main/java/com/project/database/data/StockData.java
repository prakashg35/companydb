package com.project.database.data;

public class StockData {
	
	int productid;
	double MRP;
	int stock;
	private String productname;
	private String pdtgrp;
	
	public StockData() {
		
	}
	
	
	
	public StockData(int productid, double MRP, int stock, String productname, String pdtgrp) {
		super();
		this.productid = productid;
		this.MRP = MRP;
		this.stock = stock;
		this.productname = productname;
		this.pdtgrp = pdtgrp;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public double getMRP() {
		return MRP;
	}
	public void setMrp(double MRP) {
		this.MRP = MRP;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPdtgrp() {
		return pdtgrp;
	}
	public void setPdtgrp(String pdtgrp) {
		this.pdtgrp = pdtgrp;
	}
	
}
