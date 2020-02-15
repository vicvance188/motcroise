package pobj.motx.tme3;

import java.util.List;
import java.util.Collections;
import pobj.motx.tme3.csp.ICSP;

public class StratAleatoire implements IChoixValeur {

  public List<String> orderValues (ICSP problem, IVariable v) {
    List<String> res = v.getDomain();
    Collections.shuffle(res);
    return res;
  }
}
