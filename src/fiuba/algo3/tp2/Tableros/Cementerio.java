package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.Carta;

public class Cementerio{
	
	protected ArrayList<Carta> cartas;

	public Cementerio() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void agregarCarta(Carta carta) {
		cartas.add(carta);
	}
}
