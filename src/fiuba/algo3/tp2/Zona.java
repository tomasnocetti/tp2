package fiuba.algo3.tp2;

import java.util.ArrayList;

public abstract class Zona {
	
	protected ArrayList<Carta> cartas;
	protected int limite;
	
	public void agregarCarta(Carta carta) {
		if (this.limite +1 > this.limite) {
			throw new ZonaAlcanzoCantidadMaximaDeCartasError();
		}
		this.cartas.add(carta);
	}
}
