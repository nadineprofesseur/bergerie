import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueListeMouton extends Application {

	protected GridPane grilleMoutons;
	
	@Override
	public void start(Stage stade) throws Exception {
		Pane panneau = new Pane();	
		grilleMoutons = new GridPane();
		
		
		panneau.getChildren().add(grilleMoutons);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();		
		
		/// TEST ///
		List listeMoutonsTest = new ArrayList<Mouton>();
		listeMoutonsTest.add(new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015"));
		listeMoutonsTest.add(new Mouton("Molly", "Rousse", "20 kg", "5 mai 2016"));
		listeMoutonsTest.add(new Mouton("Arthurus", "Noire", "20 kg", "5 mars 2017"));
		listeMoutonsTest.add(new Mouton("Cheese", "Jaune", "20 kg", "5 septembre 2015"));
		this.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		
	}
	
	public void afficherListeMouton(List<Mouton> listeMoutons)
	{
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
