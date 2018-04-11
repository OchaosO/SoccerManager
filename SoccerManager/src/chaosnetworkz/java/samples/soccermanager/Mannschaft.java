package chaosnetworkz.java.samples.soccermanager;

public class Mannschaft {
	String name;
	Spieler[] kader;
	Torwart torwart;
	Trainer trainer;
	
	// Konstruktor
	public Mannschaft(String n, Trainer t, Torwart tw, Spieler[] s){
		name = n;
		trainer = t;
		torwart = tw;
		kader = s;
	}
	
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	public void setKader(Spieler[] s){
		kader = s;
	}
	public Spieler[] getKader(){
		return kader;
	}
	
	public void setTorwart(Torwart tw){
		torwart = tw;
	}
	public Torwart getTorwart(){
		return torwart;
	}
	
	public void setTrainer(Trainer t){
		trainer = t;
	}
	public Trainer getTrainer(){
		return trainer;
	}

	// Liefert die durchschnittliche Mannschaftsstärke (Summe stärke aller Feldspieler / Anzahl der Feldspieler)
	public int getStaerke(){
		int summ = 0;
		for (int i=0;i<10;i++){
			summ += kader[i].getStaerke();
		}
		return summ/10;

	}
	
	// Liefert durchschnittliche Mannschaftsmotivation
	public int getMotivation(){
		int summ = 0;
		for (int i=0;i<10;i++){
			summ += kader[i].getMotivation();
		}
		return summ/10;
	}
}
