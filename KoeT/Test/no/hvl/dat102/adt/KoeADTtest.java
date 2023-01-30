package no.hvl.dat102.adt;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTtest {

	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	@Test
	public void foerstInnfoerstUt() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		assertEquals("Første inn er første", e0, koe.foerste());
		assertEquals("Første inn er først ut", e0, koe.utKoe());				
		
	}
	
	/**
	 * Test om en toemt koe er tom
	 */
	
	@Test
	public void InnOgUtTom() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		
		assertTrue("Test tom koe", koe.erTom());
	}
	
	@Test
	public void ikkeTom() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		
		koe.utKoe();
		
		assertFalse("Tester om koen ikke er tom", koe.erTom());
		
	}
	
	@Test
	public void riktigRekkefoelge() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);	
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
		koe.utKoe();
	
		assertEquals("Test riktig rekkefoelge", e2, koe.foerste());		
		
	}
	
	@Test
	public void emptyUt() {
		
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
		
	}

} 
