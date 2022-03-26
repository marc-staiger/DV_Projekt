
public class Werkstueck {
	
		//Belegung der Attributen
	
		private double dichte;
		private double volumen;
		private boolean fehler=false;
		
		
		//Standardkonstruktor: Hier werden Standard-Werte vorgegeben
		
		public Werkstueck() {
			dichte=0.01;
			volumen=1000;
		}
		
		
		//set-Methoden
		
		public Werkstueck(double di,double v) {
			setDichte(di);
			setVolumen(v);
		}
		
		
		//Methode Massenberechnung
		
		public double massenberechnung (){
			double masse;
			if (fehler==false) {
				
				masse=dichte*volumen;
				
					return masse;
			} else {
				masse=0;
				return masse;
			}
		}
		
		//set-Methode als Schnittstelle der Variablenzuweisung
		//Überprüfung auf Fehlerhafte Eingabe (ist ein Wert "=< 0" so wird
		//Variable "fehler" auf "true" gesetzt
		
		public void setDichte(double di){
			if (di>0) this.dichte=di;
			else fehler=true;
		}
		
		public void setVolumen(double v){
			if (v>0) this.volumen=v;
			else fehler=true;
		}
		
		public boolean getFehler() {
			return this.fehler;
		}
}
