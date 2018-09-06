package vue;

import action.ControleurMouton;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeMouton vueListeMouton = null;
	private VueMouton vueMouton = null;
	private VueAjouterMouton vueAjouterMouton = null;
	private VueEditerMouton vueEditerMouton = null;
	
	private ControleurMouton controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueListeMouton = new VueListeMouton();
		this.vueMouton = new VueMouton();
		this.vueAjouterMouton = new VueAjouterMouton();
		this.vueEditerMouton = new VueEditerMouton();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurMouton.getInstance();
		this.controleur.activerVues(this);
		this.vueListeMouton.setControleur(controleur);
		this.vueMouton.setControleur(controleur);
		this.vueAjouterMouton.setControleur(controleur);
		this.vueEditerMouton.setControleur(controleur);
	}	
	
	public VueListeMouton getVueListeMouton() {
		return vueListeMouton;
	}

	public VueMouton getVueMouton() {
		return vueMouton;
	}
	
	public VueAjouterMouton getVueAjouterMouton() {
		return vueAjouterMouton;
	}

	public VueEditerMouton getVueEditerMouton(){
		return this.vueEditerMouton;
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

	public void naviguerVersVueEditerMouton()
	{
		stade.setScene(this.vueEditerMouton);
		stade.show();				
	}
	
}
