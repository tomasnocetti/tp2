package fiuba.algo3.tp2.Tableros;

import java.io.Serializable;
import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.Carta;

public class Cementerio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<Carta> cartas;

	public Cementerio() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void agregarCarta(Carta carta) {
		cartas.add(carta);
	}
	
	public ArrayList<Carta> obtenerCartas() {
		return this.cartas;
	}
}
