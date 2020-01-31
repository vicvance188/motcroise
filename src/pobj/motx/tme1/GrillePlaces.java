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
		
		List<Case> temp;
		int lig = 0;
		int col = 0;
		
		for(lig = 0; lig < grille.nbLig(); lig++) {
			temp = this.getLig(lig);
			Emplacement empl = new Emplacement();
			for(col = 0; col<grille.nbCol(); col++) {
				if(! temp.get(col).isPleine()) {
					empl.add(temp.get(col));
				}else {
					if(empl.size()>2) {
						places.add(empl);
					empl = new Emplacement();
					}
				}
			}
			if(empl.size()>2) {
				places.add(empl);
			}
		}

		for(col = 0; col < grille.nbLig(); col++) {
			temp = this.getCol(col);
			Emplacement empl = new Emplacement();
			for(lig = 0; lig<grille.nbLig(); lig++) {
				if(! temp.get(lig).isPleine()) {
					empl.add(temp.get(lig));
				}else {
					if(empl.size()>2) {
						places.add(empl);
					empl = new Emplacement();
					}
				}
			}
			if(empl.size()>2) {
				places.add(empl);
			}
		}
	}

}
