package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.tp2.Jugador;

public class CartaFactory {
	
	public static CartaMonstruo crearCartaMonstruoGenerica() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4, 1000, 100, jugador);
		jugador.colocarCartaEnZona(carta, 0);
		return carta;
	}
}
