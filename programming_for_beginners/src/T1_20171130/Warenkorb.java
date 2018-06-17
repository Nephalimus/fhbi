package T1_20171130;

public class Warenkorb {
	
	private int warenkorbId;
	private Kunde kunde;
	private Bestellung[] liste;
	private int pos;

	public Warenkorb(int warenkorbId, Kunde kunde) {
		this.warenkorbId = warenkorbId;
		this.kunde = kunde;
		this.liste = new Bestellung[10];
		this.pos = 0;
	}

	public int getWarenkorbId() {
		return warenkorbId;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public Bestellung[] getListe() {
		return liste;
	}
	
	public void addBestellung(Bestellung bestellung){
		boolean bereitsBestellt = false;
		for(int i = 0 ; i < liste.length && liste[i] != null; i++){
			if(liste[i].getArtikel().getArtikelnummer() == bestellung.getArtikel().getArtikelnummer()){
				liste[i].setAnzahl(liste[i].getAnzahl()+bestellung.getAnzahl());
				bereitsBestellt = true;
			}
		}
		if( !bereitsBestellt){
			if(this.pos <liste.length ){
				this.liste[this.pos++] = bestellung;
			}else{
				System.out.println("Sehr geehrte(r) "  + this.kunde.getAnrede() + " " + this.kunde.getName());
				System.out.println("Ihr Warenkorb is voll!");
				System.out.println("Folgende Bestellung kann nicht mehr aufgenommen werden:");
				System.out.println(bestellung);
			}
		}
	}
	
	public void removeBestellung(int pos){
		if(liste[pos-1] != null){
			liste[pos-1] = null;
			while(pos < liste.length && liste[pos] != null){
				liste[pos-1] = liste[pos];
				liste[pos] = null;
				pos++;
			}
			this.pos--;
		}else{
			System.out.println("Sehr geehrte(r) "  + this.kunde.getAnrede() + " " + this.kunde.getName());
			System.out.println("Die Bestellung mit der Positionsnummer " + pos + " konnte nicht gelöscht werden.");
		}
	}
	
	public void druckeListe(){
		System.out.println();
		System.out.println("Ausgabe Warenkorb Kunde: " + this.kunde.getName());
		for(int i = 0 ; i < liste.length && liste[i] != null; i++){
			System.out.println("Position " + (i+1) + ": " + liste[i]);
		}
	}

}
