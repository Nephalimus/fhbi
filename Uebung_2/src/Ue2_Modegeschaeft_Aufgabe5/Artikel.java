package Ue2_Modegeschaeft_Aufgabe5;

import java.util.List;

/**
 * Text Artikel
 * @author Oliver
 * @version 1.0
 * @updated 18-Okt-2018 11:45:14
 */
public class Artikel {

	private int artikelnummer;
	private String bezeichnung;
	private String marke;
	private double preis;
	private String status;
	public List<Lieferant> m_Lieferant;
	public List<Groesse> m_Groesse;

	public Artikel(){

	}

	public void finalize() throws Throwable {

	}
}//end Artikel