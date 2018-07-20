import java.util.ArrayList;

public class Reponse {

	private String laReponse;
	private ArrayList<Character> listeIndice;

	public Reponse(String laReponse, ArrayList<Character> listIndice) {
		this.laReponse = laReponse;
		this.listeIndice = new ArrayList<Character>();

	}

	public String getLaReponse() {
		return laReponse;
	}

	public void setLaReponse(String laReponse) {
		this.laReponse = laReponse;
	}

	public ArrayList<Character> getListeIndice() {
		return listeIndice;
	}

	public void setListeIndice(ArrayList<Character> listeIndice) {
		this.listeIndice = listeIndice;
	}

	
	
}	
