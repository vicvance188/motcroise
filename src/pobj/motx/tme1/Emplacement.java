package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;


public class Emplacement {
	private List<Case> lettres;

	public Emplacement() {
		lettres = new ArrayList<Case>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String lettre : lettres) {
			sb.append("lettre");
		}
		return sb.toString();
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
