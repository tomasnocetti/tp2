package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class Mazo{
	
	private int cantidadDeCartas;
	private ArrayList<Carta> cartas;
	private Jugador jugador;
	
	public Mazo(Jugador _jugador, ArrayList<Carta> _cartas) {
		this.cantidadDeCartas = 40;
		this.cartas = _cartas;
		this.jugador = _jugador;
	}

	public Carta agarrarCarta() {
		if (this.cantidadDeCartas == 0) {
			Juego.ObtenerJuego().asignarPerdedor(this.jugador);
			return null;
		}
		Carta carta = cartas.remove(cantidadDeCartas - 1);
		this.cantidadDeCartas -=1;
		return carta;
	}

	public int obtenerCantidadDeCartas() {
		return this.cantidadDeCartas;
	}
	
	
}
