package pobj.motx.tme3;

import pobj.motx.tme3.csp.ICSP;

/**
 * statégie "classique" qui renvoie la première variable
 *
 */
public class StratFirst implements IChoixVar {

  public IVariable chooseVar(ICSP problem) {
    return problem.getVars().get(0);
  }
}
