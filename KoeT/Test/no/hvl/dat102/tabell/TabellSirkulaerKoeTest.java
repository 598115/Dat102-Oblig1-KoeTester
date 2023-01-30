package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTtest;


public class TabellSirkulaerKoeTest extends KoeADTtest {

	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}		
	

}
