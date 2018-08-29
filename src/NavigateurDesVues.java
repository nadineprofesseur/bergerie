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
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueMouton);
		stade.show();
	}
	
}
