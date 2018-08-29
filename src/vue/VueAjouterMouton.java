package vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Mouton;

public class VueAjouterMouton extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	public VueAjouterMouton()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleMouton = new GridPane();

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
			
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Ajouter un mouton")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMouton);
		panneau.getChildren().add(new Button("Enregistrer"));
	}
	
	public Mouton demanderMouton()
	{
		Mouton mouton = new Mouton(this.valeurNom.getText(), 
								this.valeurCouleur.getText(), 
								this.valeurPoids.getText(), 
								this.valeurNaissance.getText());
		return mouton;
	}

}
