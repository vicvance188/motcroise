package pobj.motx.tme1;

import java.util.List;

public class GrillePlaces {
	
	private List<Emplacement> places;
	
	public GrillePlaces(Grille grille) {
		int col = 0;
		int lig = 0;
		Emplacement temp = new Emplacement();
		
		for(lig = 0; lig<grille.nbLig();lig++) {
			for(col = 0; col<grille.nbCol();col++) {
				if( grille.getCase(lig, col).getChar() != ' ' && grille.getCase(lig, col).getChar() != '*') {
					if(grille.getCase(lig+1, col).getChar() != ' ' && grille.getCase(lig+1, col).getChar() != '*') {
						while(grille.getCase(lig+1, col).getChar() != ' ' && grille.getCase(lig+1, col).getChar() != '*') {
							temp.add(grille.getCase(lig, col));
						}
					}
				}
			}
		}
		
		for(col = 0; col<grille.nbCol();col++) {
			for(lig = 0; lig<grille.nbLig();lig++) {
				if( grille.getCase(lig, col).getChar() != ' ' && grille.getCase(lig, col).getChar() != '*') {
					if(grille.getCase(lig, col+1).getChar() != ' ' && grille.getCase(lig, col+1).getChar() != '*') {
						while(col<grille.nbCol() && lig < grille.nbLig() && grille.getCase(lig, col+1).getChar() != ' ' && grille.getCase(lig, col+1).getChar() != '*') {
							temp.add(grille.getCase(lig, col));
						}
						places.add(temp);
						temp.clear();
					}
				}
			}
		}			//code non factorisé, à optimisé, comme la c'est moche !
	}
				
				//on peut creer un emplacement, l'append dans place, puis le clear.
				//on parcourt la grille, si on trouve une lettre, on regarde si le suivant en est une
				// suivant étant à droite ou en bas (ou alors 2 boucles) si le suivant est une lettre
				//également, alors on ajoute ces deux cases et toute celle qui suivent dans places[i]
				//places etant une liste de list.

	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		// ????
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<places.size(); i++) {
			for (int j = 0; j < places.get(i).size(); j++) {
				res += places.get(i).get(j).toString();
				res += "  ";
			}
			res += "\n";
		}
		return res;
	}
	
	private List<Case> getLig(int lig){
		
	}
	
	private List<Case> getCol(int col){
		
	}
	
	private void cherchePlaces(List<Case> cases) {
		
	}
	
	
	
	
}
