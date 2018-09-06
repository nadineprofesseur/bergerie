package action;

import java.util.List;

import donnee.MoutonDAO;
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
						
		//// TEST ////
		Mouton mouton = new Mouton("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueMouton.afficherMouton(mouton); // Appel de ma fonction avant de la programmer (pour tester à mesure)					
		
		this.navigateur.naviguerVersVueMouton();
		
		/// TEST ///
		List<Mouton> listeMoutonsTest = moutonDAO.listerMoutons();
		this.vueListeMouton.afficherListeMouton(listeMoutonsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeMouton();		
				
		//this.navigateur.naviguerVersVueAjouterMouton();
	}
	
	// SINGLETON DEBUT
	private static ControleurMouton instance = null;
	public static ControleurMouton getInstance()
	{
		if(null == instance) instance = new ControleurMouton();
		return instance;
	}
	// SINGLETON FINI

	public void notifierEnregistrerMouton()
	{
		System.out.println("ControleurMouton.notifierEnregistrerMouton()");
		Mouton mouton = this.navigateur.getVueAjouterMouton().demanderMouton();
		this.moutonDAO.ajouterMouton(mouton);
		this.vueListeMouton.afficherListeMouton(this.moutonDAO.listerMoutons()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMouton();
	}
	
	public void notifierNaviguerAjouterMouton()
	{
		System.out.println("ControleurMouton.notifierNaviguerAjouterMouton()");
		this.navigateur.naviguerVersVueAjouterMouton();
	}
	
	
}
