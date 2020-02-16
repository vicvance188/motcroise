package pobj.motx.tme3.test;

import static org.junit.Assert.*;
import pobj.motx.tme3.IChoixVar;
import pobj.motx.tme3.StratFirst;
import pobj.motx.tme3.StratMin;
import pobj.motx.tme3.StratBasique;
import pobj.motx.tme3.StratAleatoire;

import org.junit.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.adapt.MotX;
import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.ICSP;

public class GrilleSolverTest {

	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");
		// Grille gr = GrilleLoader.loadGrille("data/larger.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		// System.out.println(gp);
		// assertTrue(! gp.isDead());

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setChoixVarStrat(new StratFirst());
		solver.setChoixVarStrat(new StratMin());

		solver.setChoixValStrat(new StratBasique());
		// solver.setChoixValStrat(new StratAleatoire());
		// solver.setChoixValStrat(new StratFrequence());

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
