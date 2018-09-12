package vue;
import java.util.ArrayList;
import java.util.List;

import action.ControleurMouton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Distinction;
import modele.Mouton;

public class VueEditerMouton extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	private ControleurMouton controleur = null;
	protected Button actionEnregistrerMouton = null;
	GridPane grilleListeDistinctions = new GridPane();
	
	private int idMouton = 0;
	
	public VueEditerMouton()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleMouton = new GridPane();
		this.actionEnregistrerMouton = new Button("Enregistrer");
		
		this.actionEnregistrerMouton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerMouton();
				
			}});
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleMouton.add(new Label("Nom : "), 0, 0);
		grilleMouton.add(valeurNom, 1, 0);
		
		valeurCouleur = new TextField("");
		grilleMouton.add(new Label("Couleur : "), 0, 1);
		grilleMouton.add(valeurCouleur, 1, 1);

		valeurPoids = new TextField("");
		grilleMouton.add(new Label("Poids : "), 0, 2);
		grilleMouton.add(valeurPoids, 1, 2);		

		valeurNaissance = new TextField("");
		grilleMouton.add(new Label("Naissance : "), 0, 3);
		grilleMouton.add(valeurNaissance, 1, 3);				
	
		// Données TEST - Mockup
		List<Distinction> listeDistinctions = new ArrayList<Distinction>();
		Distinction prix;
		prix = new Distinction(2015, "Mouton le plus noir");
		listeDistinctions.add(prix);
		prix = new Distinction(2016, "Mouton le plus rapide");
		listeDistinctions.add(prix);
		prix = new Distinction(2017, "Mouton comique");
		listeDistinctions.add(prix);
		prix = new Distinction(2018, "Mouton obéissant");
		listeDistinctions.add(prix);
		// Fin données TEST

		int item = 0;
		for(Distinction distinction : listeDistinctions)
		{
			this.grilleListeDistinctions.add(new Label(distinction.getAnnee() + ""), 0, item);
			this.grilleListeDistinctions.add(new Label(distinction.getTitre()), 1, item);
			this.grilleListeDistinctions.add(new Button("Éditer"), 2, item);
			this.grilleListeDistinctions.add(new Button("Effacer"), 3, item);
			item++;
		}
				
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un mouton")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMouton);
		panneau.getChildren().add(this.actionEnregistrerMouton);
		panneau.getChildren().add(grilleListeDistinctions);
	}
	
	public void afficherMouton(Mouton mouton)
	{
		this.idMouton = mouton.getId();
		this.valeurNom.setText(mouton.getNom());
		this.valeurCouleur.setText(mouton.getCouleur());
		this.valeurPoids.setText(mouton.getPoids());
		this.valeurNaissance.setText(mouton.getNaissance());
	}
	
	public Mouton demanderMouton()
	{
		Mouton mouton = new Mouton(this.valeurNom.getText(), 
								this.valeurCouleur.getText(), 
								this.valeurPoids.getText(), 
								this.valeurNaissance.getText());
		mouton.setId(idMouton);
		return mouton;
	}
	
	public void setControleur(ControleurMouton controleur) {
		this.controleur = controleur;
	}
	

}
