package fiuba.algo3.tp2.Tableros;

import java.util.Hashtable;

import fiuba.algo3.tp2.Cartas.Carta;

public class ZonaMano extends Zona{
	
	public ZonaMano() {
		this.limite = 10;
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
	public void agarrarCarta(Mazo mazo) {
		super.agregarCarta(mazo.agarrarCarta(),this.cartas.size());
	}
	
}
