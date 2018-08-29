import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueAjouterMouton vueAjouterMouton;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterMouton = new VueAjouterMouton();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAjouterMouton);
		stade.show();
	}
	
}
