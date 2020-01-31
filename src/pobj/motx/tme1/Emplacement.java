package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;


public class Emplacement {
	private List<Case> lettres;
	
	public Emplacement() {
		lettres = new ArrayList<Case>();
	}
	
	public String toString() {
		String res = "";
		for(int index = 0; index<lettres.size(); index++) {
			res += lettres.get(index);
		}
		return res;
	}
	
	public int size() {
		return this.size();
	}

	public void add(Case case1) {
		this.add(case1);
	}

	public Case get(int index) {
		return lettres.get(index);
	}
	
}
