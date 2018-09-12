package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Distinction;

public class DistinctionDAO {
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "test";	
	private Connection connection = null;

	public DistinctionDAO()
	{
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Distinction> simulerListeDistinctions()
	{
		// Données TEST - Mockup
		List<Distinction> listeDistinctions = new ArrayList<Distinction>();
		Distinction prix;
		prix = new Distinction(2015, "Mouton le plus noir");
		listeDistinctions.add(prix);
		prix = new Distinction(2016, "Mouton le plus rapide");
		listeDistinctions.add(prix);
		prix = new Distinction(2017, "Mouton comique");
		listeDistinctions.add(prix);
		prix = new Distinction(2018, "Mouton obéissant");
		listeDistinctions.add(prix);
		// Fin données TEST		
		
		return listeDistinctions;
	}
	
}
