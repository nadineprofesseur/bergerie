package donnee;

public interface MoutonSQL {
	
	public static final String SQL_LISTER_MOUTONS = "SELECT * FROM mouton";
	public static final String SQL_AJOUTER_MOUTON = "INSERT into mouton(nom, couleur, poids, naissance) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_MOUTON = "UPDATE mouton SET nom = ?, couleur = ?, poids = ?, naissance = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_MOUTON = "SELECT * FROM mouton WHERE id = ?";

}
