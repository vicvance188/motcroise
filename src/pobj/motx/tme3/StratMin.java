package pobj.motx.tme3;

import pobj.motx.tme3.csp.ICSP;

/**
 * statégie qui renvoie la variable qui a le plus petit domaine
 *
 */
public class StratMin implements IChoixVar {

  public IVariable chooseVar(ICSP problem) {
    IVariable res = problem.getVars().get(0);
    for (IVariable v : problem.getVars())
      if (v.getDomain().size() < v.getDomain().size())
        res = v;
    return res;
  }
}
