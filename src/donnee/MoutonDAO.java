package donnee;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Mouton;

public class MoutonDAO {
	
	private List<Mouton> simulerListerMoutons()
	{
		List listeMoutonsTest = new ArrayList<Mouton>();
		listeMoutonsTest.add(new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015"));
		listeMoutonsTest.add(new Mouton("Molly", "Rousse", "20 kg", "5 mai 2016"));
		listeMoutonsTest.add(new Mouton("Arthurus", "Noire", "20 kg", "5 mars 2017"));
		listeMoutonsTest.add(new Mouton("Cheese", "Jaune", "20 kg", "5 septembre 2015"));
		return listeMoutonsTest;
	}
	public List<Mouton> listerMoutons()
	{
		
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "test";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.simulerListerMoutons();
	}
}
