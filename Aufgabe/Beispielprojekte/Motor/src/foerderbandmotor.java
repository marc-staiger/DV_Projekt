
public class foerderbandmotor {

	//Belegung der Attributen
	
	private Werkstueck werkstueck1;
	private double winkel;
	private double scheibendurchmesser;
	private double tm_motor;
	private double tm_scheibe;
	private double strecke;
	private int zeit_sec;
	private double erdbeschl=9.81;
	private boolean fehler=false;
	
	
	//Standardkonstruktor: Hier werden Standard-Werte vorgegeben
	
	public foerderbandmotor() {
		werkstueck1=new Werkstueck();
		winkel=20;
		scheibendurchmesser=30;
		tm_motor=40;
		tm_scheibe=35;
		strecke=2;
		zeit_sec=2;
	}
	
	//public-Methode, auf diese von außen zugegriffen werden kann
	
	
	
	
	public foerderbandmotor(double di, double v,double w,double d,double tm,double ts,double s,int t) {
		werkstueck1=new Werkstueck(di,v);
		setWinkel(w);
		setScheibendurchmesser(d);
		setTm_motor(tm);
		setTm_scheibe(ts);
		setStrecke(s);
		setZeit_sec(t);
	}
	
	//Operation Leistungsberechnung
	//fehlerfrei --> Leistungsberechnung mithilfe der Formeln
	//fehlerhaft --> der Leistung wird Wert "0" zugewiesen
	
	
	
	public double leistungsberechnung (){
		double leistung;
		if (fehler==false) {
			double masse=berechneMasse();
			
			leistung=((Math.sin(winkel*Math.PI/180))*erdbeschl*masse*scheibendurchmesser/2);					
			leistung=+((tm_motor+tm_scheibe)*strecke*4/Math.pow(zeit_sec, 2)/scheibendurchmesser);
			leistung=leistung*(strecke*2/scheibendurchmesser/zeit_sec);
			
				return leistung;
		} else {
			leistung=0;
			return leistung;
		}
	}
	

	public double berechneMasse() {
		double masse=werkstueck1.massenberechnung();
		return masse;
	}

	//set-Methode als Schnittstelle der Variablenzuweisung
	//Überprüfung auf Fehlerhafte Eingabe (ist ein Wert "=< 0" so wird
	//Variable "fehler" auf "true" gesetzt
	
	public void setWinkel(double w){
		if (w>=0) this.winkel=w;
		else fehler=true;
	}
	
	public void setScheibendurchmesser(double d){
		if (d>0) this.scheibendurchmesser=d;
		else fehler=true;
	}
	
	public void setTm_motor(double tm){
		if (tm>0) this.tm_motor=tm;
		else fehler=true;
	}
	
	public void setTm_scheibe(double ts){
		if (ts>0) this.tm_scheibe=ts;
		else fehler=true;
	}
	
	public void setStrecke(double s){
		if (s>0) this.strecke=s;
		else fehler=true;
	}
	
	public void setZeit_sec(int t){
		if (t>0) this.zeit_sec=t;
		else fehler=true;
	}
	
	public boolean getFehler() {
		return this.fehler;
	}
}
