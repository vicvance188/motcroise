package pobj.motx.tme1;

/**
 * classe représentant notre grille, soit un tableau à deux dimension de case
 *
 */
public class Grille {

	private int hauteur;		/** hauteur de notre grille */
	private int largeur;		/** largeur de notre grille */
	private Case[][] grille;	/** notre grille composé d'un tableau à deux dimensions de Case */

	/**
	 * Constructeur de la classe Grille : construction d'un tableau de dimension hauteur x largeur de Case
	 * @param hauteur hauteur de notre grille
	 * @param largeur largeur de notre grille
	 */
	public Grille(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.grille = new Case[hauteur][largeur];

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				grille[i][j] = new Case(i, j, ' ');
			}
		}
	}

	/**
	 * accesseur de la case en position (lig, col) de notre grille
	 * @param lig la ligne de notre case
	 * @param col la colonne de notre case
	 * @return la grille en position (lig, col)
	 */
	public Case getCase(int lig, int col) {
		return grille[lig][col];
	}

	/**
	 * fonction permettant d'afficher notre grille
	 */
	@Override
	public String toString() {
		boolean isGrlFormat = false;
		return GrilleLoader.serialize(this, isGrlFormat);
	}

	/**
	 * renvoie le nombre de ligne de la grille
	 * @return hauteur ( ou nombre de ligne ) de la grille
	 */
	public int nbLig() {
		return hauteur;
	}

	/**
	 * renvoie le nombre de colonne de notre grille
	 * @return largeur ( ou nombre de colonne ) de la grille
	 */
	public int nbCol() {
		return largeur;
	}

	/**
	 * fonction permettant de creer une copie de notre grille
	 * @return une copie de notre grille
	 */
	public Grille copy() {
		Grille g2 = new Grille(hauteur, largeur);
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				g2.getCase(i, j).setChar(this.getCase(i, j).getChar());
			}
		}
		return g2;
	}
}
