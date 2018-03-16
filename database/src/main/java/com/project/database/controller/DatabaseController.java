package com.project.database.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.database.dao.DatabaseDAO;
import com.project.database.data.CustomerData;
import com.project.database.data.OrderData;
import com.project.database.data.StockData;


@Controller
public class DatabaseController {
	
	@Autowired
	private DatabaseDAO custDao;
	
	@RequestMapping("/")
	public String customermaster() {
	      return "customermaster";
	}
	
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	public String createCustomer(HttpServletRequest htreq,HttpServletResponse htres, Model model) {
		CustomerData customerRequest=new CustomerData();
		
		String custid= htreq.getParameter("customerid");
		if(!custid.equals("create"))
		{
			customerRequest.setCustomerid(Integer.parseInt(custid));	
		}
		

		customerRequest.setContactperson(htreq.getParameter("contactperson"));
		customerRequest.setContactno(htreq.getParameter("contactno"));
		customerRequest.setEmail(htreq.getParameter("email"));
		customerRequest.setLocation(htreq.getParameter("location"));
		customerRequest.setName(htreq.getParameter("name"));
		
		custDao.createCustomer(customerRequest);
		List<CustomerData> list = custDao.getCustomerMaster();


		  model.addAttribute("lists", list);
		return "customerlist";
	    }	
	
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer custId, Model model) {
		CustomerData customerRequest=new CustomerData();
		customerRequest.setCustomerid(custId);
	    custDao.deleteContact(customerRequest);
	    List<CustomerData> list = custDao.getCustomerMaster();
	  
	    //Here "lists" refer to variable used in jsp page.
		  model.addAttribute("lists", list);
		  //The customerList refers to view name ie jsp name
		return "customerlist";
	}
	 
	
	@RequestMapping(value = "/customermaster", method = RequestMethod.GET)
	public String getdata( Model model) {
		 List<CustomerData> list = custDao.getCustomerMaster();
			  model.addAttribute("lists", list);
			return "customerlist";
	 }
	 
	 
	 @RequestMapping(value = "/customermasterdelete", method = RequestMethod.GET)
	public String getdeletedata( Model model) {
		 List<CustomerData> list = custDao.getCustomerMaster();
			  model.addAttribute("lists", list);
			return "customerlistwithdelete";
	 }
	 
	 
	 @RequestMapping(value = "/customermasteredit", method = RequestMethod.GET)
	public String geteditdata( Model model) {
		 List<CustomerData> list = custDao.getCustomerMaster();
			  model.addAttribute("lists", list);
			return "customermasterwithedit";
	 }
	
	 
	 @RequestMapping(value = "/getContact", method = RequestMethod.GET)
	public String getContactById(@RequestParam("id") Integer custId, Model model) {
			CustomerData customerRes=new CustomerData();
			customerRes= custDao.getacustomer(custId);
		   
			
			model.addAttribute("customer", customerRes);
			return "editcustomer";
		}


		@RequestMapping(value = "/addstock", method = RequestMethod.POST)
		public String addStock(HttpServletRequest htreq,HttpServletResponse htres, Model model) {
			StockData stk =new StockData();
			
			String stkid= htreq.getParameter("productid");
			
			if(!stkid.equals("create"))
			{
				stk.setProductid(Integer.parseInt(stkid));	
			}
			

			stk.setProductname(htreq.getParameter("productname"));
			stk.setPdtgrp(htreq.getParameter("pdtgrp"));
			stk.setMrp(Double.parseDouble(htreq.getParameter("MRP")));
			stk.setStock(Integer.parseInt(htreq.getParameter("stock")));
			
			custDao.addStock(stk);
			List<StockData> list = custDao.getStockMaster();


			  model.addAttribute("lists", list);
			return "stocklist";
		    }	
		
		

		@RequestMapping(value = "/stockmaster", method = RequestMethod.GET)
		public String getStock( Model model) {
			 List<StockData> list = custDao.getStockMaster();
				  model.addAttribute("lists", list);
				return "stocklist";
		 }
		 
		 
		 @RequestMapping(value = "/stockmasteredit", method = RequestMethod.GET)
		public String getEditStock( Model model) {
			 List<StockData> list = custDao.getStockMaster();
				  model.addAttribute("lists", list);
				return "stockmasterwithedit";
		 }
		
		 
		 @RequestMapping(value = "/getStock", method = RequestMethod.GET)
		public String getStockById(@RequestParam("id") Integer stkId, Model model) {
				StockData stkres =new StockData();
				stkres = custDao.getastock(stkId);
			   
		
				model.addAttribute("stk", stkres);
				return "editstock";
			}
		 
		 
		 
		 @RequestMapping(value = "/addorder", method = RequestMethod.POST)
			public String createOrderDetails(HttpServletRequest htreq,HttpServletResponse htres, Model model) {
				OrderData orderDetails =new OrderData();
				
				String orderId= htreq.getParameter("orderid");
				if(!orderId.equals("create"))
				{
					orderDetails.setOrderid(Integer.parseInt(orderId));	
				}
				

				orderDetails.setCustomerid(Integer.parseInt(htreq.getParameter("customerid")));
				orderDetails.setProductid(Integer.parseInt(htreq.getParameter("productid")));

				orderDetails.setStatus("Pending");
				orderDetails.setQty(Integer.parseInt(htreq.getParameter("qty")));
				
				orderDetails.setDiscount(Double.parseDouble(htreq.getParameter("discount")));

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				orderDetails.setOrderdate(dtf.format(localDate));
			
				/**
				 * Methdo to alculate gross and spl discount
				 */
				calculateGross(orderDetails);
				custDao.createOrder(orderDetails);
				List<OrderData> pendingOrderList = new ArrayList<>();
				
				pendingOrderList=custDao.getPendingList();


				  model.addAttribute("lists", pendingOrderList);
				return "pendingorderwithedit";
			    }	
			

private void calculateGross(OrderData order) {
	 if(order!=null && order.getProductid()!=0) {
		 StockData stkdetail =new StockData();
		 stkdetail = custDao.getastock(order.getProductid());
		 
		 if(stkdetail!=null) {
			 double newGross=0;
			 newGross=order.getQty()*stkdetail.getMRP();
			 order.setGross(newGross);
		 }
		 
		 if(order.getDiscount()!=0) {
		order.setNettotal(order.getGross()*(order.getDiscount()/100));	 
		 }
		   
	 }

}

@RequestMapping(value = "/pendingorder", method = RequestMethod.GET)
public String getPendingOrder( Model model) {
	 List<OrderData> list = custDao.getPendingList();
		  model.addAttribute("lists", list);
		return "pendingorderwithedit";
 }

@RequestMapping(value = "/completedorder", method = RequestMethod.GET)
public String getCompletedOrder( Model model) {
	 List<OrderData> list = custDao.getCompletedList();
		  model.addAttribute("lists", list);
		return "completedorder";
 }
@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public String getOrderById(@RequestParam("id") Integer orderId, Model model) {
			OrderData orderRes=new OrderData();
			orderRes= custDao.getaorder(orderId);
		   
			
			model.addAttribute("contact", orderRes);
			return "editpendingorder";
		}

}