/**
 * Classe qui permet la gestion du fichier pour projet de jeu du divinateur (voir �nonc� tp2 e2018).
 *
 * @author pbelisle
 * @coauthor mnayrolles
 * @version E 2018
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class UtilitaireFichier {


	/**
	 * Tente d'ouvrir le fichier NOM_FICHIER_BD.  S'il n'existe pas,
	 * la bd est vide.
	 */
	public static BdQuestionsReponses obtenirBd(){

		/*
		 * Strat�gie : On utilise  un FileInputStream qui permet de lire
		 * la bd d'un coup, (comme elle a �t� sauvegard�e).
		 */
		FileInputStream fic;
		BdQuestionsReponses bd = null;

		try {
			fic = new FileInputStream(Constantes.NOM_FICHIER_BD);

			// ouverture du tampon logique
			ObjectInputStream tampon = null;
			tampon = new ObjectInputStream(fic);

			bd =  (BdQuestionsReponses)tampon.readObject();

			tampon.close();

		}

		// Si le fichier n'existe pas, on s'assure que tout est initialis�.
		catch(FileNotFoundException e){
			bd = new BdQuestionsReponses();
		}

		// Probl�me lors de la lecture. On arr�te.
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return bd;
	}

	/**
	 * Sauvegarde la bd dans le fichier nomm� par NOM_FICHIER_BD.
	 *
	 */
	public static void sauvegarde(BdQuestionsReponses bd, String nomFic){

		/*
		 * Strat�gie : On utilise  un FileOutputStream qui permet de lire
		 * la bd d'un coup.
		 */
		FileOutputStream fic;
		ObjectOutputStream tampon = null;

		try {

			//Cr�e le fichier
			fic = new FileOutputStream(nomFic);

			//Ouverture du tampon d'�criture
			tampon = new ObjectOutputStream(fic);
			tampon.writeObject(bd);
			tampon.close();

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

			// Une erreur de lecture, on d�truit le fichier.
		} catch (IOException e) {

			// On obtient le chemin du fichier pour le d�truire.
			Path path =
					FileSystems.getDefault().getPath(Constantes.NOM_FICHIER_BD);

			try {

				tampon.close();
				Files.delete(path);

			} catch (IOException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}
}

