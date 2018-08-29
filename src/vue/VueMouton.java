package vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Mouton;

public class VueMouton extends Scene{

	protected Label valeurNom;
	protected Label valeurCouleur;
	protected Label valeurPoids;
	protected Label valeurNaissance;
	
	public VueMouton() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();	
		GridPane grilleMouton = new GridPane();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleMouton.add(new Label("Nom : "), 0, 0);
		grilleMouton.add(valeurNom, 1, 0);
		
		valeurCouleur = new Label("");
		grilleMouton.add(new Label("Couleur : "), 0, 1);
		grilleMouton.add(valeurCouleur, 1, 1);

		valeurPoids = new Label("");
		grilleMouton.add(new Label("Poids : "), 0, 2);
		grilleMouton.add(valeurPoids, 1, 2);		

		valeurNaissance = new Label("");
		grilleMouton.add(new Label("Naissance : "), 0, 3);
		grilleMouton.add(valeurNaissance, 1, 3);				
			
		panneau.getChildren().add(grilleMouton);		
	}
	
	public void afficherMouton(Mouton mouton)
	{
		this.valeurNom.setText(mouton.getNom());
		this.valeurCouleur.setText(mouton.getCouleur());
		this.valeurPoids.setText(mouton.getPoids());
		this.valeurNaissance.setText(mouton.getNaissance());	
	}

}
