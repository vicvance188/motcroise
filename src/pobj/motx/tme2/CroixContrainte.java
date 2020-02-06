package pobj.motx.tme2;

public class CroixContrainte implements IContrainte {

  private int m1, c1, m2, c2;

  public CroixContrainte(int m1, int c1, int m2, int c2) {
    this.m1 = m1;
    this.c1 = c1;
    this.m2 = m2;
    this.c2 = c2;
  }

  public int reduce(GrillePotentiel grille) {
    //appel si croisement à une case non vide
    //on recupere notre lettre, pour l'emplacement libre, on reduit le dictionnaire
    //premierement on garde les mots de bonne longueur
    //ensuite on garde les mots qui ont la bonne lettre au bon emplacement
    //on renvoie les deux dico
    // on fait l'intersection
  }

}
