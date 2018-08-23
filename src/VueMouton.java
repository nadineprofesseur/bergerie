import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueMouton extends Application{

	@Override
	public void start(Stage stade) throws Exception {
		Pane panneau = new Pane();	
		GridPane grilleMouton = new GridPane();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		Label valeurNom = new Label("Dolly");
		grilleMouton.add(new Label("Nom : "), 0, 0);
		grilleMouton.add(valeurNom, 1, 0);
		
		Label valeurCouleur = new Label("Grise");
		grilleMouton.add(new Label("Couleur : "), 0, 1);
		grilleMouton.add(valeurCouleur, 1, 1);

		Label valeurPoids = new Label("20 kg");
		grilleMouton.add(new Label("Poids : "), 0, 2);
		grilleMouton.add(valeurPoids, 1, 2);		

		Label valeurNaissance = new Label("5 juin 2015");
		grilleMouton.add(new Label("Naissance : "), 0, 3);
		grilleMouton.add(valeurNaissance, 1, 3);				
			
		panneau.getChildren().add(grilleMouton);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();
		
		//// TEST ////
		Mouton mouton = new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015");
		
	}
	
	public void afficherMouton(Mouton mouton)
	{
		
		
	}

}
