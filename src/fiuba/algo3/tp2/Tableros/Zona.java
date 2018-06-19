package fiuba.algo3.tp2.Tableros;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.tp2.Jugador;
//import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Excepciones.PosicionDeLaZonaOcupadaException;
import fiuba.algo3.tp2.Excepciones.PosicionDeZonaFueraDeRangoExcepcion;
import fiuba.algo3.tp2.Excepciones.ZonaAlcanzoCantidadMaximaDeCartasExcepcion;

public class Zona {
	
	protected Hashtable<Integer,Carta> cartas;
	protected int limite;
	protected Jugador jugador;
	
	public Zona(Jugador jugador) {
		this.cartas = new Hashtable<Integer,Carta>();
		this.jugador = jugador;
	}
	
	protected void agregarCarta(Carta carta, int posicion) {
		if (posicion > limite) {
			throw new PosicionDeZonaFueraDeRangoExcepcion();
		}
		if (cartas.get(posicion) != null) {
			throw new PosicionDeLaZonaOcupadaException();
		}
		if (cartas.size() +1 > this.limite) {
			throw new ZonaAlcanzoCantidadMaximaDeCartasExcepcion();
		}
		this.cartas.put(posicion, carta);
	}
	
	public void eliminarCarta(Carta carta) {
		int posicion = devolverClave(this.cartas,carta);
		this.cartas.remove(posicion);
	}
	
	
	public void vaciar() {
		Set<Integer> keys = this.cartas.keySet();
		Iterator<Integer> i = keys.iterator();
		
		while (i.hasNext()) {
			int posicion = i.next();
			Carta carta = this.cartas.get(posicion);
			if (carta != null) {
				this.eliminarCarta(carta);
			}
		}
	}
	
	public int devolverClave(Hashtable<Integer,Carta> diccionario, Carta carta) {
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
	
	public int cantidadDeCartas() {
		return this.cartas.size();
	}
}