package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Mouton;

public class MoutonDAO {
		
	private Connection connection = null;
	
	public MoutonDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
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

		List<Mouton> listeMoutons =  new ArrayList<Mouton>();			
		Statement requeteListeMoutons;
		try {
			requeteListeMoutons = connection.createStatement();
			// TODO factoriser chaines magiques dans des constantes - si possible interfaces
			ResultSet curseurListeMoutons = requeteListeMoutons.executeQuery("SELECT * FROM mouton");
			while(curseurListeMoutons.next())
			{
				int id = curseurListeMoutons.getInt("id");
				String nom = curseurListeMoutons.getString("nom");
				String couleur = curseurListeMoutons.getString("couleur");
				String poids = curseurListeMoutons.getString("poids");
				String naissance = curseurListeMoutons.getString("naissance");
				System.out.println("Mouton " + nom + " née le " + naissance + " : " + poids + "kg " + couleur);
				Mouton mouton = new Mouton(nom, couleur, poids, naissance);
				mouton.setId(id);
				listeMoutons.add(mouton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerMoutons();
		return listeMoutons;
	}
	
	public void ajouterMouton(Mouton mouton)
	{
		System.out.println("MoutonDAO.ajouterMouton()");
		try {
			Statement requeteAjouterMouton = connection.createStatement();
			// TODO factoriser chaines magiques dans des constantes - si possible interfaces
			// TODO changer pour requete preparee
			String sqlAjouterMouton = "INSERT into mouton(nom, couleur, poids, naissance) VALUES('"+mouton.getNom()+"','"+mouton.getCouleur()+"','"+mouton.getPoids()+"','"+mouton.getNaissance()+"')";
			System.out.println("SQL : " + sqlAjouterMouton);
			requeteAjouterMouton.execute(sqlAjouterMouton);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierMouton(Mouton mouton)
	{
		System.out.println("MoutonDAO.modifierMouton()");
		try {
			Statement requeteModifierMouton = connection.createStatement();
			// TODO factoriser chaines magiques dans des constantes - si possible interfaces
			// TODO changer pour requete preparee
			String SQL_MODIFIER_MOUTON = "UPDATE mouton SET nom = '"+mouton.getNom()+"', couleur = '"+mouton.getCouleur()+"', poids = '"+mouton.getPoids()+"', naissance = '"+mouton.getNaissance()+"' WHERE id = " + mouton.getId();
			System.out.println("SQL : " + SQL_MODIFIER_MOUTON);
			requeteModifierMouton.execute(SQL_MODIFIER_MOUTON);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Mouton rapporterMouton(int idMouton)
	{
		PreparedStatement requeteMouton;
		try {
			String SQL_RAPPORTER_MOUTON = "SELECT * FROM mouton WHERE id = ?";
			requeteMouton = connection.prepareStatement(SQL_RAPPORTER_MOUTON);
			requeteMouton.setInt(1, idMouton);
			// TODO factoriser chaines magiques dans des constantes - si possible interfaces
			System.out.println(SQL_RAPPORTER_MOUTON);
			ResultSet curseurMouton = requeteMouton.executeQuery();
			curseurMouton.next();
			int id = curseurMouton.getInt("id");
			String nom = curseurMouton.getString("nom");
			String couleur = curseurMouton.getString("couleur");
			String poids = curseurMouton.getString("poids");
			String naissance = curseurMouton.getString("naissance");
			System.out.println("Mouton " + nom + " née le " + naissance + " : " + poids + "kg " + couleur);
			Mouton mouton = new Mouton(nom, couleur, poids, naissance);
			mouton.setId(id);
			return mouton;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
