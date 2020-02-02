package pobj.motx.tme1;

public class Grille {

	private int hauteur;
	private int largeur;
	private Case[][] grille;

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

	public Case getCase(int lig, int col) {
		return grille[lig][col];
	}

	@Override
	public String toString() {
		boolean isGrlFormat = false;
		return GrilleLoader.serialize(this, isGrlFormat);
	}

	public int nbLig() {
		return hauteur;
	}

	public int nbCol() {
		return largeur;
	}

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
