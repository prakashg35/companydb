package com.project.database.data;

public class CustomerData {
	
	@Override
	public String toString() {
		return "CustomerData [customerid=" + customerid + ", name=" + name + ", contactperson=" + contactperson
				+ ", location=" + location + ", contactno=" + contactno + ", email=" + email + "]";
	}
	int customerid;
	private String name;
	private String contactperson;
	private String location;
	private String contactno;
	private String email;
		
	public CustomerData() {
			}
	public CustomerData(int customerid, String name, String contactperson, String location, String contactno,
			String email) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.contactperson = contactperson;
		this.location = location;
		this.contactno = contactno;
		this.email = email;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
