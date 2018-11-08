package com.example.mvc.student;
public class StudentController {
	private StudentModel model;
	private StudentView view;
	
	public StudentController(StudentModel smodel)
	{
		model = smodel;
		
	}
	
	
	/**
	 * Der Button wurde gedrückt und verändert.
	 * 
	 */
	public void increase() {
		
		model.increaseSemester();
		
		
	}
}