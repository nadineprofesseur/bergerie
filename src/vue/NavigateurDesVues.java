package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurMouton;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Mouton;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueAjouterMouton vueAjouterMouton;
	private VueListeMouton vueListeMouton;
	private VueMouton vueMouton;
	
	private ControleurMouton controleur;
	
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
		this.stade = stade;
		this.stade.setScene(this.vueListeMouton);
		this.stade.show();
	
		this.controleur = new ControleurMouton(this); // Inversion de la création car le framework instancie la vue dans un thread

	}	
	
	public VueAjouterMouton getVueAjouterMouton() {
		return vueAjouterMouton;
	}

	public VueListeMouton getVueListeMouton() {
		return vueListeMouton;
	}

	public VueMouton getVueMouton() {
		return vueMouton;
	}
	
	public void naviguerVersVueMouton() {
		stade.setScene(this.vueMouton);
		stade.show();
	}
	
	public void naviguerVersVueListeMouton()
	{
		stade.setScene(this.vueListeMouton);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterMouton()
	{
		stade.setScene(this.vueAjouterMouton);
		stade.show();				
	}

	
}
