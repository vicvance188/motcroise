package pobj.motx.tme3;

import java.util.List;
import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable {

  private int index;
  private GrillePotentiel gp;
  private List<String> domaine;

  public DicoVariable(int index, GrillePotentiel gp) {
    this.index = index;
    this.gp = gp;
    this.domaine = gp.getMotsPot().get(index).copy().getMots();
  }

  public List<String> getDomain() {
    return domaine;
  }

  public int getIndex() {
    return index;
  }

  @Override
  public String toString() {
    return super.toString(); //TODO
  }
}
