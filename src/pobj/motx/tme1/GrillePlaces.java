package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {

	private List<Emplacement> places;
	private Grille grille;

	public GrillePlaces(Grille grille) {
		this.grille = grille;

	}

	public List<Emplacement> getPlaces() {
		return places;
	}

	public int getNbHorizontal() {
		// ????
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < places.size(); i++) {
			for (int j = 0; j < places.get(i).size(); j++) {
				res += places.get(i).get(j).toString();
				res += "  ";
			}
			res += "\n";
		}
		return res;
	}

	private List<Case> getLig(int lig){
		int col = 0;
		List<Case>res = new ArrayList<Case>();
		for(col=0; col<grille.nbCol();col++) {
			res.add(grille.getCase(lig, col));
		}
		return res;		
	}

	private List<Case> getCol(int col) {
		int lig = 0;
		List<Case>res = new ArrayList<Case>();
		for(lig=0; lig<grille.nbCol();lig++) {
			res.add(grille.getCase(lig, col));
		}
		return res;		
	}

	private void cherchePlaces(List<Case> cases) {
		
		
		/*
		int col = 0;
		int lig = 0;
		Emplacement temp = new Emplacement();

		for (lig = 0; lig < grille.nbLig(); lig++) {
			for (col = 0; col < grille.nbCol(); col++) {
				if (grille.getCase(lig, col).getChar() != ' ' && grille.getCase(lig, col).getChar() != '*') {
					if (grille.getCase(lig + 1, col).getChar() != ' '
							&& grille.getCase(lig + 1, col).getChar() != '*') {
						while (grille.getCase(lig + 1, col).getChar() != ' '
								&& grille.getCase(lig + 1, col).getChar() != '*') {
							temp.add(grille.getCase(lig, col));
						}
					}
				}
			}
		}

		for (col = 0; col < grille.nbCol(); col++) {
			for (lig = 0; lig < grille.nbLig(); lig++) {
				if (grille.getCase(lig, col).getChar() != ' ' && grille.getCase(lig, col).getChar() != '*') {
					if (grille.getCase(lig, col + 1).getChar() != ' '
							&& grille.getCase(lig, col + 1).getChar() != '*') {
						while (col < grille.nbCol() && lig < grille.nbLig()
								&& grille.getCase(lig, col + 1).getChar() != ' '
								&& grille.getCase(lig, col + 1).getChar() != '*') {
							temp.add(grille.getCase(lig, col));
						}
						places.add(temp);
					}
				}
			}
		}
		*/
		Emplacement empl = new Emplacement();
		List<Case> temp;
		int lig = 0;
		int col = 0;
		
		for(lig = 0; lig < grille.nbLig(); lig++) {
			temp = this.getLig(lig);
			for(col = 0; col<grille.nbCol(); col++) {
				if(! temp.get(col).isPleine() ) {
					empl.add(temp.get(col));
				}
			}
			if(empl.size()>2) {
				places.add(empl);
			}
		}

		for(col = 0; col < grille.nbLig(); col++) {
			temp = this.getLig(lig);
			for(col = 0; col<grille.nbCol(); col++) {
				if(! temp.get(col).isPleine() ) {
					empl.add(temp.get(col));
				}
			}
			if(empl.size()>2) {
				places.add(empl);
			}
			
		
			
			
			
		/*
		 * si elle est non pleine, nous l’ajoutons à l’emplacement, • sinon, nous
		 * examinons la taille de l’emplacement construit, – s’il fait au moins deux
		 * lettres, nous l’ajoutons aux emplacements de mots détectés, – sinon, nous
		 * réinitialisons l’emplacement. N’oubliez pas (à la fin de l’itération)
		 * d’ajouter le dernier emplacement trouvé s’il est assez long.
		 */
	}

}
