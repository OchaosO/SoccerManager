package com.java.intensivkurs.fussballmanager;
/**
 * 
 * @author rwurm
 *
 */

public class Trainer extends Person{
	private int erfahrung;
	
	// Konstruktor mit aufruf super() damit der Knstruktor der Klasse die geerbt wurde ausgeführt wird
	public Trainer(String n, int a, int erf){
		super (n, a);
		erfahrung = erf;
		
	}
	
	public void setErfahrung(int erf){
		erfahrung = erf;
	}
	
	public int getErfahrung(){
		return erfahrung;
	}

}
