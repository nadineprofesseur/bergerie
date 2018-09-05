package vue;
import java.util.List;

import action.ControleurMouton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Mouton;

public class VueListeMouton extends Scene {

	protected GridPane grilleMoutons;
	
	private ControleurMouton controleur = null;
	
	
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
			this.grilleMoutons.add(new Button("Editer"), 2, numero);
		}
	}

	public void setControleur(ControleurMouton controleur) {
		this.controleur = controleur;
	}

}
