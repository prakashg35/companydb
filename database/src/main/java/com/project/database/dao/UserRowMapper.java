package com.project.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.database.data.CustomerData;

public class UserRowMapper implements RowMapper<CustomerData>
{
    @Override
    public CustomerData mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
    	CustomerData aContact = new CustomerData();
   	 
        aContact.setCustomerid(rs.getInt("customerid"));
        aContact.setName(rs.getString("name"));
        aContact.setContactperson(rs.getString("contactperson"));
        aContact.setLocation(rs.getString("location"));
        aContact.setContactno(rs.getString("contactno"));
        aContact.setEmail(rs.getString("email"));
        

        return aContact;
    }}