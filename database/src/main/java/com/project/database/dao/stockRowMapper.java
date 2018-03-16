package com.project.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.database.data.StockData;

public class stockRowMapper implements RowMapper<StockData>
{
    @Override
    public StockData mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
    	StockData astk = new StockData();
   	 
    	astk.setProductid(rs.getInt("productid"));
        astk.setProductname(rs.getString("productname"));
        astk.setPdtgrp(rs.getString("pdtgrp"));
        astk.setMrp(rs.getInt("MRP"));
        astk.setStock(rs.getInt("stock"));
        

        return astk;
    }}