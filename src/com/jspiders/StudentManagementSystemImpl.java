package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.example.Student;
import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByMarks;
import com.sortinglogic.SortStudentByName;

import CustomException.InvalidChoiceException;
import CustomException.StudentNotFoundException;

public class StudentManagementSystemImpl  implements  StudentManagementSystem{

	//collection->Database->Map&LinkedHashMAp->key(String)->value(student)
	//Scanner object
	Map<String, Student> db=new LinkedHashMap<String, Student>();
	Scanner s = new Scanner(System.in);
	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name");
		String name=s.next();
		System.out.println("Enter age:");
		int age=s.nextInt();
		System.out.println("Enter Marks");
		int marks=s.nextInt();

		Student s=new  Student(name, age ,marks);
		db.put(s.getId(), s);
		System.out.println("Student Records Inserted Successfully ");
		System.out.println("your Student Id is"+s.getId());

	}

	@Override
	public void displayStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id:");
		String id=s.next();
		id=id.toUpperCase();

		if(db.containsKey(id));{
			Student obj=db.get(id);
			System.out.println("Id: "+obj.getId());
			System.out.println("Name:"+obj.getName());
			System.out.println("Age:"+obj.getAge());
			System.out.println("Marks:"+obj.getMarks());
			//System.out.println(obj);

		}
	}

	{
		try {
			throw new StudentNotFoundException("Student Records Not found");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

		}
	}




	@Override
	public void displayAllStudents() {
		// TODO Auto-generated method stub

		Set<String> keys=db.keySet(); //"jsp101" "jsp102"
		System.out.println("Student  Records are as Follows:");
		System.out.println("---------------------------------");
		if(db.size()!=0)  {
			for(String key: keys) {
				System.out.println(db.get(key));//printing reference variable 
			}
		}
		else {
			try {  
				throw new StudentNotFoundException("Student Records Not Available to Display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}
	@Override
	public void removeStudent() {
		// TODO Auto-generated method stubvv
		//Accept the Id->String
		//uppercase
		//containskey()
		//remove()
		//else->SNFE->handle
		System.out.println("Enter Student Id:");
		String id=s.next().toUpperCase();
		//String id=s.next();
		//id=id.touppercase();
		if (db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted sucessfully");

		} else {
			try {
				throw new StudentNotFoundException("Student Record Not Found!");
			}
			catch(Exception e) {
				String message=e.getMessage();
				System.out.println(message);//System.out.println(e.getMessage);
			}
		}
	}




	@Override
	public void removeAllStudents() {
		// TODO Auto-generated method stub
		System.out.println("Total Students Records Available:"+db.size());
		db.clear();
		System.out.println("All Student Records Deleted Successfully");
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		//Accept Id& uppercase ,containskey,get the student object
		//switch case 1:update name,age,marks
		//invoke exception
		System.out.println("Enter Student Id:");
		String id=s.next().toUpperCase();
		if(db.containsKey(id)){
			Student std=db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter Choice:");
			int choice=s.nextInt();
			switch(choice) {
			//switch case 1:Update name age,Marks
			case 1:
				System.out.println("Enter Name:");
				String name=s.next();//std.setName(s.next());
				System.out.println("Name Upadated  Successfully");
				break;
			case 2:
				System.out.println("Enter Age");
				int age=s.nextInt();

				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=s.nextInt();//std.setMark(s.nextInt());
				std.setMarks(marks);
				System.out.println("Marks Updated Successfully");
				break;

			default:
				try {
					throw new  InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
		else {
			try {

				throw new StudentNotFoundException("Student Record Not Found!");
			}
			catch(Exception e) {
				String message=e.getMessage();
				System.out.println(message);//System.out.println(e.getMessage);
			}
		}

	}
	@Override
	public void countStudents() {
		// TODO Auto-generated method stub
		System.out.println("Total Number of Student Records:"+db.size());

	}

	@Override
	public void sortStudents() {
		// TODO Auto-generated method stub
		Set<String> keys=db.keySet();//"JSP101" "JSP102"
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));//Adding Student objects from Map to List
		}
		System.out.println("1:Sort By Id\n2:Sort By Name\n3Sort By Age");
		System.out.println("4:Sort By Marks\nEnter Choice");
		int choice=s.nextInt();

		switch(choice){
		case 1:
			Collections.sort(list, new SortStudentById());
			display(list);
			break;

		case 2:
			Collections.sort(list, new SortStudentByName());
			display(list);
			break;


		case 3:
			Collections.sort(list, new SortStudentByAge());
			display(list);
			break;



		case 4:
			Collections.sort(list, new SortStudentByMarks());
			for(Student s:list) {
				System.out.println(s);
			}
			break;

		default:
			try {
				throw new  InvalidChoiceException("Invalid Choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}


	}
}

