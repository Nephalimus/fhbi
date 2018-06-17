package P2_20180529;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MyMenue extends JFrame {
	/* Vereinbaren der Steuerelemente als Klassensteuerlemente */
	private JMenuItem open = new JMenuItem("öffnen", 'ö');
	private JMenuItem close = new JMenuItem("schließen");
	private JMenuItem save2 = new JMenuItem("Netzlaufwerk", 'n');
	private JMenuItem save1 = new JMenuItem("lokler Desktop");
	private JMenuItem save0 = new JMenuItem("speichern");
	private JMenuItem help= new JMenuItem("Hilfe");
	private JCheckBoxMenuItem linux = new JCheckBoxMenuItem("Linux", false);
	private JCheckBoxMenuItem java = new JCheckBoxMenuItem("Java", true);
	private JCheckBoxMenuItem windows = new JCheckBoxMenuItem("Windows", false);
	private JMenu file = new JMenu("Datei");
	private JMenu layout = new JMenu("Layout");
	private JMenu save = new JMenu("speichern unter");

	/* Konstruktor mit Beerbung von Ober-Klasse */
	public MyMenue(String title) {
		/* Definition der Fenstereigenschaften */
		super(title);
		super.setSize(300, 100);
		super.setLocation(200,200);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Platzieren der Menüleiste im Hauptfenster */
		addMenu();
		registriereListener();
		super.setVisible(true);
	}

	public void addMenu() {
		/* Menüleiste erstellen */
		JMenuBar menubar = new JMenuBar();
		
		/* Menü zur Menüleiste hinzufügen */
		menubar.add(file);
		/*
		 * Menüsteuerung über die Taste d definieren. Durch drücken von Alt+ d
		 * wird im Fenster das Chart aufgeklappt, in dem Menüelemente enthalten
		 * sind
		 */
		file.setMnemonic('d');
		
		/* Menüelemente zum Menü hinzufügen */
		file.add(open );
		file.add(save0);
		
		/* Tastensteuerungskombination für save0 auf CTRL+s ändern */
		KeyStroke speichern = KeyStroke.getKeyStroke('S', Event.CTRL_MASK);
		save0.setAccelerator(speichern);
		
		/* Untermenü im Menü file erstellen */
		file.add(save);
		save.setMnemonic('u');
		save.add(save1 );
		save.add(save2);
		file.addSeparator();
		file.add(help );
		/*
		 * Menüsteuerung über die Funktionstaste F1 definieren. Durch drücken
		 * von F1 wird der Menüeintrag Hilfe aufgrufen
		 */
		KeyStroke hilfe = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
		help.setAccelerator(hilfe);
		file.add(close );
		/*
		 * Menüsteuerung über die Funktionstaste ESC definieren. Durch drücken
		 * von ESC wird der Menüeintrag schließen aufgrufen
		 */
		KeyStroke closeKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		close.setAccelerator(closeKey);
		/* CheckBoxelemente hinzufügen */
		menubar.add(layout);
		layout.setMnemonic('l');
		layout.add(linux);
		layout.add(java);
		layout.add(windows);
		/* Gruppieren der CheckBoxelemente */
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(linux);
		bg1.add(java);
		bg1.add(windows);
		setJMenuBar(menubar);
	}

	public void registriereListener(){
		this.open.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Öffnen wurde gewählt!");
			}
			
		});
		
		this.close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Schließen wurde gewählt!");
			}
			
		});
		
		this.save0.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Speichern wurde gewählt!");
			}
			
		});
		
		this.save1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("lokaler Desktop wurde gewählt!");
			}
			
		});
		this.save2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Netzlaufwerk wurde gewählt!");
			}
			
		});
		this.help.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hilfe wurde gewählt!");
			}
			
		});
	}
	
	public static void main(String[] args) {
		new MyMenue("MyMenu");
	}
}
