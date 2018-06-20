package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class Mazo{
	
	private ArrayList<Carta> cartas;
	private Jugador jugador;
	
	public Mazo(Jugador _jugador, ArrayList<Carta> _cartas) {
		this.cartas = _cartas;
		this.jugador = _jugador;
	}

	public Carta agarrarCarta() {
		if (this.cartas.size() == 0) {
			Juego.ObtenerJuego().asignarPerdedor(this.jugador);
			return null;
		}
		Carta carta = cartas.remove(this.cartas.size() - 1);
		return carta;
	}

	public int obtenerCantidadDeCartas() {
		return this.cartas.size();
	}
	
	
}
