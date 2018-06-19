package fiuba.algo3.tp2.Tableros;

import fiuba.algo3.tp2.Jugador;

public class ZonaMano extends Zona{
		
	public ZonaMano(Jugador jugador) {
		super(jugador);
		this.limite = 10;
		// TODO Auto-generated constructor stub
	}

	public void agarrarCarta(Mazo mazo) {
		super.agregarCarta(mazo.agarrarCarta(), this.cartas.size());
	}
	
}
