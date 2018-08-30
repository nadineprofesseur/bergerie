package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Mouton;
import vue.NavigateurDesVues;
import vue.VueAjouterMouton;
import vue.VueListeMouton;
import vue.VueMouton;

public class ControleurMouton {
	
	private NavigateurDesVues navigateur;
	private VueAjouterMouton vueAjouterMouton = null;
	private VueListeMouton vueListeMouton = null;
	private VueMouton vueMouton = null;
		
	private ControleurMouton()
	{
		System.out.println("Initialisation du controleur");		
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAjouterMouton = navigateur.getVueAjouterMouton();
		this.vueMouton = navigateur.getVueMouton();
		this.vueListeMouton = navigateur.getVueListeMouton();
						
		//// TEST ////
		Mouton mouton = new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueMouton.afficherMouton(mouton); // Appel de ma fonction avant de la programmer (pour tester à mesure)					
		
		this.navigateur.naviguerVersVueMouton();
		
		/// TEST ///
		List listeMoutonsTest = new ArrayList<Mouton>();
		listeMoutonsTest.add(new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015"));
		listeMoutonsTest.add(new Mouton("Molly", "Rousse", "20 kg", "5 mai 2016"));
		listeMoutonsTest.add(new Mouton("Arthurus", "Noire", "20 kg", "5 mars 2017"));
		listeMoutonsTest.add(new Mouton("Cheese", "Jaune", "20 kg", "5 septembre 2015"));
		this.vueListeMouton.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeMouton();		
				
		this.navigateur.naviguerVersVueAjouterMouton();
	}
	
	// SINGLETON DEBUT
	private static ControleurMouton instance = null;
	public static ControleurMouton getInstance()
	{
		if(null == instance) instance = new ControleurMouton();
		return instance;
	}
	// SINGLETON FINI

}
