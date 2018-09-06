package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "test";	
	private Connection connection = null;
	
	public MoutonDAO()
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
	
	public List<Mouton> listerMoutons()
	{

		List<Mouton> listeMoutons =  new ArrayList<Mouton>();			
		Statement requeteListeMoutons;
		try {
			requeteListeMoutons = connection.createStatement();
			ResultSet curseurListeMoutons = requeteListeMoutons.executeQuery("SELECT * FROM mouton");
			while(curseurListeMoutons.next())
			{
				String nom = curseurListeMoutons.getString("nom");
				String couleur = curseurListeMoutons.getString("couleur");
				String poids = curseurListeMoutons.getString("poids");
				String naissance = curseurListeMoutons.getString("naissance");
				System.out.println("Mouton " + nom + " née le " + naissance + " : " + poids + "kg " + couleur);
				Mouton mouton = new Mouton(nom, couleur, poids, naissance);
				listeMoutons.add(mouton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerMoutons();
		return listeMoutons;
	}
}
