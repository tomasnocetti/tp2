package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.tp2.Jugador;

public class CartaFactory {
	
	public static CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa) {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4, puntosAtaque, puntosDefensa, jugador);
		jugador.colocarCartaEnZona(carta, 0);
		return carta;
	}
}
