/**
 * 
 */
package com.project.database.dao;

import java.util.List;

import com.project.database.data.CustomerData;
import com.project.database.data.OrderData;
import com.project.database.data.StockData;



public interface DatabaseDAO {
	
	public void createCustomer(CustomerData newcustomer);
	
	public  List<CustomerData> getCustomerMaster();
	
	public void deleteCustomer(CustomerData customer);
    
	public CustomerData getacustomer(int customer);

	/**
	 * deleteContact will delete based on given customer id
	 * @author Prakash G
	 * @param customer
	 */
	void deleteContact(CustomerData customer);
   
	public void addStock(StockData newstock);
	
	public  List<StockData> getStockMaster();

	public StockData getastock(int stock);
	

	
	public void createOrder(OrderData neworder);
	
	public List<OrderData> getPendingList();
	
	public List<OrderData> getCompletedList();

	public OrderData getorderbyname(String customer);
	public OrderData getaorder(int order);
	

}

