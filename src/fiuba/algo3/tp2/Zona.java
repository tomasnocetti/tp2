package fiuba.algo3.tp2;

import java.util.Collection;
import java.util.HashMap;

public abstract class Zona {
	
	protected HashMap<Integer,Carta> cartas;
	protected int limite;
	protected int cantidadDeCartas;
	protected Tablero tablero;
	
	protected void _agregarCarta(Carta carta, int posicion) {
		if (this.cantidadDeCartas +1 >= this.limite || posicion >= limite) {
			throw new ZonaAlcanzoCantidadMaximaDeCartasError();
		}
		if (cartas.get(posicion) != null) {
			throw new PosicionDeLaZonaOcupadaException();
		}
		this.cantidadDeCartas +=1;
		this.cartas.put(posicion, carta);
	}
	
	public void eliminarCarta(Carta carta) {
		int posicion = devolverClave(this.cartas,carta);
		this.cartas.put(posicion, null);
		this.tablero.destruirCarta(carta);
	}
	
	protected void settearDiccionarioInicial(int n,HashMap<Integer,Carta> diccionario) {
		for (int i=0; i<n; i++) {
			diccionario.put(i, null);
		}
	}
	
	public int devolverClave(HashMap<Integer,Carta> diccionario, Carta carta) {
		for(int x: diccionario.keySet()) {
			if(diccionario.get(x).equals(carta)){
				return x;
			}
		}
		return -1;
	}
	
	public Collection<Carta> obtenerCartas(){
		return this.cartas.values();
	}
}