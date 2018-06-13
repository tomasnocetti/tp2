package fiuba.algo3.tp2;

import java.util.ArrayList;

public abstract class Zona {
	
	protected ArrayList<Carta> cartas;
	protected int limite;
	protected int cantidadDeCartas;
	protected Tablero tablero;
	
	protected void _agregarCarta(Carta carta, int posicion) {
		if (this.cantidadDeCartas +1 > this.limite || posicion > limite) {
			throw new ZonaAlcanzoCantidadMaximaDeCartasError();
		}
		if (cartas.get(posicion) != null) {
			throw new PosicionDeLaZonaOcupadaException();
		}
		this.cantidadDeCartas +=1;
		this.cartas.add(posicion, carta);
	}
	
	public void eliminarCarta(Carta carta) {
		int posicion = cartas.indexOf(carta);
		this.cartas.set(posicion, null);
		this.tablero.destruirCarta(carta);
	}
	
	protected void settearArregleInicial(int n,ArrayList<Carta> arreglo) {
		for (int i=0; i<n; i++) {
			arreglo.add(i, null);
		}
	}
}