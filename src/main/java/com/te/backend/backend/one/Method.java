package com.te.backend.backend.one;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import register.EmpLeaveInfo;
import register.EmployeeInfo;
/*This class is for methods that defines how to store and update changes in each table
 * This method gets called from App.java according to the user input*/
public class Method {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc = new Scanner(System.in);

	/*To store the employee details in a table*/
	public void empreg(int id, String name, String type, String email, String password) {
		
		String str = "insert into EmployeeInfo e set  e.employee_name=:name,e.employee_type=:type,e.email=:email,e.password=:password ";
		Query query = entityManager.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("name", name);
		query.setParameter("type", type);
		query.setParameter("email", email);
		query.setParameter("password", password);
		entityTransaction.begin();
		int executeUpdate = query.executeUpdate();
		entityTransaction.commit();
		System.out.println("Rows affected:" + executeUpdate);

	}

	public void levreg(int id, String date, String status) {
		String str = "update EmpLeaveInfo set  leave_date=:date,leave_status=:status where employee_id=:id";
		Query query = entityManager.createQuery(str);
		query.setParameter("id", id);
		query.setParameter("date", date);
		query.setParameter("status", status);
		entityTransaction.begin();
		int executeUpdate = query.executeUpdate();
		entityTransaction.commit();
		System.out.println("Rows affected:" + executeUpdate);

	}

	public void check(int id, String password) {
		System.out.println("hi");
		String str = " from EmployeeInfo";
		Query query = entityManager.createQuery(str);
		System.out.println("=============VALIDATING DETAILS=========");
		List list = query.getResultList();
		for (Object object : list) {
			EmployeeInfo employeeInfo = (EmployeeInfo) object;
			String uPassword = employeeInfo.getPassword();
			int uId = employeeInfo.getEmployee_id();
			if (uPassword.equals(password) && uId == id) {
				System.out.println("=================================");
				System.out.println("        Logged in Succesfully          ");
				if (employeeInfo.getEmployee_type().equalsIgnoreCase("Manager")) {
					int m=1;
					while(m==1) {
					System.out.println(
							"Enter 1 to Show all Leave Request of Employees\nEnter 2 to Approve Leave Request");
					int op2 = sc.nextInt();
					switch (op2) {
					case 1: {
						System.out.println("====DISPLAYING ALL LEAVE REQUESTS=====");
						String str3 = " from EmpLeaveInfo";
						Query query3 = entityManager.createQuery(str3);
						List list3 = query3.getResultList();
						for (Object object3 : list3) {
							EmpLeaveInfo mleave = (EmpLeaveInfo) object3;
							System.out.println(mleave);
						}
						break;
					}
					case 2: {
						System.out.println("Approve /Reject the Leave Request");
						System.out.println("Enter the Employee_ID to approve/reject their leave status");
						int id4 = sc.nextInt();
						System.out.println("Enter 	Approved to Approval");
						System.out.println("Enter Reject To Reject");
						sc.nextLine();
						String s = sc.nextLine();

						String str4 = " update EmpLeaveInfo set leave_status=:status where employee_id=:id ";
//						
						Query query4 = entityManager.createQuery(str4);
						query4.setParameter("id", id4);
						query4.setParameter("status", s);
//						
						entityTransaction.begin();
						query4.executeUpdate();
						entityTransaction.commit();
						break;

					}
					}
					break;
					}

				} else {
					System.out.println("Enter 1 to Show all your Leave status\nEnter 2 to Request for Leave");
					int op = sc.nextInt();
					switch (op) {
					case 1: {
						System.out.println("Displaying your leave status");
						String str1 = " from EmpLeaveInfo";
						Query query1 = entityManager.createQuery(str1);
						System.out.println("============FETCHING DETAILS=========");
						List list1 = query1.getResultList();
						for (Object object2 : list1) {
							EmpLeaveInfo eleave = (EmpLeaveInfo) object2;
							System.out.println(eleave);
						}

						break;

					}
					case 2:
						System.out.println("Requesting for leave");
						System.out.println("Enter Leave date :");
						sc.nextLine();
						String date = sc.nextLine();
						EmpLeaveInfo leave = new EmpLeaveInfo();
						leave.setLeave_date(date);
						System.out.println("=======REQUESTING FOR A LEAVE============");
						entityTransaction.begin();
						entityManager.persist(leave);
						entityTransaction.commit();
						System.out.println("======Your request is added, current status ->PENDING  =====");
						System.out.println("=========Check after sometimes to ensure it is updated/rejected==========");
						break;
					}
					break;
				}

			} else {
				System.out.println("Not a registered employee............");
				System.out.println("Register to Login.............");
			}
		}

	}
}
