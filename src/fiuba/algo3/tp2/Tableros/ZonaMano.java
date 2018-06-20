package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class ZonaMano extends Zona{
		
	public ZonaMano(Jugador jugador) {
		super(jugador);
		this.limite = 10;
		// TODO Auto-generated constructor stub
	}

	public Carta agarrarCarta(Mazo mazo) {
		Carta nuevaCarta = mazo.agarrarCarta();
		super.agregarCarta(nuevaCarta, this.cartas.size());
		return nuevaCarta;
	}
	
}
