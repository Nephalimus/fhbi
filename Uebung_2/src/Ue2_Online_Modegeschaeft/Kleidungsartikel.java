package Ue2_Online_Modegeschaeft;

/**
* Unterklasse der Klasse Artikel. Speichert zusätzlich
* das verwendete Material ab.
*/
public class Kleidungsartikel extends Artikel{

	private String material;
	
	public Kleidungsartikel(int aNr, String bez, double pr, String mat){
		super(aNr, bez, pr);
		this.material = mat;
	}
	
	public String getMaterial(){
		return material;
	}
	
	public void setMaterial(String mat){
		this.material = mat;
	}
	
}
