package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTtest;

public class KjedetKoeTest extends KoeADTtest {

	@Override
	protected KoeADT<Integer> reset() {
		
		return new KjedetKoe<Integer>();
	}
	
}
