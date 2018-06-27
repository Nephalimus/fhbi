package programming_internship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;


public class BMI extends JFrame{
	
	private JLabel lblGewicht = new JLabel("Gewicht:  ");
	private JLabel lblGroesse = new JLabel("Größe:  ");
	private JLabel lblBmi = new JLabel("BMI:  ");
	private static JTextField tfGewicht = new JTextField();
	private static JTextField tfGroesse = new JTextField();
	private static JTextField tfBmi = new JTextField();
	private JPanel pWest = new JPanel(new GridLayout(3,2,5,5));
	private JPanel pCenter = new JPanel(new GridLayout(3,2,5,5));
	private JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private static JButton btnCalculate = new JButton("Rechne!");

	public BMI() {
		
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
		tfGewicht.setPreferredSize(new Dimension(150,20));
		tfGroesse.setPreferredSize(new Dimension(150,20));
		tfBmi.setPreferredSize(new Dimension(150,20));
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
				double gewicht = 0;
				double groesse = 0;
				
				try{
					gewicht = new Double(tfGewicht.getText()).doubleValue();
				}catch(NumberFormatException e){
					tfBmi.setText("");
				}
				
				try {
					groesse = new Double(tfGroesse.getText()).doubleValue();
				} catch (NumberFormatException e) {
					tfBmi.setText("");
				}
				double bmi = gewicht/(groesse*groesse);
				DecimalFormat df = new DecimalFormat("#.##");
				String ausgabe = df.format(bmi);
				tfBmi.setText(ausgabe);
				
			}

		
		});
		
	}

}
