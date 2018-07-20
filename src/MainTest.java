import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

/**
		//Noeud refGauche = new Noeud("O");
		//Noeud refDroite = new Noeud("N");

		Noeud noeud1 = new Noeud("Est-ce un animal ?");
		noeud1.setRefGauche(new Noeud("Chat"));

		Scanner clavier = new Scanner(System.in);
		System.out.println(noeud1.getElement());
		String rep = clavier.nextLine();

		if(rep.charAt(0) == 'O') {
			System.out.println(noeud1.getRefGauche().getElement());
			//noeud1.setRefGauche(new Noeud("Chat"));

		}
		
			
		//Noeud noeud2 = new Noeud("Chat");

		//if(noeud1.getRefGauche().getElement() == "O") {
		//noeud1.setRefGauche(noeud2);
		//System.out.println(noeud2.getElement());
		//}


		//System.out.println(noeud1.getRefGauche());
		//System.out.println(noeud1.getRefDroite());
		//System.out.println(noeud1.getElement());
		  
*/
		BdQuestionsReponses bd1 = new BdQuestionsReponses();
		 bd1.ajouterReponseEtSaQuestion("Chien", "Est-ce qu'il aboie ?");
		 System.out.println(bd1.toString());
		
		
		
	}
}


