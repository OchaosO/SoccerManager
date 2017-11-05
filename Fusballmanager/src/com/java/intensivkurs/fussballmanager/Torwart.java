package com.java.intensivkurs.fussballmanager;

import java.util.Random;

/**
 * 
 * @author rwurm
 *
 */

public class Torwart extends Spieler{
	private int reaktion;
	
	public Torwart(String n, int a, int s, int t, int m, int re){
		super(n, a, s, t, m);
		reaktion = re;
	}
	
	public void setReaktion(int re){
		reaktion = re;
	}
	
	public int getReaktion(){
		return reaktion;
	}
	
	public boolean haeltSchuss(int schuss){
		Random r = new Random();
		// Wert fur die Haltequalität des Torwarts
		int haelt = Math.max(1, Math.min(10, reaktion + r.nextInt(3)));
		// Nun wird ermittelt ob der Schuss gehalten wird
		if (haelt>=schuss)
			return true;
		else
			return false;
	}

}
