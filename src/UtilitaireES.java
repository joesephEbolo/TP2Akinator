import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Classe impl�mentant des sous programmes utilitaires
 * qui permettent de faire de la saisie au clavier pour le jeu du divinateur.
 *
 * Toutes les fonctionnalit�s importantes sont effectu�es par la classe
 * BdQuestionsReponses.
 *
 * @author pbelisle
 * @coauthor mnayrolles
 * @version ete 2018
 */

public class UtilitaireES {

	static Scanner clavier = new Scanner(System.in);

	/**********************************
	 * AFFICHER PRESENTATION DU JEU
	 *
	 * Affiche un bo�te de message qui explique le jeu.
	 *
	 **********************************/
	public static void afficherPresentationJeu(){


		String str = "***************************************\n" +
				"***********JEU DU DIVINATEURS*******\n" +
				"***************************************\n" +
				"***************************************\n" +
				"Il s'agit de penser � un animal, un objet ou un \n" +
				"personnage et nous tentons de le trouver \n" +
				"en posant des questions auxquelles \n" +
				"vous devrez r�pondre par  oui ou par non.\n\n\n" +
				"Si nous ne trouvons pas, vous pourrez nous dire ce � \n" +
				"quoi vous pensiez et ajouter une question qui distingue\n" +
				"votre r�ponse des autres.\n\n\n" +
				"Des mauvaises questions peuvent d�ranger" +
				" le bon d�roulement du jeu." +
				"\n" +
				"************************************";

		JOptionPane.showMessageDialog(null, str);
	}


	/***************************
	 * DEMARRER DIVINATEUR
	 *************************
	 *Permet l'interaction avec l'utilisateur en
	 *posant les questions provenant de la base de donn�es des r�ponses et
	 *en agissant selon les indices donn�s par l'utilisateur.
	 */
	public static void demarrerDivinateur(BdQuestionsReponses bd){

		// Sert a retenir s'il reste des question.
		boolean resteQuestion = true;

		// Sert � saisir la r�ponse de l'utilisateur.
		int reponse = JOptionPane.OK_OPTION;


		// Choisir une premi�re question dans la bd.
		bd.choisirPremiereQuestion();

		// Tant  qu'on a pas trouv� la r�ponse et qu'il reste des questions et
		// que l'utilisateur n'appuie pas sur X.
		while(reponse != JOptionPane.CLOSED_OPTION &&
				!bd.reponseTrouvee() &&
				resteQuestion){

			String [] options =  {"Oui", "Non"};

			String str = bd.getLaChaineActuelle();

			// On pose la question courante dans l'arbre de connaissance de la bd.
			reponse  = JOptionPane.showOptionDialog(null,
					str +

					// On met un ? s'il n'y en a pas
					((str.charAt(str.length() -1) == '?')? " " : "?"),
					"Jeu du divinateur",
					JOptionPane.CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					"Oui");

			if(reponse != JOptionPane.CLOSED_OPTION){

				// On se prom�ne dans l'arbre de connaissances.
				resteQuestion = bd.deplacerDansArbre(reponse);
			}
		}

		// Si on est sorti de la boucle pr�c�dente c'est qu'il ne reste plus de
		// question ou qu'on a trouv�.  Donc s'il reste des questions c'est
		// qu'on a trouv�
		if (resteQuestion && reponse != JOptionPane.CLOSED_OPTION) {

			reponse = JOptionPane.showConfirmDialog(null,
					"La r�ponse est " + bd.getLaChaineActuelle() + "; Est-ce exact ?");

			// Si l'utilisateur n'annule pas.
			if(reponse != JOptionPane.CANCEL_OPTION &&
					reponse != JOptionPane.CLOSED_OPTION){

				// Si c'est oui, on a trouv�, bravo!
				if (reponse == 0){

					JOptionPane.showMessageDialog(null,
							"Bravo nous avons trouve votre r�ponse");
				}

				// Autrement, on demande quel est sa r�ponse.
				else {

					demanderReponseValide(bd);
				}

			}
		}

		// Il ne reste plus de questions alors si l'utilisateur n'annule pas
		else if(reponse != JOptionPane.CANCEL_OPTION &&
				reponse != JOptionPane.CLOSED_OPTION){

			// On demande quel est sa r�ponse.
			demanderReponseValide(bd);
		}
	}

	public static void demanderReponseValide(BdQuestionsReponses bd) {

		String laQuestion = null;
		String laReponse = null;

		//UtilitaireFichier.sauvegarde(bd, "ETSE2018");

		do {     
			laReponse = JOptionPane.showInputDialog(null,
					"Je ne connais rien, Entrez � quoi vous pensez ?");  
		} while(laReponse == null || (laReponse.length() == 0));


		do {     
			laQuestion = JOptionPane.showInputDialog(null,
					"Entrez la question");  
		} while(laQuestion == null);

		// Ajouter la r�ponse et sa question aux collections respectives.

	}

	

}
