package com.te.backend.backend.one;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import register.EmployeeInfo;
/*This class is for main application which will display options for user to do some operations
 *  like storing the data in each table and getting that data and manipulating that data*/
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Method m = new Method();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		int w = 1;
		while (w==1) {
			System.out.println("================WELCOME=====================");
			System.out.println("Enter the operation :");
			System.out.println("Enter 1 to Register\nEnter 2 to Login\nEnter 3 to exit");
			Scanner sc = new Scanner(System.in);
			int option1 = sc.nextInt();
			EmployeeInfo empo = new EmployeeInfo();
			switch (option1) {
			case 1:

			{
				System.out.println("Enter the Employee Details to Register");
				sc.nextLine();
				System.out.println("Enter the Employee Name:");
				String name = sc.nextLine();
				System.out.println("Enter the Employee Type :");
				String type = sc.nextLine();
				System.out.println("Enter E-mail :");
				String email = sc.nextLine();
				System.out.println("Enter the Password");
				String password = sc.nextLine();
				// EmployeeInfo empo=new EmployeeInfo();
				empo.setEmployee_name(name);
				empo.setEmployee_type(type);
				empo.setEmail(email);
				empo.setPassword(password);
				System.out.println("==========REGISTERING THE EMPLOYEE DETAILS======");
				entityTransaction.begin();
				entityManager.persist(empo);
				entityTransaction.commit();
				System.out.println("============SUCCESSFULLY REGISTERED=================");
				System.out.println("Your Employee-ID is :" + empo.getEmployee_id());
				System.out.println("                                       ");
				System.out.println("Keep this for future reference");
				break;
			}
			case 2: {
				System.out.println("Enter the login details:");
				System.out.println("Enter the Employee id:");
				int id = sc.nextInt();
				System.out.println("Enter the Password");
				sc.nextLine();
				String password = sc.nextLine();
				m.check(id, password);

			}
			default:{
				
				break;
			}

			}
		}
	}

}


