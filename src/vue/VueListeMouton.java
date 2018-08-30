package vue;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Mouton;

public class VueListeMouton extends Scene {

	protected GridPane grilleMoutons;
	
	public VueListeMouton() {
		super(new GridPane(), 400,400);
		grilleMoutons = (GridPane) this.getRoot();
	}
	
	public void afficherListeMouton(List<Mouton> listeMoutons)
	{
		this.grilleMoutons.getChildren().clear();
		
		int numero = 0;
		this.grilleMoutons.add(new Label("Nom"), 0, numero);
		this.grilleMoutons.add(new Label("Naissance"), 1, numero);			
		for(Mouton mouton : listeMoutons)
		{
			numero++;
			this.grilleMoutons.add(new Label(mouton.getNom()), 0, numero);
			this.grilleMoutons.add(new Label(mouton.getNaissance()), 1, numero);			
		}
	}

}
