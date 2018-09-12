package action;

import java.util.ArrayList;
import java.util.List;

import donnee.MoutonDAO;
import modele.Distinction;
import modele.Mouton;
import vue.NavigateurDesVues;
import vue.VueAjouterMouton;
import vue.VueEditerMouton;
import vue.VueListeMouton;
import vue.VueMouton;

public class ControleurMouton {
	
	private NavigateurDesVues navigateur;
	private VueListeMouton vueListeMouton = null;
	private VueMouton vueMouton = null;
	private VueAjouterMouton vueAjouterMouton = null;
	private VueEditerMouton vueEditerMouton = null;
	MoutonDAO moutonDAO = null;
	
	private ControleurMouton()
	{
		System.out.println("Initialisation du controleur");	
		this.moutonDAO = new MoutonDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAjouterMouton = navigateur.getVueAjouterMouton();
		this.vueMouton = navigateur.getVueMouton();
		this.vueListeMouton = navigateur.getVueListeMouton();
		this.vueEditerMouton = navigateur.getVueEditerMouton();
						
		//// TEST ////
		Mouton mouton = new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueMouton.afficherMouton(mouton); // Appel de ma fonction avant de la programmer (pour tester à mesure)					
		
		this.navigateur.naviguerVersVueMouton();
		
		/// TEST ///
		List<Mouton> listeMoutonsTest = moutonDAO.listerMoutons();
		this.vueListeMouton.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeMouton();		
				
		//this.navigateur.naviguerVersVueAjouterMouton();
		
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
		this.vueEditerMouton.afficherListeDistinction(listeDistinctions);
		
	}
	
	// SINGLETON DEBUT
	private static ControleurMouton instance = null;
	public static ControleurMouton getInstance()
	{
		if(null == instance) instance = new ControleurMouton();
		return instance;
	}
	// SINGLETON FINI

	public void notifierEnregistrerNouveauMouton()
	{
		System.out.println("ControleurMouton.notifierEnregistrerNouveauMouton()");
		Mouton mouton = this.navigateur.getVueAjouterMouton().demanderMouton();
		this.moutonDAO.ajouterMouton(mouton);
		this.vueListeMouton.afficherListeMouton(this.moutonDAO.listerMoutons()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMouton();
	}
	
	public void notifierEnregistrerMouton()
	{
		System.out.println("ControleurMouton.notifierEnregistrerMouton()");
		Mouton mouton = this.navigateur.getVueEditerMouton().demanderMouton();
		this.moutonDAO.modifierMouton(mouton);
		this.vueListeMouton.afficherListeMouton(this.moutonDAO.listerMoutons()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMouton();		
	}
	
	public void notifierNaviguerAjouterMouton()
	{
		System.out.println("ControleurMouton.notifierNaviguerAjouterMouton()");
		this.navigateur.naviguerVersVueAjouterMouton();
	}
	
	public void notifierNaviguerEditerMouton(int idMouton)
	{
		System.out.println("ControleurMouton.notifierEditerMouton("+idMouton+")");
		// savoir par la vue liste quel numero de mouton a ete clique
		this.vueEditerMouton.afficherMouton(this.moutonDAO.rapporterMouton(idMouton));
		this.navigateur.naviguerVersVueEditerMouton();
		
	}
	
	
}
