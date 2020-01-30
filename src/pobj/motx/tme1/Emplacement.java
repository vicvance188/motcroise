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
	
	public void add(Case caze) {
		this.add(caze);
	}
	
	public void clear() {
		this.clear();
	}
	
	public Case get(int index) {
		return this.get(index);
	}
	
	public int size() {
		return this.size();
	}
	
}
