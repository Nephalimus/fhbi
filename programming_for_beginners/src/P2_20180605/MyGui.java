package P2_20180605;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("all")
public class MyGui extends JFrame {

	private JPanel contentPane;
	private JButton btnButton;
	private JTextField tfEingabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui frame = new MyGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyGui() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 5, 5));
		
		tfEingabe = new JTextField();
		contentPane.add(tfEingabe);
		tfEingabe.setColumns(10);
		
		btnButton = new JButton("New button");
		contentPane.add(btnButton);
		ActionListener al = new MyListener(this);
		WindowListener wl = new MyListener(this);
		
		this.btnButton.addActionListener(al);
		this.tfEingabe.addActionListener(al);
		super.addWindowListener(wl);
		
		
		
		
		setVisible(true);
	}

	public JButton getBtnButton() {
		return btnButton;
	}

	public JTextField getTfEingabe() {
		return tfEingabe;
	}
	
	

}
