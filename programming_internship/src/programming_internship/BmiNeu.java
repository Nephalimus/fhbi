package programming_internship;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class BmiNeu extends JFrame{
	
	private JTextField gewicht = new JTextField();
	private JTextField groesse = new JTextField();
	private JTextField bmi = new JTextField();
	private JButton rechne = new JButton("Rechne!");
	private ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			calculate();
		}
	};
	private DocumentListener docListener = new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			if(!bmi.hasFocus()) {
				calculate();
			}
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			if(!bmi.hasFocus()) {
				calculate();
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			if(!bmi.hasFocus()) {
				calculate();
			}
		}
	};
	private DocumentListener bmiToWeight = new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			if(bmi.hasFocus()) {
				calculateBmiToWeight();
			}
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			if(bmi.hasFocus()) {
				calculateBmiToWeight();
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			if(bmi.hasFocus()) {
				calculateBmiToWeight();
			}
		}
	};
	
	
	public BmiNeu() {
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle("BMI");
		super.setBounds(500,200,200,200);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 10, 20);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(new JLabel("Gewicht:", SwingConstants.RIGHT), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gewicht.getDocument().addDocumentListener(docListener);
		gewicht.setPreferredSize(new Dimension(100, 20));
		this.add(gewicht, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(new JLabel("Größe:", SwingConstants.RIGHT), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		groesse.getDocument().addDocumentListener(docListener);
		this.add(groesse, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(new JLabel("BMI:", SwingConstants.RIGHT), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
//		bmi.setEditable(false);
		bmi.getDocument().addDocumentListener(bmiToWeight);
		this.add(bmi, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		rechne.addActionListener(action);
//		this.add(rechne, gbc);
		
		super.pack();
		super.setVisible(true);
	}

	public void calculate() {
		if(!groesse.getText().isEmpty() && !gewicht.getText().isEmpty()) {
			NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
			try {
				int kgVal = format.parse(gewicht.getText()).intValue();
				double mVal = format.parse(groesse.getText()).doubleValue();
				if(mVal > 100) {
					mVal /= 100;
				}
				double bmiVal = kgVal / (mVal * mVal);
				bmi.setText(String.format(Locale.GERMAN, "%2.2f", bmiVal));
			} catch (ParseException e1) {
				bmi.setText("Fehler");
			}
		}
	}
	
	public void calculateBmiToWeight() {
		if(!groesse.getText().isEmpty()) {
			NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
			try {
				double bmiVal = format.parse(bmi.getText()).doubleValue();
				double mVal = format.parse(groesse.getText()).doubleValue();
				if(mVal > 100) {
					mVal /= 100;
				}
				double kgVal = (mVal * mVal) * bmiVal;
				gewicht.setText(String.format(Locale.GERMAN, "%.0f", kgVal));
			} catch (ParseException e1) {
				//bmi.setText("Fehler");
			}
		}
	}

	public static void main(String[] args) {
		new BmiNeu();
	}

}
