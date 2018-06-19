package fiuba.algo3.tp2.Tableros;

import java.util.Hashtable;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class ZonaMano extends Zona{
	
	private Jugador jugador;
	
	public ZonaMano(Jugador jugador) {
		this.limite = 10;
		this.cartas = new Hashtable<Integer,Carta>();
		this.jugador = jugador;
	}
	
	public void agarrarCarta(Mazo mazo) {
		super.agregarCarta(mazo.agarrarCarta(), this.cartas.size());
	}
	
}
