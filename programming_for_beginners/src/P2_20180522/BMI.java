package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMI extends JFrame{
	
	private JLabel lblGewicht = new JLabel("Gewicht:  ");
	private JLabel lblGroesse = new JLabel("Größe:  ");
	private JLabel lblBmi = new JLabel("BMI:  ");
	private JTextField tfGewicht = new JTextField();
	private JTextField tfGroesse = new JTextField();
	private JTextField tfBmi = new JTextField();
	private JPanel pWest = new JPanel(new GridLayout(3,1,5,5));
	private JPanel pCenter = new JPanel(new GridLayout(3,1,5,5));
	private JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JButton btnCalculate = new JButton("Calculate!");

	public BMI() {
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(100, 100);
		super.setTitle("BMI");
		
		pWest.add(this.lblGewicht);
		pWest.add(this.lblGroesse);
		pWest.add(this.lblBmi);
		this.lblGewicht.setHorizontalAlignment(JLabel.RIGHT);
		this.lblGroesse.setHorizontalAlignment(JLabel.RIGHT);
		this.lblBmi.setHorizontalAlignment(JLabel.RIGHT);

		
		pCenter.add(this.tfGewicht);
		pCenter.add(this.tfGroesse);
		pCenter.add(this.tfBmi);
		this.tfGewicht.setPreferredSize(new Dimension(170,30));
		this.tfGroesse.setPreferredSize(new Dimension(170,30));
		this.tfBmi.setPreferredSize(new Dimension(170,30));
		
		pSouth.add(this.btnCalculate);
		
		super.add(pWest,BorderLayout.WEST);
		super.add(pCenter,BorderLayout.CENTER);
		
		super.add(pSouth,BorderLayout.SOUTH);
		
		super.pack();
		
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new BMI();

	}

}
