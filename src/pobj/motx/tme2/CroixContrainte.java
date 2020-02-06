package pobj.motx.tme2;

import java.util.List;

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
    /*
    EnsembleLettre e1 = new EnsembleLettre();
    EnsembleLettre e2 = new EnsembleLettre();
    Dictionnaire d1 = grille.getMotsPot().get(m1);
    Dictionnaire d2 = grille.getMotsPot().get(m2);
    for (int i = 0; i < d1.size(); i++) {
      e1.add(d1.get(i).charAt(c1));
    }
    for (int i = 0; i < d2.size(); i++) {
      e1.add(d2.get(i).charAt(c2));
    }

    EnsembleLettre inter = e1.intersection(e2);

    Dictionnaire resd1 = new Dictionnaire();

    for (Character c : inter.getEnsemble()) {
        for(String mots : d1) {
          d1.get(i).get(c1) == c;
          resd1.add(d1.get(i));
        }
      Dictionnaire temp = d1.copy();
      temp.filtreParLettre(c, c1);


    }

    for(int i = 0; i<e1.size(); i++) {
      d1res.add(d1.filtreParLettre(e1.getChar(i), c1));
    }

    d1.filtreLongueur(len(Emplacement.get(m1)));
    d1.filtreLongueur(len(Emplacement.get(m2)));
    parcourir dico, ajouter toute les lettres à l'emplacement c1 (resp c2)'
    inter les deux ensembles de lettre
    for(c in ensemble lettre)
    d1.filtreParLettre(c, i)
    d2.filtreParLettre(c, i)
  }
  */
  return 0;
}
