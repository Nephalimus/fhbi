package P2_20180605;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MyDnnamicList extends JFrame implements ActionListener, MouseListener{

	private DefaultListModel<String> dm = new DefaultListModel<String>();
	private JList<String> li = new JList<String>(dm);
	private JScrollPane spCenter = new JScrollPane(li);
	private JTextField tfInput = new JTextField();
	private JButton btnRemove = new JButton("Markiertes Element entfernen");
	private JTextArea ta = new JTextArea();
	private JScrollPane spEast = new JScrollPane(ta);
	private JLabel lblText = new JLabel("Bitte Text eingeben und mit RETURN bestätigen.");
	private JPanel pInput = new JPanel(new GridLayout(2, 1, 5, 5));
	private JPanel pAnzeige = new JPanel(new GridLayout(1, 2, 5, 5));

	public MyDnnamicList(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(200, 200);
		super.setSize(300, 320);

		// ================================================
		// Die im ScrollPane eingebettete Liste einfügen.
		this.pAnzeige.add(this.spCenter);
		// Selektionsmethode festlegen
		this.li.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Elemente über das ListDefaultModel einfügen.
		this.dm.addElement("Achtung!");
		this.dm.addElement("Kontrolle!!!");
		this.dm.addElement("Alles klar!");

		// ================================================
		// Die im ScrollPane eingebettete TextArea einfügen.
		this.pAnzeige.add(this.spEast);
		super.add(this.pAnzeige, BorderLayout.NORTH);
		//TextArea nicht editierbar
		this.ta.setEditable(false);
		
		// ================================================
		// Button zum entfernen eines Elements hinzufügen.
		super.add(this.btnRemove, BorderLayout.CENTER);

		// ================================================
		// Textfeld mit Label unter Zuhilfenahme eines JPanels einfügen.
		this.pInput.add(this.lblText);
		this.pInput.add(this.tfInput);
		this.lblText.setPreferredSize(new Dimension(300, 40));
		super.add(this.pInput, BorderLayout.SOUTH);

		// Steuerelemente mit einem Eventhandler verknüpfen.
		this.btnRemove.addActionListener(this);
		this.tfInput.addActionListener(this);
		this.li.addMouseListener(this);
		
		super.setVisible(true);
	}

	

	public static void main(String[] args) {
		new MyDnnamicList("MyDynamicList");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnRemove){
			// Anweisungen werden erst dann ausgeführt, wenn
			// Elemente in der Liste vorhanden sind und wenn davon
			// eines selektiert wurde.
			if (dm.getSize() > 0 && !li.isSelectionEmpty()) {
				// Element entfernen
				int index = li.getSelectedIndex();
				dm.removeElementAt(index);
				// Wenn möglich vorheriges Element markieren
				if (index > 0)
					li.setSelectedIndex(index - 1);
				else if (dm.getSize() > 0)
					li.setSelectedIndex(0);
			}
		}
		if(e.getSource() == this.tfInput){
			dm.addElement(tfInput.getText());
			tfInput.setText(null);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ta.append(li.getSelectedValue() + "\n");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
