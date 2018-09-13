package donnee;

public interface MoutonSQL {
	
	String SQL_LISTER_MOUTONS = "SELECT * FROM mouton";
	String SQL_AJOUTER_MOUTON = "INSERT into mouton(nom, couleur, poids, naissance) VALUES(?,?,?,?)";
	String SQL_MODIFIER_MOUTON = "UPDATE mouton SET nom = ?, couleur = ?, poids = ?, naissance = ? WHERE id = ?";
	String SQL_RAPPORTER_MOUTON = "SELECT * FROM mouton WHERE id = ?";


}
