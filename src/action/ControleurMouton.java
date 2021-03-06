package action;

import java.util.ArrayList;
import java.util.List;

import donnee.DistinctionDAO;
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
	private MoutonDAO moutonDAO = null;
	private DistinctionDAO distinctionDAO = null;
	
	private ControleurMouton()
	{
		System.out.println("Initialisation du controleur");	
		this.moutonDAO = new MoutonDAO();
		distinctionDAO = new DistinctionDAO();
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
		this.vueMouton.afficherMouton(mouton); // Appel de ma fonction avant de la programmer (pour tester � mesure)					
		
		this.navigateur.naviguerVersVueMouton();
		
		/// TEST ///
		List<Mouton> listeMoutonsTest = moutonDAO.listerMoutons();
		this.vueListeMouton.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		this.navigateur.naviguerVersVueListeMouton();		
				
		//this.navigateur.naviguerVersVueAjouterMouton();
		
		//this.vueEditerMouton.afficherListeDistinction(this.distinctionDAO.listerDistinctions());
		
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
		this.vueEditerMouton.afficherListeDistinction(this.distinctionDAO.listerDistinctionsParMouton(idMouton));
		this.navigateur.naviguerVersVueEditerMouton();
		
	}
	
	
}
