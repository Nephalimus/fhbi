package programming_internship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

@SuppressWarnings("all")

public class BMI extends JFrame{
	private static JFrame currentwindow;
	private JLabel lblGewicht = new JLabel("Gewicht:  ");
	private JLabel lblGroesse = new JLabel("Größe:  ");
	private JLabel lblBmi = new JLabel("BMI:  ");
	private static JTextField tfGewicht = new JTextField();
	private static JTextField tfGroesse = new JTextField();
	private static JTextField tfBmi = new JTextField();
	private JPanel pWest = new JPanel(new GridLayout(3,1,20,5));
	private JPanel pCenter = new JPanel(new GridLayout(3,1,20,5));
	private JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private static JButton btnCalculate = new JButton("Rechne!");

	public BMI() {
		currentwindow = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setTitle("BMI");
		
		pWest.add(lblGewicht);
		pWest.add(lblGroesse);
		pWest.add(lblBmi);
		lblGewicht.setHorizontalAlignment(JLabel.RIGHT);
		lblGroesse.setHorizontalAlignment(JLabel.RIGHT);
		lblBmi.setHorizontalAlignment(JLabel.RIGHT);

		
		pCenter.add(tfGewicht);
		pCenter.add(tfGroesse);
		pCenter.add(tfBmi);
		tfGewicht.setPreferredSize(new Dimension(150,30));
		tfGroesse.setPreferredSize(new Dimension(150,30));
		tfBmi.setPreferredSize(new Dimension(150,30));
		tfBmi.setEditable(false);
		
		pSouth.add(this.btnCalculate);
		
		add(pWest,BorderLayout.WEST);
		add(pCenter,BorderLayout.CENTER);
		add(pSouth,BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new BMI();

		btnCalculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				tfGewicht.setText(tfGewicht.getText().replace(",","."));
				double gewicht = pruefen(tfGewicht.getText(),tfGewicht);
				
				tfGroesse.setText(tfGroesse.getText().replace(",","."));
				double groesse = pruefen(tfGroesse.getText(),tfGroesse);
	
				double bmi;
				try {
					bmi = gewicht/(groesse*groesse);
					DecimalFormat df = new DecimalFormat("#.##");
					String ausgabe = df.format(bmi);
					tfBmi.setText(ausgabe);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
		});
		
	}
	

	public static double pruefen(String wert, JTextField feldn) {
		double dwert;
		try{
			dwert =  new Double(wert).doubleValue();
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(currentwindow, "Eingabefehler - Zahl erwartet");
			dwert=0;
			feldn.setText("0");
		}
		return dwert;
	}

}
