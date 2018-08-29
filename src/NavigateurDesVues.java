import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueAjouterMouton vueAjouterMouton;
	private VueListeMouton vueListeMouton;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterMouton = new VueAjouterMouton();
		this.vueListeMouton = new VueListeMouton();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueListeMouton);
		stade.show();
	}
	
}
