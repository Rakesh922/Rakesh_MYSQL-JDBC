package com.gl.jdbc.insert.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmployeeInsert {

	public static void main(String[] args) {
		Session session = null;
		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			System.out.println("Before creating session factory object");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("Factory object created... before opening session");
			session = sessionFactory.openSession();
			System.out.println("Inserting Record");
			Employee emp = new Employee();
			emp.setId(102); 
			emp.setName("Usha");
			emp.setPhone_Number("9524125632");
			emp.setEmail_Id("Usha67.gmail.com");
			Transaction tran=session.beginTransaction();
			session.persist(emp);
			tran.commit();
			System.out.println("Done");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//Actual emp row insertion will happen at this step
			try {
				session.flush();
				session.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}


