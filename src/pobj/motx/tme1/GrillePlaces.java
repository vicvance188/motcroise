package pobj.motx.tme1;

import java.util.List;

public class GrillePlaces {
	
	private List<Emplacement> places;
	
	public GrillePlaces(Grille grille) {
		int col = 0;
		int lig = 0;
		for(lig = 0; lig<grille.nbLig();lig++) {
			for(col = 0; col<grille.nbCol();col++) {
				if( grille.getCase(lig, col).getChar() != ' ' && grille.getCase(lig, col).getChar() != '*') {
					places. //on peut creer un emplacement, l'append dnas place, puis le clear.
				}//on parcourt la grille, si on trouve une lettre, on regarde si le suivant en est une
				// suivant étant à droite ou en bas (ou alors 2 boucles) si le suivant est une lettre
				//également, alors on ajoute ces deux cases et toute celle qui suivent dans places[i]
				//places etant une liste de list.
				//problème : ne pas compter 2 mots horizontal comme un mot vertical, ne pas compter des mots plusieurs fois.
			}
		}
		
	}
	
	public List<Emplacement> getPlaces(){
		
	}
	
	public int getNbHorizontal() {
		
	}
	
	public String toString() {
		
	}
	
	private List<Case> getLig(int lig){
		
	}
	
	private List<Case> getCol(int col){
		
	}
	
	private void cherchePlaces(List<Case> cases) {
		
	}
	
	
	
	
}
