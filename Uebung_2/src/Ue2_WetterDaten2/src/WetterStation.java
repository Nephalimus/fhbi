package Ue2_WetterDaten2.src;

public class WetterStation {
	
	public static void main(String[] args) {
		WetterDaten wetterDaten = new WetterDatenImp();
		
		AnzeigenFactory factory = new AnzeigenFactory();
		Anzeige aktuelleAnzeige = factory.createAktuelleAnzeige(wetterDaten);
		Anzeige statistikAnzeige = factory.createStatistikAnzeige(wetterDaten);
		Anzeige vorhersageAnzeige = factory.createVorhersageAnzeige(wetterDaten);
		
		
		wetterDaten.setMesswerte(30, 65, 30.4f);
		wetterDaten.setMesswerte(32, 70, 29.2f);
		wetterDaten.setMesswerte(27, 90, 29.2f);
	}


}
