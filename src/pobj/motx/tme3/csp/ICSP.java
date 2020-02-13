package pobj.motx.tme3.csp;

import java.util.List;
import pobj.motx.tme3.IVariable;

/**
 * interface ICSP
 *
 */
public interface ICSP {

  public List<IVariable> getVars();

  public boolean isConsistent();

  public ICSP assign(IVariable vi, String val);
}
