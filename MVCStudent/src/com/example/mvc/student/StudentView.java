package com.example.mvc.student;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StudentView implements IView, ActionListener{
	private StudentController controller;
	private StudentModel model;
	
	JFrame viewFrame;
	JPanel viewPanel;
	JLabel semesterLabel;
	JLabel studentLabel;
	
	JFrame controlFrame;
	JPanel controlPanel;
	JButton increaseButton;

	
	public StudentView(StudentController scontroller, StudentModel smodel)
	{
		controller = scontroller;
		model = smodel;
		model.anmelden(this);
		createElements();
		createControlElements();
	}
	
	public void createElements()
	{
		viewPanel = new JPanel(new GridLayout(1,2));
		studentLabel = new JLabel(model.getName());
		semesterLabel = new JLabel(model.getSemester());
		viewPanel.add(studentLabel);
		viewPanel.add(semesterLabel);
		viewFrame = new JFrame("Student View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.getContentPane().add(viewPanel,BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
		
	}
	
	
	public void createControlElements()
	{
		controlPanel = new JPanel(new GridLayout(1,2));
		increaseButton = new JButton("Increase");
		increaseButton.addActionListener(this);
		controlPanel.add(increaseButton);
		controlFrame = new JFrame("Control Panel");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.getContentPane().add(controlPanel,BorderLayout.CENTER);
		controlFrame.pack();
		controlFrame.setVisible(true);
	}
	
	/**
	 * Diese Methode wird vom Model aufgerufen,
	 * wenn sich das Model verändert hat.
	 * 
	 */
	public void aktualisieren(IModel model)
	{
		
		// hier vervollständigen
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == increaseButton)
		{
			controller.increase();
		}
		
	}
}