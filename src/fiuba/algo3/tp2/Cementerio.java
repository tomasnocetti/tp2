package fiuba.algo3.tp2;

import java.util.ArrayList;

public class Cementerio{
	
	protected ArrayList<Carta> cartas;

	public Cementerio() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void agarrarCarta(Carta carta) {
		carta.destruirCarta();
		cartas.add(carta);
	}
	
	
}
