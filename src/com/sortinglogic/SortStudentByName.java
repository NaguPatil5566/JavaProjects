package com.sortinglogic;

import java.util.Comparator;

import com.example.Student;

public class SortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());
	}

}
