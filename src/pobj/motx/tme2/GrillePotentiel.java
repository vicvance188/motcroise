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

  private GrillePlaces       gp;
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
    this.gp = grille;
    this.dicoComplet = dicoComplet;
    this.motsPot = new ArrayList<Dictionnaire>();
    this.contraintes = new ArrayList<IContrainte>();

    // Filtres par longueur et par lettre
    Dictionnaire dico = new Dictionnaire();
    int i;
    for (Emplacement e : gp.getPlaces()) {
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

    // Detection des croisements
    List<Emplacement> places = gp.getPlaces();
    Emplacement l1, l2;
    int c1, c2, nbHoriz = gp.getNbHorizontal();
    for (int m1 = 0; m1 < nbHoriz; m1++) {
      for (int m2 = nbHoriz; m2 < places.size(); m2++) {
        l1 = places.get(m1);
        l2 = places.get(m2);
        c1 = l2.get(0).getCol() - l1.get(0).getCol();
        c2 = l1.get(0).getLig() - l2.get(0).getLig();
        if (c1 >= 0 && c1 < l1.size() && c2 >=0 && c2 < l2.size() && l1.get(c1).isVide())
          contraintes.add(new CroixContrainte(m1, c1, m2, c2));
      }
    }
    propage();
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
    return new GrillePotentiel(gp.fixer(m, soluce), dicoComplet);
  }

  /**
   * effectue la propagation des contraintes jusqu'à stabilité
   * @return true si la stabilité est atteinte,
   *          false si le mot croisé est irréalisable
   */
  private boolean propage() {
    int n;
    while(true) {
      n = 0;
      for (IContrainte c : contraintes) {
        n += c.reduce(this);
      }
      if (isDead())
        return false;
      if (n == 0)
        return true;
    }
  }
}
