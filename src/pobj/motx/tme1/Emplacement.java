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
		for (Case lettre : lettres) {
			sb.append(lettre.getChar());
		}
		return sb.toString();
	}

	public int size() {
		return lettres.size();
	}

	public void add(Case c) {
		lettres.add(c);
	}
}
