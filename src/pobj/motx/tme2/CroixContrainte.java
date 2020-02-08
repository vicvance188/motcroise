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
    int i = 0;

    Dictionnaire d1 = grille.getMotsPot().get(m1);
    Dictionnaire d2 = grille.getMotsPot().get(m2);

    EnsembleLettre e1 = d1.lettresPosition(c1);
    EnsembleLettre e2 = d2.lettresPosition(c2);

    EnsembleLettre inter = e1.intersection(e2);

    if (e1.size() > inter.size())
      i += d1.filtreParLettres(inter, c1);
    if (e2.size() > inter.size())
      i += d2.filtreParLettres(inter, c2);

    return i;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this)
      return true;
    if (! (other instanceof CroixContrainte))
      return false;
    CroixContrainte cr = (CroixContrainte) other;
    return cr.m1 == m1 && cr.c1 == c1 && cr.m2 == m2 && cr.c2 == c2;
  }

  @Override
  public int hashCode() {
    return (m1 + c1 + m2 + c2) * 33;
  }
}
