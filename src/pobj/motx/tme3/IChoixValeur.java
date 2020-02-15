package pobj.motx.tme3;

import java.util.List;
import pobj.motx.tme3.csp.ICSP;

public interface IChoixValeur {

  public List<String> orderValues (ICSP problem, IVariable v);
}
