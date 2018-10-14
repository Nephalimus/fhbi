package Ue2_Modegeschaeft_Aufgabe5;

import java.util.Date;

import Ue2_Online_Modegeschaeft.Artikel;

/**
 * Text MItarbeiter
 * @author Oliver
 * @version 1.0
 * @updated 14-Okt-2018 20:39:02
 */
public class Mitarbeiter {

	private String benutzername;
	private Date einstellungsdatum;
	private String email;
	private String nachname;
	private String passwort;
	private String vorname;
	public Artikel m_Artikel;

	public Mitarbeiter(){

	}

	public void finalize() throws Throwable {

	}
}//end Mitarbeiter