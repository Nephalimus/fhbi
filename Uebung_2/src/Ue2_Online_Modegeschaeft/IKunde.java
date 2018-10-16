package Ue2_Online_Modegeschaeft;

public interface IKunde {

	int getKundenID();

	int getRabatt();
	
	void setKundenID(int kundenID);

	String getNachname();

	void setNachname(String nachname);

	String getVorname();

	void setVorname(String vorname);

	Warenkorb getWarenkorb();

}