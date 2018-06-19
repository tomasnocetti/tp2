package fiuba.algo3.tp2.Cartas;

import java.util.ArrayList;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;

public class CartaFactory {

//	public static CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa) {
//		Jugador jugador = new Jugador();
//		Efecto efecto = new EfectoVacio();
//		CartaMonstruo carta = new CartaMonstruo(jugador, efecto, 4, puntosAtaque, puntosDefensa);
//		jugador.colocarCartaEnZona(carta, 0, new ArrayList<CartaMonstruo>());
//		return carta;
//	}
	
	public static CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa, Jugador jugador) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo(jugador, efecto, 4, puntosAtaque, puntosDefensa);
		jugador.colocarCartaEnZona(carta, 0, new ArrayList<CartaMonstruo>());
		return carta;
	}
	
	public static CartaMagica crearCartaMagicaParaJugador(Jugador jugador) {
		Efecto efecto = new EfectoVacio();
		CartaMagica carta = new CartaMagica(jugador, efecto);
		return carta;
	}
}
