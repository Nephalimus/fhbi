package Ue2_Modegeschaeft_Aufgabe5;

import java.util.Date;
import java.util.List;

import Ue2_Online_Modegeschaeft.Artikel;

/**
 * Text MItarbeiter
 * @author Oliver
 * @version 1.0
 * @updated 18-Okt-2018 11:45:14
 */
public class Mitarbeiter {

	private String benutzername;
	private Date einstellungsdatum;
	private String email;
	private String nachname;
	private String passwort;
	private String vorname;
	public List<Artikel> m_Artikel;

	public Mitarbeiter(){

	}

	public void finalize() throws Throwable {

	}
}//end Mitarbeiter