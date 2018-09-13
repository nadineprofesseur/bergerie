package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Distinction;
import modele.Mouton;

public class DistinctionDAO implements DistinctionSQL {

	private Connection connection = null;
	
	public DistinctionDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Distinction> listerDistinctionsParMouton(int idMouton)
	{
		System.out.println("DistinctionDAO.listerDistinctions()");
		List<Distinction> listeDistinctions =  new ArrayList<Distinction>();			
		PreparedStatement requeteListeDistinctions;
		// TODO factoriser chaines magiques dans des constantes - si possible interfaces
		try {
			requeteListeDistinctions = connection.prepareStatement(SQL_LISTER_DISTINCTIONS_PAR_MOUTON);
			requeteListeDistinctions.setInt(1, idMouton);
			ResultSet curseurListeDistinctions = requeteListeDistinctions.executeQuery(); 
			while(curseurListeDistinctions.next())
			{
				int id = curseurListeDistinctions.getInt("id");
				int annee = curseurListeDistinctions.getInt("annee");
				String titre = curseurListeDistinctions.getString("titre");
				String detail = curseurListeDistinctions.getString("detail");				
				System.out.println("Distinction " + titre + " donnée en " + annee);
				
				Distinction distinction = new Distinction(annee, titre);
				distinction.setDetail(detail);
				distinction.setId(id);
				listeDistinctions.add(distinction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerDistinctions();
		return listeDistinctions;
	}	
	
	public List<Distinction> simulerListerDistinctions()
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
