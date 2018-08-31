package vue;
import java.util.ArrayList;
import java.util.List;

import action.ControleurMouton;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Mouton;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueAjouterMouton vueAjouterMouton = null;
	private VueListeMouton vueListeMouton = null;
	private VueMouton vueMouton = null;
	
	private ControleurMouton controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueAjouterMouton = new VueAjouterMouton();
		this.vueListeMouton = new VueListeMouton();
		this.vueMouton = new VueMouton();
	}
	

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurMouton.getInstance();
		this.controleur.activerVues(this);
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
