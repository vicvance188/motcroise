package pobj.motx.tme3;

public class StratFirst implements IChoixVar {

  public StratFirst() {

  }

  IVariable chooseVar(ICSP problem) {
    return problem.getVars().get(0);
  }
}
