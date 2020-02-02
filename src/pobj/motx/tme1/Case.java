package pobj.motx.tme1;

/**
* Classe representant une case dans la grille
*/
public class Case {

	private int lign;	/** ligne de la case */
	private int col;	/** colonne de la case */
	private char c; 	/** contenu de la case */

	/**
	* Construit une case aux contenu et coordonnees initiales specifiees
	* @param lign ligne initiale de la case
	* @param col colonne initiale de la case
	* @param c contenu initial de la case
	*/
	public Case(int lign, int col, char c) {
		this.lign = lign;
		this.col = col;
		this.c = c;
	}

	/**
	* Accede a la ligne de la case
	* @return la ligne lign de la case
	*/
	public int getLig() {
		return lign;
	}

	/**
	* Accede a la colonne de la case
	* @return la colonne col de la case
	*/
	public int getCol() {
		return col;
	}

	/**
	* Accede au contenu de la case
	* @return le contenu c de la case
	*/
	public char getChar() {
		return c;
	}

	/**
	* Modifie le contenu de la case
	* @param c caractere a ecrire dans la case
	*/
	public void setChar(char c) {
		this.c = c;
	}

	/**
	* Teste si la case est vide
	*/
	public boolean isVide() {
		return (c == ' ');
	}

	/**
	* Teste si la case est pleine
	*/
	public boolean isPleine() {
		return (c == '*');
	}
}
