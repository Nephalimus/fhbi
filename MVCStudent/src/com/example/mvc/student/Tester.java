package com.example.mvc.student;
import java.util.Vector;


public class Tester {

	public static void main(String[] args)
	{
		StudentModel studentModel = new StudentModel("Meier", "432843", 3);
		StudentController studentController = new StudentController(studentModel);
		
		StudentView studentView = new StudentView(studentController, studentModel);
		
		
	}
}
