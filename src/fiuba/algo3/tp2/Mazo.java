package fiuba.algo3.tp2;

import java.util.ArrayList;

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
