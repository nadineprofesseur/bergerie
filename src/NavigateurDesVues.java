import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueAjouterMouton vueAjouterMouton;
	private VueListeMouton vueListeMouton;
	private VueMouton vueMouton;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterMouton = new VueAjouterMouton();
		this.vueListeMouton = new VueListeMouton();
		this.vueMouton = new VueMouton();
		
		/// TEST ///
		List listeMoutonsTest = new ArrayList<Mouton>();
		listeMoutonsTest.add(new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015"));
		listeMoutonsTest.add(new Mouton("Molly", "Rousse", "20 kg", "5 mai 2016"));
		listeMoutonsTest.add(new Mouton("Arthurus", "Noire", "20 kg", "5 mars 2017"));
		listeMoutonsTest.add(new Mouton("Cheese", "Jaune", "20 kg", "5 septembre 2015"));
		this.vueListeMouton.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		//// TEST ////
		Mouton mouton = new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueMouton.afficherMouton(mouton); // Appel de ma fonction avant de la programmer (pour tester à mesure)		
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueMouton);
		stade.show();
	}
	
}
