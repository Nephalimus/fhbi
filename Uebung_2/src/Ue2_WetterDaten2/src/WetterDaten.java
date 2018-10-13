package Ue2_WetterDaten2.src;

public interface WetterDaten {

	public void registriereAnzeige(Anzeige anzeige);
	
	public void entferneAnzeige(Anzeige anzeige);

	public void benachrichtigeAnzeigen();
	
	public void setMesswerte(double temp, double feucht, double druck);
	
}
