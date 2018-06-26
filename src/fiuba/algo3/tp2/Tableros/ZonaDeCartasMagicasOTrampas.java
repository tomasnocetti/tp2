package fiuba.algo3.tp2.Tableros;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import fiuba.algo3.tp2.Excepciones.ZonaNoTieneTrampa;

public class ZonaDeCartasMagicasOTrampas extends Zona{
	
	private boolean tieneTrampa;

	public ZonaDeCartasMagicasOTrampas(Jugador jugador) {
		super(jugador);
		this.limite = 5;
		this.tieneTrampa = false;
	}

	public void agregarCarta(CartaTrampaOMagica carta, int posicion) {
		super.agregarCarta(carta, posicion);
		if (carta instanceof CartaTrampa) {
			this.tieneTrampa = true;
			}
	}
	
	public boolean tieneTrampa() {
		return this.tieneTrampa;
	}

	public CartaTrampa obtenerProximaCartaTrampa() {
		Collection<Carta> cartas = this.obtenerCartas();
		Iterator<Carta> c = cartas.iterator();
		while (c.hasNext()) {
			Carta carta = c.next();
			if (carta instanceof CartaTrampa) {
				return (CartaTrampa) carta;
			}
		}
		throw new ZonaNoTieneTrampa();
	}

	public Hashtable<Integer, Carta> obtenerCartasMagicasOTrampas() {
		// TODO Auto-generated method stub
		return this.cartas;
	}


}
