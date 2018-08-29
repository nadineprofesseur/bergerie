package controleur;

import vue.NavigateurDesVues;

public class ControleurMouton {
	
	private NavigateurDesVues navigateur;
	
	public ControleurMouton(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		System.out.println("Initialisation du controleur");
		
		this.navigateur.naviguerVersVueListeMouton();
		this.navigateur.naviguerVersVueMouton();
		this.navigateur.naviguerVersVueAjouterMouton();

	}

}
