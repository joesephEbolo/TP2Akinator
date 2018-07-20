import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.LayoutQueue;

public class BdQuestionsReponses {

	private Reponse[] tabReponses;
	private ArrayList<String> tabQuestions;
	private InfoJeu infoJe;

	//private int positionIndice = 0;

	// Constructeur
	public BdQuestionsReponses() {

		this.tabQuestions = new ArrayList<String>();
		this.tabReponses = new Reponse[1];

		this.infoJe = new InfoJeu();
		this.infoJe.premierNoeud = new Noeud(0);
		this.infoJe.noeudCourant = this.infoJe.premierNoeud;
		this.infoJe.noeudPrecedent = null;
		this.infoJe.dernierIndiceFourni = false;
	}

	public Reponse[] getTabReponses() {
		return tabReponses;
	}

	public void setTabReponses(Reponse[] tabReponses) {
		this.tabReponses = tabReponses;
	}

	public ArrayList<String> getTabQuestions() {
		return tabQuestions;
	}

	public void setTabQuestions(ArrayList<String> tabQuestions) {
		this.tabQuestions = tabQuestions;
	}

	public InfoJeu getInfoJeu() {
		return infoJe;
	}

	public void setInfoJeu(InfoJeu infoJeu) {
		this.infoJe = infoJeu;
	}

	public boolean estVide() {
		if(this.tabReponses[0] == null ) {
			return true;
		}

		return false;
	}

	public String getLaChaineActuelle() {
		// TODO Auto-generated method stub
		return null;
	}
	//la methode pour la premiere question
	
public void laPremiereQuestion() {
	infoJe.premierNoeud = infoJe.noeudCourant;
	infoJe.dernierIndiceFourni = false;
	infoJe.noeudPrecedent = null;
	ArrayList <Character> IndicesDonneeUtilisateur = new ArrayList<Character>();
		
}
	public boolean deplacerDansArbre(int reponse) {
		// TODO Auto-generated method stub
		return false;
	}

	public void choisirPremiereQuestion() {

		if(!reponseTrouvee()) {

			int indiceDeRecherche = infoJe.noeudCourant.getElement();

			String laQuestion = tabQuestions.get(indiceDeRecherche);

			JOptionPane.showConfirmDialog(null,
					laQuestion);

		}

		/*
		infoJe.premierNoeud = new Noeud(0);

		infoJe.noeudCourant = infoJe.premierNoeud;

		tabReponses[0].setLaReponse(null);

		infoJe.noeudPrecedent = null;
	
		ArrayList<Character> tabIndice = new ArrayList<Character>();

	 */

	}

	public boolean reponseTrouvee() {


		return ((infoJe.noeudCourant.getRefDroite() == null) 
				&& 
				(infoJe.noeudCourant.getRefGauche() == null));

	}



	public int ajouterReponseEtSaQuestion(String reponse, 
			String question) {

		UtilitaireFichier.sauvegarde(this, Constantes.NOM_FICHIER_BD);

		int indiceQuestion = 0;
		int i = -1;
		boolean trouve =  false;

		do {

			i++; 
			trouve = (tabQuestions.get(i).equals(question));

		} while((!trouve) || (i < tabQuestions.size() - 1));

		if(trouve) 

			indiceQuestion  = i;

		else {

			indiceQuestion = tabQuestions.size();
			tabQuestions.add(question);
			tabReponses[indiceQuestion].setLaReponse(reponse); 

		}

		return indiceQuestion;

	}

	public void creerNoeudAjusterArbre(int indice) {

		//infoJe.premierNoeud = new Noeud(indice);

		//infoJe.noeudCourant = infoJe.premierNoeud;

		//Noeud refDroite = null;
		//Noeud refGauche = null;

		if(this.estVide()) {
			Noeud noeudReponse = new Noeud(indice);
			infoJe.premierNoeud.setRefGauche(noeudReponse);

		} else {



		}

	}

	public String toString() {

		String str = null;
		for(int i = 0; i < tabQuestions.size(); i++) {
			str = "La question est " + this.getTabQuestions().get(i) +
					" et la réponse est : " + this.getTabReponses()[i];
		}

		return str;
	}











}




