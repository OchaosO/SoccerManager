package chaosnetworkz.java.samples.soccermanager;

/**
 * 
 * @author rwurm
 * 
 */

public class Person {
	private String name;
	private int alter;
	
	
	// Konstruktor
	public Person(String n, int a){
		name = n;
		alter = a;
	}
	
	public void setName(String n){
		name= n;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAlter(int a){
		alter = a;
	}
	
	public int getAlter(){
		return alter;
	}
	
}
