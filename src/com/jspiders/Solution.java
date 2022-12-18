package com.jspiders;

import java.util.Scanner;



import CustomException.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//To Accept Input From the user
		Scanner scan=new Scanner(System.in);
		//upcasting for achieving Abstracstion
		StudentManagementSystem  sms=new   StudentManagementSystemImpl();
		while(true) {
		System.out.println("Welcome to Student Databse Project");
		System.out.println("----------------------------------");
		System.out.println("1:Add Student\n2:Display Student");
		System.out.println("3:display All Students\n4removeStudent");
		System.out.println("5:removeAllStudents\n6updateStudent");
		System.out.println("7:count Students\n8sort Students");
		System.out.println("9:EXIT\nEnter Choice");
		
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			  sms.addStudent();
		      break;
		      
		case 2:
			  sms.displayStudent();
			  break;
		case 3:
			  sms.displayAllStudents();
			  break;
			  
		case 4:
			  sms.removeStudent();
			  break;
			  
		case 5:
			  sms.removeAllStudents();
			  break;
		case 6:
			   sms.updateStudent();
			   break;
			   
		case 7:
			sms.countStudents();
			break;
		case 8:
			 sms.sortStudents();
			 break;
			 
		case 9:
			System.out.println("Thank you");
			System.exit(0);
			
			
			default:
				try {
					 throw new  InvalidChoiceException(" Invalid Choice, Kindly Enter valid choice");
				}
				catch(Exception e) {
					
					System.out.println(e.getMessage());
				}
		}
	}
}
}