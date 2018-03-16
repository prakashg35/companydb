package com.project.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.database.data.CustomerData;
import com.project.database.data.OrderData;
import com.project.database.data.StockData;
import com.project.database.dao.UserRowMapper;

@Repository
public class DatabaseDAOImpl implements DatabaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void createCustomer(CustomerData newcustomer) {

		if (newcustomer.getCustomerid() > 0) {

			String sql = "UPDATE CUSTOMER SET NAME=?, CONTACTPERSON=?, LOCATION=?,CONTACTNO=?, EMAIL=? WHERE customerid=?";
			jdbcTemplate.update(sql, newcustomer.getName(), newcustomer.getContactperson(), newcustomer.getLocation(),
					newcustomer.getContactno(), newcustomer.getEmail(), newcustomer.getCustomerid());
		} else {
			String sql = "INSERT INTO CUSTOMER(NAME,CONTACTPERSON, LOCATION, CONTACTNO, EMAIL) VALUES(?,?,?,?,?)";

			jdbcTemplate.update(sql, newcustomer.getName(), newcustomer.getContactperson(), newcustomer.getLocation(),
					newcustomer.getContactno(), newcustomer.getEmail());

		}

	}

	@Override
	public void deleteCustomer(CustomerData customer) {

		String sql = "DELETE FROM customer WHERE name=?";
		jdbcTemplate.update(sql, customer.getName());
	}

	@Override
	public void deleteContact(CustomerData customer) {

		String sql = "DELETE FROM customer WHERE customerid=?";
		jdbcTemplate.update(sql, customer.getCustomerid());
	}

	@Override
	public List<CustomerData> getCustomerMaster() {
		String sql = "SELECT * FROM customer";
		List<CustomerData> listcustomer = jdbcTemplate.query(sql, new UserRowMapper());
		return listcustomer;

	}

	@Override
	public CustomerData getacustomer(int customerId) {
		String sql = "SELECT * FROM customer WHERE customerid=" + customerId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<CustomerData>() {

			@Override
			public CustomerData extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					CustomerData contact = new CustomerData();
					contact.setCustomerid(rs.getInt("customerId"));
					contact.setName(rs.getString("name"));
					contact.setContactperson(rs.getString("contactperson"));
					contact.setLocation(rs.getString("location"));
					contact.setContactno(rs.getString("contactno"));
					contact.setEmail(rs.getString("email"));
					return contact;
				}

				return null;
			}

		});
	}

	@Override
	public void addStock(StockData newstock) {

		if (newstock.getProductid() > 0) {

			String sql = "UPDATE STOCK SET PRODUCTNAME=?, PDTGRP=?, MRP=?,STOCK=? WHERE PRODUCTID=?";
			jdbcTemplate.update(sql, newstock.getProductname(), newstock.getPdtgrp(), newstock.getMRP(),
					newstock.getStock(), newstock.getProductid());
		} else {
			String sql = "INSERT INTO STOCK(PRODUCTNAME, PDTGRP, MRP, STOCK) VALUES(?,?,?,?)";

			jdbcTemplate.update(sql, newstock.getProductname(), newstock.getPdtgrp(), newstock.getMRP(),
					newstock.getStock());

		}

	}

	@Override
	public List<StockData> getStockMaster() {
		String sql = "SELECT * FROM stock";

		List<StockData> liststock = jdbcTemplate.query(sql, new stockRowMapper());
		return liststock;

	}

	/**
	 * Methdo to fetch a stock details based on stokd id
	 */
	@Override
	public StockData getastock(int productId) {
		String sql = "SELECT * FROM stock WHERE productid=" + productId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<StockData>() {

			@Override
			public StockData extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					StockData stk = new StockData();
					stk.setProductid(rs.getInt("productid"));
					stk.setProductname(rs.getString("productname"));
					stk.setPdtgrp(rs.getString("pdtgrp"));
					stk.setMrp(rs.getInt("MRP"));
					stk.setStock(rs.getInt("stock"));
					return stk;
				}

				return null;
			}

		});
	}

	@Override
	public void createOrder(OrderData neworder) {
		
		if (neworder.getOrderid() > 0) {
	       
	       
	       String sql= "update bill b,stock s set b.qty=:quantity,b.gross=(s.mrp*:quantity),orderdate=current_date() "
	       		+ "where b.productid=s.productid and b.productid=:pdtid";
	       
	       Map parameter= new HashMap<>();
	       
	       parameter.put("quantity", neworder.getQty());
	       parameter.put("pdtid", neworder.getProductid());
	       
	       
	       namedParameterJdbcTemplate.update(sql, parameter);
	    } else {
	    	String sql = "INSERT INTO BILL(CUSTOMERID, PRODUCTID, ORDERDATE, STATUS, QTY, GROSS, DISCOUNT, NETTOTAL, PAYMENT) VALUES(?,?,?,?,?,?,?,?,?)";
            
	         jdbcTemplate.update(sql, neworder.getCustomerid(), neworder.getProductid(),neworder.getOrderdate(), neworder.getStatus(),
	       						neworder.getQty(),neworder.getGross(),neworder.getDiscount(), 
	       						neworder.getNettotal(),neworder.getPayment());
	    		}
	    }

	@Override
	public List<OrderData> getPendingList() {
		String sql = "SELECT * FROM bill where status='pending'";
		List<OrderData> pendingorder = jdbcTemplate.query(sql, new OrderRowMapper());
		return pendingorder;

	}

	@Override
	public List<OrderData> getCompletedList() {
		String sql = "SELECT * FROM bill where status='delivered'";
		List<OrderData> completedorder = jdbcTemplate.query(sql, new OrderRowMapper());
		return completedorder;

	}

	@Override
	public OrderData getaorder(int orderid) {
		String sql = "SELECT * FROM bill WHERE orderid=" + orderid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<OrderData>() {

			@Override
			public OrderData extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					OrderData order = new OrderData();
					order.setOrderid(rs.getInt("orderid"));
					order.setCustomerid(rs.getInt("customerid"));
					order.setProductid(rs.getInt("productid"));
					order.setOrderdate(rs.getString("orderdate"));
					order.setStatus(rs.getString("status"));
					order.setQty(rs.getInt("qty"));
					order.setGross(rs.getDouble("gross"));
					order.setDiscount(rs.getDouble("discount"));
					order.setNettotal(rs.getDouble("nettotal"));
					order.setPayment(rs.getString("payment"));
					return order;
				}

				return null;
			}

		});

	}



	@Override
	public OrderData getorderbyname(String customer) {
		// TODO Auto-generated method stub
		return null;
	}


}
