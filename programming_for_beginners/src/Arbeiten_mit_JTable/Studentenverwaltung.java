package Arbeiten_mit_JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import src.Arbeiten_mit_JTable.ColoredTableCellRenderer;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.PatternSyntaxException;

@SuppressWarnings("all")
public class Studentenverwaltung extends JFrame {

	/*
	 * Globale Variablen, die �ber mehrere Methoden Verwendung finden und 
	 * desshalb f�r all diese Methoden sichtbar sein m�ssen.
	 */
	JTextField showMatrikelnummer;
	JTextField showName;
	JTextField showVorname;
	JTextField showDatum;
	JTextField searchText;
	JButton aendern;
	JButton loeschen;
	JButton speichern;
	JButton beenden;
	JButton hinzufuegen;
	JButton abbrechen;
	ListSelectionModel listmodel;
	JTable tabelle;
	DefaultTableModel dtm;
	TableRowSorter<DefaultTableModel> sorter;
	TreeMap<Integer,Student> studentenliste;
	/**
	 * Launch the application.
	 */
	

	public Studentenverwaltung(TreeMap<Integer,Student> studentenliste) {
		/* 
		 * Eigenschaften des Hauptfensters festlegen.
		 * Fenstergr��e soll nicht ge�ndert werden.
		 */
		super("Studentenverwaltung");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		/*
		 * Gr��e festlegen
		 */
		setSize( 450, 370);
		//setResizable(false);
		/*
		 * Displaygr��e ermitteln
		 */
		Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * Grafische Anzeige mittig auf dem Display anzeigen.
		 */
		super.setLocation((display.getSize().width-getSize().width)/2,(display.getSize().height-getSize().height)/2);
		/*
		 * Darstellung an das Look and Feel von Windows angleichen.
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		 * Deklaration der EventListener
		 */
		ActionListener myActionListener = new MyActionListener(this);
		DocumentListener mySearchListener = new MySearchListener(this);
		ListSelectionListener myListSelectionListener = new MyListSelectionListener(this);
		WindowListener myWindowListener = new MyWindowListener(this);
		addWindowListener(myWindowListener);
		/*
		 *  Deklaration eines �bergeorneten JPanels, in dem 
		 * im weiteren Verlauf zwei weitere JPanels eingef�gt werden sollen. 
		 */
		JPanel darstellung = new JPanel();
		darstellung.setLayout(new GridLayout(2, 1, 5, 5));

		/* 
		 * Deklaration eines JPanels, in dem eine Tabelle mit den erfassten 
		 * Studenten angezeigt werden soll.
		 */
		JPanel liste = new JPanel();
		/*
		 * Gr��e des JPanels festlegen, da es sonst in weiteren verlauf zu
		 * Problemen mit der Darstellung einer JScrollPane kommen k�nnte.
		 */
		liste.setPreferredSize(new Dimension(450,120));
		/*
		 * Das StandardLayout wird durch ein GridLayout ersetzt,
		 * da das FlowLayout keine Scrollbalken anzeigen kann.
		 */
		liste.setLayout(new GridLayout(1,1));
		/*
		 * Referenz der �bergebenen TreeMap wird der globalen TreeMap �bergeben.
		 * globale TreeMap wird f�r das Eventhandling ben�tigt, damit inder Eventklasse 
		 * MyActionListener die n�chste frei Matrikelnummer ermittelt werden kann.
		 */
		this.studentenliste = studentenliste;
		/*
		 * Die Values der treeMap werden in eine Collection
		 * �bertragen.
		 */
		LinkedList<Student> sliste = new LinkedList<Student>(studentenliste.values());
		/*
		 * Deklaration der Spalten�berschriften.
		 */
		String[] columnNames = { "Matrikelnummer", "Name", "Vorname","Geburtsdatum" };
		/*
		 * Die Daten, die in der Tabelle angezeigt werden sollen, werden in 
		 * ein zweistufigen Array geladen.
		 */
		Object[][] data = new Object[sliste.size()][4];
		for (int zeile = 0; zeile < sliste.size(); zeile++) {
			data[zeile][0] = Integer.toString(sliste.get(zeile).getMatrikelnummer());
			data[zeile][1] = sliste.get(zeile).getName();
			data[zeile][2] = sliste.get(zeile).getVorname();
			data[zeile][3] = sliste.get(zeile).getGeburtsdatum();
		}
		/*
		 * Initialisierung eines DefaultTableModel. Wird ben�tigt, um einzelne
		 * Zeilen im weiteren Programmverlauf entweder hinzuzuf�gen oder zu l�schen.
		 * Als Parameter werden die zufor festgelegten Spalten�berschriften
		 * und die eingelesenen Daten �bergeben.
		 */
		dtm = new DefaultTableModel(data, columnNames) {
			/*
			 * sorgt daf�r, dass Zellen nicht editierbar sind. Zeilen k�nnen
			 * jedoch ausgew�hlt werden
			 */
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		/*
		 * Initialisierung der Variablen tabelle. Als Parameter wird das DefaultTableModel
		 * dtm �bergeben.
		 */
		tabelle = new JTable(dtm);
		/*
		 * Festlegen, dass immer nur eine Zeile ausgew�hlt werden kann.
		 */
		tabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*
		 * Tabelle soll durch anklicken der �berschriften die gesamte Tabelle
		 * sortieren. Dabei gilt, dass durch mehrfaches anklicken der Palten�berschrift
		 * die Tabelle entwerde auf- oder absteigen sortiert werden kann. 
		 * Sortierkriterium ist die jeweilige Spalte, die angeklickt wird.
		 * Wenn nur nach der nat�rlichen Ordnung sortiert werden soll,
		 * reicht es aus, wenn die Tabelle wie folgt mit einem sortierer
		 * verkn�pft wird:
		 * 
		 * tabelle.setAutoCreateRowSorter(true);
		 */
		//tabelle.setAutoCreateRowSorter(true);
		
		/*
		 * Besitzen die Tabellen jedoch Spalten, die nicht nach der Nat�rlichen 
		 * Ordnung sortiert werden sollen, wie z.B. Datum, wird ein extra 
		 * TableRowSorter ben�tigt. 
		 * 
		 * Damit eine bestimmte Spalte auch wirklich nach Datum sortiert wird, 
		 * ist es erforderlich, dass ein entsprechender Komparator dazu erstellt 
		 * wird, welcher dann �ber die entsprechende Spalte gelegt wird.
		 * In diesem Beispiel ist es die vierte Spalte also Laufindex 3. 
		 */
		sorter = new TableRowSorter<DefaultTableModel>(dtm);
		tabelle.setRowSorter(sorter);
		sorter.setComparator(3, new DateComparator());
		/*
		 * selbiges gilt auch f�r die erste Spalte um ganze Zahlen, die als String in der Tabelle
		 * hinterlegt sind, nach der nat�rlichen Ordnung ganzer Zahlen zu sortieren.
		 */
		sorter.setComparator(0, new IntegerComparator());

		/*
		 * Farbgestaltung der Tabelle wird durch Verwendung der Klasse
		 * ColoredTableCellRenderer definiert. Jede zweite Zeile wird farblich hervorgehoben.
		 * Wird eine Zeile ausgew�hlt, wird dies wiederum durch eine farbliche 
		 * Hervorhebung angezeigt. Datumsanzeige wird ebenfalls angepasst (dd.mm.yyyy).
		 */
		tabelle.setDefaultRenderer(Object.class,new ColoredTableCellRenderer());		
		
		/*
		 * Damit eine Tabelle ein Event ausl�st, sobald eine Zeile ausgew�hlt ist,
		 * ist es erforderlich, eine Variable der Klasse ListSelectionModel zu deklarieren
		 * und diese mit dem SelectionModel der Tabelle zu initialisieren. Diese Variable
		 * wird anschlie�en beim Eventhandler LisSelectionListener registriert.
		 */
		listmodel = tabelle.getSelectionModel();
		listmodel.addListSelectionListener(myListSelectionListener);
		/*
		 * Da die Tabelle nicht vollst�ndig angezeigt wird, ist es Erforderlich, dass 
		 * die Tabelle durchgescrollt werden kann. Indem die Tabelle einem Objekt der 
		 * Klasse JScrollPane �bergeben wird, wird die Tabelle Scrollable gemacht.
		 * Dar�ber Hinaus werden die Tabellen�berschriften in die grafische Darstellung 
		 * eingef�gt.
		 */
		JScrollPane sp = new JScrollPane(tabelle);
		/*
		 * Die JScrollPane mit der Tabelle wird in das JPanel liste 
		 * eingef�gt.
		 */
		liste.add(sp);
		
		/*
		 * JPanel zur Anzeige der jeweiligen Details zu einem in der Tabelle selektiereten
		 * Studenten.
		 */
		JPanel details = new JPanel();
		/*
		 * Da lediglich Matrikelnummer, Name und Vorname abgezeigt werden sollen,
		 * werden zun�chst drei Zeilen ben�tigt. Da jedes o.g. Detail in einem JTextField
		 * angezeigt werden soll und die JTextFields einen davor stehenden Hinweistext erhalten 
		 * sollen, aus dem hervorgeht, was im dem nebenstehendenJTexrField dargestellt ist, 
		 * werden zwei Spalten ben�tigt.
		 */
		details.setLayout(new GridLayout(6, 2, 5, 5));
		/*
		 * Initialisierung der JTextFields
		 */
		showMatrikelnummer = new JTextField();
		showName = new JTextField();
		showVorname = new JTextField();
		showDatum = new JTextField();
		searchText = new JTextField();
		searchText.setBackground(Color.pink);
		/*
		 * Das JTextField Matrikelnummer soll nicht editierbar sein.
		 * Aus diesem Grund muss die Eigenschaft Editable auf false gesetzt werden.
		 */
		showMatrikelnummer.setEditable(false);
		/*
		 * Dem JPanel details werden nacheinander die Elemente �bergeben.
		 */
		details.add(new JLabel("Suchbegriff: ",JLabel.RIGHT));
		details.add(searchText);
		details.add(new JLabel("Matrikelnummer: ",JLabel.RIGHT));
		details.add(showMatrikelnummer);
		details.add(new JLabel("Name: ",JLabel.RIGHT));
		details.add(showName);
		details.add(new JLabel("Vorname: ",JLabel.RIGHT));
		details.add(showVorname);
		details.add(new JLabel("Geburtsdatum: ",JLabel.RIGHT));
		details.add(showDatum);
	
		/*
		 * Deklaration eine JPanels, in dem die Steuerelemente wie z.B. JButton
		 * aufgenommen werden sollen. Steuerelemente sollen rechtsb�ndig angeordnet werden
		 */
		JPanel aktionen = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		/*
		 * Deklaration der JButtons
		 */
		aendern = new JButton("�ndern");
		loeschen = new JButton("L�schen");
		beenden = new JButton("Speichern und Beenden");
		hinzufuegen = new JButton("Hinzuf�gen");
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		/*
		 * Hinzuf�gen der Steuerelemente in das JPanel aktionen
		 */
		aktionen.add(aendern);
		aktionen.add(loeschen);
		aktionen.add(hinzufuegen);
		aktionen.add(beenden);
		aktionen.add(speichern);
		aktionen.add(abbrechen);
		
		/*
		 * Registrieren der Steuerelemente beim ActionListener
		 */
		aendern.addActionListener(myActionListener);
		loeschen.addActionListener(myActionListener);
		beenden.addActionListener(myActionListener);
		hinzufuegen.addActionListener(myActionListener);
		speichern.addActionListener(myActionListener);
		abbrechen.addActionListener(myActionListener);
		speichern.setVisible(false);
		abbrechen.setVisible(false);
		searchText.getDocument().addDocumentListener(mySearchListener); 

		
		/*
		 * Das JPanel darstellung erh�lt nacheinander die JPanel liste und details
		 */
		darstellung.add(liste);
		darstellung.add(details);

		/*
		 * Das Hauptfenster bekommt die JPanel darstellung und aktionen �bergeben.
		 */
		add(darstellung, BorderLayout.NORTH);
		add(aktionen, BorderLayout.SOUTH);
		/*
		 * Alle Elemente werden f�r den Desktop sichtbar gemacht.
		 */
		setVisible(true);
	}

	
}
