package pobj.motx.tme3;

import java.util.List;
import pobj.motx.tme2.GrillePotentiel;

/**
 * clase DicoVariable permettant de gérer les variables de notre grille par le solveur
 *
 */
public class DicoVariable implements IVariable {

  private int index;            /** indice de notre emplacement */
  private GrillePotentiel gp;   /** la grille potentiel correspondante*/
  private List<String> domaine; /** le domaine : Dictionnaire des possiblité*/

  /**
   * constructeur de Dico Variable
   * @param index indice de notre emplacement
   * @param gp    notre Grille Potentiel
   */
  public DicoVariable(int index, GrillePotentiel gp) {
    this.index = index;
    this.gp = gp;
    this.domaine = gp.getMotsPot().get(index).getMots();
  }

  /** retourne le domaine
   * @return le domaine
   */
  public List<String> getDomain() {
    return domaine;
  }

  /**
   * retourne l'indice
   * @return l'indice
   */
  public int getIndex() {
    return index;
  }

  @Override
  public String toString() {
    //return "domaine = "+domaine;
    return super.toString();
  }
}
