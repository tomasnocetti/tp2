package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Excepciones.MazoDeCartasVacioException;

public class Mazo{
	
	private int cantidadDeCartas;
	private ArrayList<Carta> cartas;
	
	public Mazo() {
		this.cantidadDeCartas = 40;
		this.cartas = new ArrayList<Carta>();
	}

	public Carta agarrarCarta() {
		if (this.cantidadDeCartas == 0) {
			throw new MazoDeCartasVacioException();
		}
		Carta carta = cartas.remove(cantidadDeCartas);
		this.cantidadDeCartas -=1;
		return carta;
	}
}
