import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueListeMouton extends Application {

	@Override
	public void start(Stage stade) throws Exception {
		Pane panneau = new Pane();	
		GridPane grilleMoutons = new GridPane();
		
		panneau.getChildren().add(grilleMoutons);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();		
	}

}
