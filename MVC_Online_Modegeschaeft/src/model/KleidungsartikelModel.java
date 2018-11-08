package model;



/**
* Unterklasse der Klasse Artikel. Speichert zusätzlich
* das verwendete Material ab.
*/
public class KleidungsartikelModel extends ArtikelModel{

	private String material;
	
	public KleidungsartikelModel(int aNr, String bez, double pr, String mat){
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
