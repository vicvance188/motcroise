package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {

	private List<Emplacement> places;
	private Grille grille;
	private int nbHorizontal;

	public GrillePlaces(Grille grille) {
		System.out.println("########################################");
		System.out.println(grille);
		System.out.println("########################################");
		this.grille = grille;
		places = new ArrayList<Emplacement>();
		for (int i = 0; i < grille.nbLig(); i++) {
			List<Case> cases = getLig(i);
			cherchePlaces(cases);
		}
		nbHorizontal = places.size();
		for (int i = 0; i < grille.nbCol(); i++) {
			List<Case> cases = getCol(i);
			cherchePlaces(cases);
		}
		System.out.println("########################################");
		System.out.println(this);
		System.out.println("########################################");
	}

	public List<Emplacement> getPlaces() {
		return places;
	}

	public int getNbHorizontal() {
		return nbHorizontal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("liste de mots detectes:\n");
		for (Emplacement e : places) {
			sb.append(e+"\n");
		}
		return sb.toString();
	}

	private List<Case> getLig(int lig){
		List<Case> res = new ArrayList<Case>();
		for (int col = 0; col < grille.nbCol(); col++) {
			res.add(grille.getCase(lig, col));
		}
		return res;
	}

	private List<Case> getCol(int col) {
		List<Case> res = new ArrayList<Case>();
		for (int lig = 0; lig < grille.nbLig(); lig++) {
			res.add(grille.getCase(lig, col));
		}
		return res;
	}

	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (Case c : cases) {
			if (!c.isPleine()) {
				e.add(c);
			} else {
				if (e.size() >= 2){
					places.add(e);
					e.clear();
				} else {
					e.clear();
				}
			}
		}
		if (e.size() >= 2){
			places.add(e);
		}
	}
}
