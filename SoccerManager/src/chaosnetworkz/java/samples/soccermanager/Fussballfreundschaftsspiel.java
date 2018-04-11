package chaosnetworkz.java.samples.soccermanager;

import java.util.Random;

public class Fussballfreundschaftsspiel implements Freundschaftsspiel{
	private String nameHeimMannschaft;
	private String nameGastMannschaft;
	private int punkteHeim;
	private int punkteGast;

	@Override
	public String getHeimMannschaft() {
		// TODO Auto-generated method stub
		return nameHeimMannschaft;
	}

	@Override
	public String getGastMannschaft() {
		// TODO Auto-generated method stub
		return nameGastMannschaft;
	}

	@Override
	public int getHeimPunkte() {
		// TODO Auto-generated method stub
		return punkteHeim;
	}

	@Override
	public int getGastPunkte() {
		// TODO Auto-generated method stub
		return punkteGast;
	}
	
	@Override
	public String getErgebnisText(){
		return "Das Freundschaftsspiel endet: \n\n"+nameHeimMannschaft+" - "+nameGastMannschaft+"  "+punkteHeim+":"+punkteGast;
	}
	
	// Ein Fussballfreundschaftsspiel zwischen zwei Mannschaften wird gestartet
	public void starteSpiel(Mannschaft m1, Mannschaft m2){
		nameHeimMannschaft = m1.getName();
		nameGastMannschaft = m2.getName();
		punkteHeim = 0;
		punkteGast = 0;
		
		// Das Spiel startet und erzeugt für 90 Minuten plus Nachspielzeit diverse Aktionen
		Random r = new Random();
		
		boolean spiellaeuft = true;
		int spieldauer = 90 + r.nextInt(5);
		int zeit = 1;
		int naechsteAktion;
		
		//Solange das Spiel läuft können Torchancen enstehen
		while (spiellaeuft) {
			naechsteAktion = r.nextInt(15)+1;
			
			// Ist das Spiel schon zu Ende?
			if ((zeit + naechsteAktion>spieldauer) || (zeit > spieldauer) ) {
				spiellaeuft = false;
				break;
			}
			
			// Eine neue Aktion findet statt
			zeit = zeit + naechsteAktion;
			// Auswahl einer Mannschaft, die den Torschuss durchführt. Faktoren hier sind
			// Staerke, Motivation der Mannschaft und die Erfahrung des Trainers
			// Einfluss der Motivation auf die Staerke
			float staerke_1 = (m1.getStaerke()/2.0f) + ((m1.getStaerke()/2.0f)*m1.getMotivation()/10.0f);
			float staerke_2 = (m2.getStaerke()/2.0f) + ((m2.getStaerke()/2.0f)*m2.getMotivation()/10.0f);
			//Einfluss des Trainers auf die Staerke
			int abweichung = r.nextInt(2);
			if (staerke_1 > m1.getTrainer().getErfahrung()){
				abweichung = -abweichung;
			}
			staerke_1 = Math.max(1, Math.min(10, staerke_1 + abweichung));
			abweichung = r.nextInt(2);
			if (staerke_2 > m2.getTrainer().getErfahrung()){
				abweichung = -abweichung;
			}
			staerke_2 = Math.max(1, Math.min(10, staerke_2 + abweichung));
			
			//Auswahl eines zufaelligen Spielers aus der Mannschaft, die den Toschuss durchführt
			int schuetze = r.nextInt(10);
			
			if ((r.nextInt(Math.round(staerke_1+staerke_2))-staerke_1)<=0){
				// Mannschaft (Heimmannschaft) 1 schiesst auf Tor
				Spieler s = m1.getKader()[schuetze];
				Torwart t = m2.getTorwart();
				int torschuss = s.schiesstAufTor();
				// Wird der Schuss gehalten?
				boolean tor = !t.haeltSchuss(torschuss);
				
				System.out.println();
				System.out.println(zeit+".Minute:  ");
				System.out.println("   Chance für  "+m1.getName()+"   .....");
				System.out.println("   "+s.getName()+"  zieht ab");
				
				if( tor ){
					punkteHeim++;
					s.addTor();
					System.out.println("  Toor!!!  "+punkteHeim+":"+punkteGast+"  "+s.getName()+"("+s.getTore()+")");
				} else {
					System.out.println("    "+m2.getTorwart().getName()+"  pariert glanzvoll.");
				}
			} else {
				// Mannschaft (Gastmannschaft) 1 schiesst auf Tor
				Spieler s = m2.getKader()[schuetze];
				Torwart t = m1.getTorwart();
				int torschuss = s.schiesstAufTor();
				// Wird der Schuss gehalten?
				boolean tor = !t.haeltSchuss(torschuss);
				
				System.out.println();
				System.out.println(zeit+".Minute:  ");
				System.out.println("   Chance für  "+m2.getName()+"   .....");
				System.out.println("   "+s.getName()+"  zieht ab");
				
				if( tor ){
					punkteGast++;
					s.addTor();
					System.out.println("  Toor!!!  "+punkteHeim+":"+punkteGast+"  "+s.getName()+"("+s.getTore()+")");
				} else {
					System.out.println("    "+m1.getTorwart().getName()+"  pariert glanzvoll.");
				}
				
			}
			
			
		}
		
		
	}

}
