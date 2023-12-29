package com.gl.jdbc.insert.bean;

public class Employee implements java.io.Serializable {
	int Id;
	String Name;
	String Email_Id;
	String Phone_Number;
	
	
	
	public Employee(int id, String name, String email_Id, String phone_Number) {
		Id = id;
		Name = name;
		Email_Id = email_Id;
		Phone_Number = phone_Number;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Email_Id=" + Email_Id + ", Phone_Number=" + Phone_Number
				+ "]";
	}
	
	
}