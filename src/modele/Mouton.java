package modele;

public class Mouton {

	protected String nom;
	protected String couleur;
	protected String poids;
	protected String naissance;
	
	public Mouton(String nom) {
		super();
		this.nom = nom;
	}
	public Mouton(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}
	public Mouton(String nom, String couleur, String poids) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.poids = poids;
	}
	public Mouton(String nom, String couleur, String poids, String naissance) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.poids = poids;
		this.naissance = naissance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getNaissance() {
		return naissance;
	}
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	public String getPoids() {
		return poids;
	}
	public void setPoids(String poids) {
		this.poids = poids;
	}
	
}
