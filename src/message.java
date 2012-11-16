
public class message {
	int auteurId;
	String texte;
	
	public message(int a, String t){
		auteurId = a;
		texte = t;
	}
	public void afficher(){
	System.out.println("Le client"+ auteurId + "a dit"+ texte);	
	}
}
