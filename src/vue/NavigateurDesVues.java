package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurMouton;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Mouton;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueAjouterMouton vueAjouterMouton = null;
	private VueListeMouton vueListeMouton = null;
	private VueMouton vueMouton = null;
	
	private ControleurMouton controleur;
	
	public NavigateurDesVues() 
	{		
		this.vueAjouterMouton = new VueAjouterMouton();
		this.vueListeMouton = new VueListeMouton();
		this.vueMouton = new VueMouton();
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
