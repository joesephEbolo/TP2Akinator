import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
* Il s'agit pour ce travail de la simulation d' un jeu d'intelligence
* artificielle . Ce jeu consiste � demander � son utilisateur de penser �
* un animal ou � un objet ou un personnage, et le programme tente de le
* trouver en lui posant des questions.  L'utilisateur ne doit  r�pondre que
* par :  oui, non.
*
* � noter : Le constructeur de la classe BdQuestionsReponses tente
* d'ouvrir un fichier au nom d�fini dans Constantes.NOM_FICHIER_BD.
* S'il existe, il contient toutes les donn�es du jeu.  Dans le cas contraire,
* la bd est vide alors le programme principal saisit une r�ponse et au
* moins une question pour  l'ajouter � la bd.  C'est alors que ce fichier est
* cr�� et maintenu � jour � chaque nouvelle r�ponse qui s'ajoute dans le
* jeu.
*
* @author Pierre B�lisle
* @coauthor mnayrolles
* @version ete 2018
*/
public class DemarrerJeuDivinateur {

	public static void main(String[] args) {

		/*
		 * Strat�gie : Une classe BdQuestionsReponse retient les questions,
		 * les r�ponses et le chemin pour les retrouver.  La classe JOptionPane
		 * est utilis�e pour les ES ainsi que le module UtilitaireES.
		 *
		 * La boucle "principale" du jeu est d�finie localement, les autres sont
		 * dans l'utilitaireES.
		 */

		// Pour avoir une fen�tre en fond d'�cran.
		JFrame cadre = new JFrame();
		cadre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		cadre.setVisible(true);

		// La bd qui contient les r�ponses, les questions
 	// et les liens entre les questions et les r�ponses.
		
		//BdQuestionsReponses bd = UtilitaireFichier.obtenirBd();
		BdQuestionsReponses bd = new BdQuestionsReponses();
		
		// Sert � saisir la reponse de l'utilisateur aux questions.
		int reponse = 0;

		// Lorsquel le jeu fonctionne, enlever le commentaire pour
		// dans la version officielle.
		//UtilitaireES.afficherPresentationJeu();

		//  Si la bd est vide, on demande simplement un objet ou un animal et
	    // au moins une question qui le distingue.  Autrement dit, on s'assure
		// d'avoir au moins une r�ponse dans la bd avant de jouer.
		
		//bd = null;
		
		//if (bd == null) {
		if (bd.estVide()) {

			System.out.println("La Bd est vide");
			UtilitaireES.demanderReponseValide(bd);

			// On demande si l'utilisateur veut jouer imm�diatement.
			reponse =
					JOptionPane.showConfirmDialog(null,
							"Voulez-vous jouez maintenant ?");
		}

		// Tant que l'utilisateur veut jouer (il n'a pas annul�)
		while(reponse == JOptionPane.OK_OPTION){

			// On d�marre la partie.
			UtilitaireES.demarrerDivinateur(bd);

			// On demande s'il veut rejouer.
			reponse =
					JOptionPane.showConfirmDialog(null,
							"Voulez-vous rejouez  ?");
		}

		// On sort de la boucle c'est que la partie est termin�e.


		// Lorsquel le jeu fonctionne, enlever le commentaire pour
		// dans la version officielle.
		JOptionPane.showMessageDialog(null, "Merci d'avoir jou� avec nous!");

		// Fermeture de la fen�tre en arri�re.
		cadre.dispose();
	}

}