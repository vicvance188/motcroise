package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.IVariable;
import pobj.motx.tme3.DicoVariable;

/**
 * classe MotX servant a adapter le solveur à notre proSblème
 *
 */
public class MotX implements ICSP {

  private GrillePotentiel gp;
  private List<IVariable> liste_dico;

  /**
   * Son constructeur
   * initialisera une liste de DicoVariable, stockée dans un attribut.
   * @param gp
   */
  public MotX(GrillePotentiel gp) {
    this.gp = gp;
    this.liste_dico = new ArrayList<IVariable>();
    List<Emplacement> l = gp.getGrillePlaces().getPlaces();
    for (int i = 0; i < l.size(); i++) {
      if (l.get(i).hasCaseVide())
        liste_dico.add(new DicoVariable(i, gp));
    }
  }

  /**
   * retourne notre liste de variable
   */
  public List<IVariable> getVars() {
    return liste_dico;
  }

  /**
   * renvoie si le problème est consistent
   */
  public boolean isConsistent() {
    return !gp.isDead();
  }

  /**
   * assigne une nouvelle variable
   */
  public ICSP assign(IVariable vi, String val) {
    if (vi instanceof DicoVariable) {
      DicoVariable dicoVar = (DicoVariable) vi;
      return new MotX(gp.fixer(dicoVar.getIndex(), val));
    }
    return null;
  }
}
