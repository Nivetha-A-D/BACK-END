//package com.te.backend.backend.one;
//
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import register.EmpLeaveInfo;
//import register.EmployeeInfo;
//
//public class Existed {
//	public static void main(String[] args) {
//		
//	
//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
//	EntityManager entityManager = entityManagerFactory.createEntityManager();
//	EntityTransaction entityTransaction = entityManager.getTransaction();
//	System.out.println("Hello Existed data");
//	//Existed employee info   
//	EmployeeInfo einfo1 =new EmployeeInfo();
//	einfo1.setEmployee_name("Anand");
//	einfo1.setEmployee_type("Employee");
//	einfo1.setEmail("anand@gmail.com");
//	einfo1.setPassword("anand@te");
//	
//	EmployeeInfo einfo2 =new EmployeeInfo();
//	einfo2.setEmployee_name("Prabhakaran");
//	einfo2.setEmployee_type("Employee");
//	einfo2.setEmail("prabhakaran@gmail.com");
//	einfo2.setPassword("prabahkaran@te");
//	
//	EmployeeInfo einfo3 =new EmployeeInfo();
//	einfo3.setEmployee_name("Vijay");
//	einfo3.setEmployee_type("Manager");
//	einfo3.setEmail("vijay@gmail.com");
//	einfo3.setPassword("vijaymanager@tem");
//	
//	EmployeeInfo einfo4 =new EmployeeInfo();
//	einfo4.setEmployee_name("Dhivya");
//	einfo4.setEmployee_type("Manager");
//	einfo4.setEmail("dhivyamanager@gmail.com");
//	einfo4.setPassword("dhivyamanager@tem");
//	
//	EmpLeaveInfo leave1=new EmpLeaveInfo();
//	leave1.setLeave_date("01-05-2022");
//	leave1.setLeave_status("Approved");
//	
//	
//
//	EmpLeaveInfo leave2=new EmpLeaveInfo();
//	leave2.setLeave_date("06-05-2022");
//	leave2.setLeave_status("Pending");
//	
//	EmpLeaveInfo leave3=new EmpLeaveInfo();
//	leave3.setLeave_date("02-05-2022");
//	leave3.setLeave_status("Approved");
//	
//	EmpLeaveInfo leave4=new EmpLeaveInfo();
//	leave4.setLeave_date("10-05-2022");
//	leave4.setLeave_status("Pending");
//	
//	
//	
//	
//	entityTransaction.begin();
//	entityManager.persist(einfo1);
//	entityManager.persist(einfo2);
//	entityManager.persist(einfo3);
//	entityManager.persist(einfo4);
//	entityManager.persist(leave1);
//	entityManager.persist(leave2);
//	entityManager.persist(leave3);
//	entityManager.persist(leave4);
//	
//	entityTransaction.commit();
//	
//	
//	}
//}
