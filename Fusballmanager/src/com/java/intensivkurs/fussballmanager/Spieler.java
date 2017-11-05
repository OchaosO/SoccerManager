package com.java.intensivkurs.fussballmanager;

import java.util.Random;

/**
 * 
 * @author rwurm
 *
 */

public class Spieler extends Person{
	private int staerke; // von 1 schlecht bis 10 super
	private int torschuss; // von 1 schlecht bis 10 super
	private int motivation; // von 1 schlecht bis 10 super
	private int tore;
	
	
	// Konstruktor mit aufruf super() damit der Konstruktor der Klasse die geerbt wurde ausgeführt wird
	public Spieler(String n, int a, int s, int t, int m){
		super(n,a);
		staerke = s;
		torschuss = t;
		motivation = m;
		tore = 0;
	}
	
	public void setStaerke(int s){
		staerke = s;
	}
	
	public int getStaerke(){
		return staerke;
	}
	
	public void setTorschus(int t){
		torschuss = t;
	}
	
	public int getTorschuss(){
		return torschuss;
	}
	
	public void setMotivation(int m){
		motivation = m;
	}
	
	public int getMotivation(){
		return motivation;
	}
	
	// Der Spieler hat ein Tor geschossen
	public void setTore(int to){
		tore = tore + to;
	}
	
	public int getTore(){
		return tore;
	}

	// Der Spieler hat ein Tor geschossen
	public void addTor(){
		tore++;
	}
	
	// Eine Zahl zwischen 1 und 10 liefert die Qualität des Torschusses Qualität des Torschusses
	public int schiesstAufTor(){
		Random r = new Random();
		torschuss = Math.max(1, Math.min(10, torschuss - r.nextInt(3)));
		return torschuss;
	}
	
}
