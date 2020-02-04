package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**
 * classe permettant de chercher tout les emplacements present dans notre grille
 * et de creer une liste d'emplacement
 */
public class GrillePlaces {

	private List<Emplacement> places; 	/** Liste d'emplacement ( liste de liste de case ) */
										/**ou l'on mettra les emplacements trouvé en parcourant la grille */
	private Grille grille;				/** grille ou l'on fait la recherche d'emplacement */
	private int nbHorizontal;			/** variable nous donnant le nombre d'emplacement horrizontal */

	/**
	 * constructeur de notre classe GrillePlace
	 * faisant le recherche des emplacements de la grille
	 * @param grille notre grille
	 */
	public GrillePlaces(Grille grille) {
		System.out.println("Voici la grille:");
		System.out.println(grille);
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
		System.out.println(this);
	}

	/**
	 * getter retournant la liste d'emplacement trouvé
	 * @return la lsite d'emplacement trouvé
	 */
	public List<Emplacement> getPlaces() {
		return places;
	}

	/**
	 * renvoie le nombre d'emplacement horrizontaux trouvé
	 * @return le nombre d'emplacement horrizontaux trouvé
	 */
	public int getNbHorizontal() {
		return nbHorizontal;
	}

	/**
	 * Méthode affichant la liste des emplacements trouvé
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("liste d'emplacements detectes:\n");
		for (Emplacement e : places) {
			sb.append("emplacement de taille "+e.size()+":\t"+"\""+e+"\""+"\n");
		}
		return sb.toString();
	}

	/**
	 * methode permettant d'extraire une ligne de notre grille
	 * afin de fractionner la recherche d'emplacement
	 * @param lig l'indice de la ligne que nous voulons retourner
	 * @return la ligne que nous retournons (liste de Case)
	 */
	private List<Case> getLig(int lig){
		List<Case> res = new ArrayList<Case>();
		for (int col = 0; col < grille.nbCol(); col++) {
			res.add(grille.getCase(lig, col));
		}
		return res;
	}

	/**
	 * methode permettant d'extraire une colonne de notre grille
	 * afin de fractionner la recherche d'emplacement
	 * @param col l'indice de la colonne que nous voulons retourné
	 * @return la colonne que nous retournons (liste de Case)
	 */
	private List<Case> getCol(int col) {
		List<Case> res = new ArrayList<Case>();
		for (int lig = 0; lig < grille.nbLig(); lig++) {
			res.add(grille.getCase(lig, col));
		}
		return res;
	}

	/**
	 * methode cherchant les emplacements dans une ligne donnée
	 * @param cases la ligne donnée
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (Case c : cases) {
			if (!c.isPleine()) {
				e.add(c);
			} else {
				if (e.size() >= 2){
					places.add(e);
				}
				e = new Emplacement();
			}
		}
		if (e.size() >= 2){
			places.add(e);
		}
	}

	public GrillePlaces fixer(int m, String soluce) {
		Grille g = grille.copy();
		int i = 0;
		for (Case c : places.get(m).getLettres()) {
			g.getCase(c.getLig(), c.getCol()).setChar(soluce.charAt(i));
			i ++;
		}
		return new GrillePlaces(g);
	}
}
