package pobj.motx.tme1;

import java.util.List;

public class Emplacement {
	private List<Case> lettres;
	
	public Emplacement() {
		
	}
	
	public String toString() {
		String res = "";
		for(int index = 0; index<lettres.size(); index++) {
			res += lettres.get(index);
		}
		return res;
	}
	
	public int size() {
		
		return lettres.size();
	}
	
}
