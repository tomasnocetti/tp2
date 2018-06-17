package fiuba.algo3.tp2.Tableros;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

//import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Excepciones.PosicionDeLaZonaOcupadaException;
import fiuba.algo3.tp2.Excepciones.ZonaAlcanzoCantidadMaximaDeCartasError;

public abstract class Zona {
	
	protected Hashtable<Integer,Carta> cartas;
	protected int limite;
	
	public Zona() {
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
	protected void agregarCarta(Carta carta, int posicion) {
		if (cartas.size() +1 >= this.limite || posicion >= limite) {
			throw new ZonaAlcanzoCantidadMaximaDeCartasError();
		}
		if (cartas.get(posicion) != null) {
			throw new PosicionDeLaZonaOcupadaException();
		}
		this.cartas.put(posicion, carta);
	}
	
	public void eliminarCarta(Carta carta) {
		int posicion = devolverClave(this.cartas,carta);
		System.out.println("Carta eliminada en posicion :");
		System.out.println(posicion);
		//this.cartas.put(posicion, null) -> no se puede insertar un null value
		this.cartas.remove(posicion);
		//this.tablero.destruirCarta(carta);
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
	
	protected void settearDiccionarioInicial(int n) {
		for (int i=0; i<n; i++) {
			this.cartas.put(i, null);
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