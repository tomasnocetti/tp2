package fiuba.algo3.tp2;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public abstract class Zona {
	
	protected Hashtable<Integer,Carta> cartas;
	protected int limite;
	protected int cantidadDeCartas;
	//protected Tablero tablero;
	
	public Zona() {
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
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
		//this.cartas.put(posicion, null) -> no se puede insertar un null value
		this.cartas.remove(posicion);
		//this.tablero.destruirCarta(carta);
		this.cantidadDeCartas += (-1);
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
			System.out.println("HOLA");
			this.cartas.put(i, null);
			System.out.println("HOLA");
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