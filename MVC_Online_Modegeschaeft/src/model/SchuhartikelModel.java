package model;



/**
* Unterklasse der Klasse Artikel. Speichert zusätzlich
* das verwendete Material ab und die Schuhart ab.
*/
public class SchuhartikelModel extends ArtikelModel{

	private String material;
	private String schuhart;
	
	public SchuhartikelModel(int aNr, String bez, double pr, String mat, String sArt){
		super(aNr, bez, pr);
		this.material = mat;
		this.schuhart = sArt;
	}
	
	public String getMaterial(){
		return material;
	}
	
	public void setMaterial(String mat){
		this.material = mat;
	}
	
	public String getSchuhart(){
		return schuhart;
	}
	
	public void setSchuhart(String sArt){
		this.schuhart = sArt;
	}
	
}
