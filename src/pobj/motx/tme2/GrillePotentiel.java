package pobj.motx.tme2;

import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Case;
import java.util.ArrayList;
import java.util.List;

/**
 * classe permettant de traiter le dico de façon a avoir les mots pouvant aller
 * dans notre grille
 *
 */
public class GrillePotentiel {

  private GrillePlaces       grille;
  /** une grille ainsi que la liste des emplacements disponible */
  private Dictionnaire       dicoComplet;
  /** un dico complet de la langue française */
  private List<Dictionnaire> motsPot;
  /** domaine de chaque emplacement de la grille */
  private List<IContrainte> contraintes;
  /** liste des contraintes */

  /**
   * constructeur de la classe GrillePotentiel : initialise le attributs aux
   * valeurs données initialise le dommaine des emplacements
   *
   * @param grille
   *          notre grille partiellement remplie
   * @param dicoComplet
   *          notre dictionnaire non traité
   */
  public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
    this.grille = grille;
    this.dicoComplet = dicoComplet;
    this.motsPot = new ArrayList<Dictionnaire>();
    this.contraintes = new ArrayList<IContrainte>();

    Dictionnaire dico = new Dictionnaire();
    int i;
    int c1 = 0; int c2 = 0;
    for (Emplacement e : grille.getPlaces()) {
      dico = dicoComplet.copy();
      dico.filtreLongueur(e.size());
      i = 0;
      for (Case c : e.getLettres()) {
        if (!c.isVide())
          dico.filtreParLettre(c.getChar(), i);
        i++;
      }
      motsPot.add(dico);
    }
    for(int m1 = 0; m1 < grille.getNbHorizontal(); m1++ ){
      for(int m2 = grille.getNbHorizontal(); m2 < grille.getPlaces().size(); m2++ ){
        for(Case case1 : grille.getPlaces().get(m1).getLettres()){
          for(Case case2 : grille.getPlaces().get(m2).getLettres()){
            if(case1.getLig() == case2.getLig() && case1.getCol() == case2.getCol())
              contraintes.add(new CroixContrainte(m1, c1, m2, c2));
            c2++;
          }
          c1++;
        }
      }
    }
  }

  /**
   * rend vrai si et seulement si au moins un emplacement à un domaine
   * potentiellement vide
   *
   * @return True si au moins un emplacement à un domaine potentiellement vide,
   *         False sinon
   */
  public boolean isDead() {
    for (Dictionnaire d : motsPot) {
      if (d.size() == 0)
        return true;
    }
    return false;
  }

  /**
   * stocke le domaine de chaque emplacement de la grille
   *
   * @return List<Dictionnaire> le domaine de chaque emplacement de la grille dans
   *         le même ordre que la grille
   */
  public List<Dictionnaire> getMotsPot() {
    return motsPot;
  }

  /**
   * retourne la liste des contraintes
   *
   * @return List<IContraintes> la liste des contraintes
   */
  public List<IContrainte> getContraintes() {
    return contraintes;
  }

  /**
   * Initialise une nouvelle GrillePotentiel
   *
   * @param m
   *          emplacement du mot à ajouter
   * @param soluce
   *          mot à ajouter à l'emplacement m
   * @return une nouvelle GrillePotentiel avec la grille résultant de
   *         l'affectation du mot soluce à l'emplacement m
   */
  public GrillePotentiel fixer(int m, String soluce) {
    return new GrillePotentiel(grille.fixer(m, soluce), dicoComplet);
  }
}
