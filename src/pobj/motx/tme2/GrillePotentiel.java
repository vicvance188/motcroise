package pobj.motx.tme2;

import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme1.Emplacement;
import java.util.ArrayList;
import java.util.List;

public class GrillePotentiel {

  private GrillePlaces grille;
  private Dictionnaire dicoComplet;
  private List<Dictionnaire> motsPot;

  public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
    this.grille = grille;
    this.dicoComplet = dicoComplet;
    this.motsPot = new ArrayList<Dictionnaire>();

    Dictionnaire dico = new Dictionnaire();
    for (Emplacement e : grille.getPlaces()) {
      dico = dicoComplet.copy();
      dico.filtreLongueur(e.size());
      motsPot.add(dico);
    }
  }

  public boolean isDead() {
    for (Dictionnaire d : motsPot) {
      if (d.size() == 0) return true;
    }
    return false;
  }

  public List<Dictionnaire> getMotsPot() {
    return motsPot;
  }
}
