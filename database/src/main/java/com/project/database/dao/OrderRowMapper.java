package com.project.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.database.data.OrderData;

public class OrderRowMapper implements RowMapper<OrderData>
{
    @Override
    public OrderData mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
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
  }