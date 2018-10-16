package Ue2_Online_Modegeschaeft;

/**
* Unterklasse der Klasse Artikel. Speichert zusätzlich
* das verwendete Material ab.
*/
public class Accessoirs extends Artikel{

	private String material;
	private String atyp;
	
	public Accessoirs(int aNr, String bez, double pr, String mat, String atyp){
		super(aNr, bez, pr);
		this.material = mat;
		this.atyp = atyp;
	}
	
	public String getMaterial(){
		return material;
	}
	
	public void setMaterial(String mat){
		this.material = mat;
	}
	
	public String getSAscTyp(){
		return atyp;
	}
	
	public void setAscTyp(String atyp){
		this.atyp = atyp;
	}
	
}
