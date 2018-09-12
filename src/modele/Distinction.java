package modele;

import java.util.Calendar;

public class Distinction {
	
	protected int id;
	protected int annee;
	protected String titre;
	
	public Distinction() { 
		this.annee = Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public Distinction(int annee, String titre) {
		super();
		this.annee = annee;
		this.titre = titre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	protected String detail;
	//protected String evenement;

}
