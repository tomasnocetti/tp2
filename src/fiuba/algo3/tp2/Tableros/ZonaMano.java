package fiuba.algo3.tp2.Tableros;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;

public class ZonaMano implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Carta> cartas;
	
	
	public ZonaMano(Jugador jugador) {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void agregarCarta(Carta carta) {
		this.cartas.add(carta);
		if (carta == null) { 
			return;
		}
		Efecto efecto = carta.obtenerEfecto();
		efecto.activarAlAgregarAZonaMano(this, carta);
		}
	
	public void eliminarCarta(Carta carta) {
		this.cartas.remove(carta);
	}

	public Collection<Carta> obtenerCartas() {
		return this.cartas;
	}
}
