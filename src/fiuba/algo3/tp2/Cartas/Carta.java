package fiuba.algo3.tp2.Cartas ;

import java.util.Observable;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.*;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;

public abstract class Carta extends Observable {
	
	protected Efecto efecto;
	protected Posicionable posicion;
	protected Jugador jugador;
	protected String nombre;
	
	public abstract void enviarAlCementerio();
	
	public Carta(Jugador jugador, Efecto efecto) {
		this.efecto = efecto;
		this.jugador = jugador;
	}
	
	public Posicionable obtenerPosicion() {
		return this.posicion ;
	}
	
	public Efecto obtenerEfecto() {
		return this.efecto;
	}
	
	public Jugador obtenerJugador() {
		return this.jugador;
	}
	
	public void colocarBocaAbajo() {
		this.posicion = new PosicionAbajo();
		
	}

	public void colocarBocaArriba(Jugador jugadorOponente) {
		this.efecto.activarSobreJugadorAtacado(jugador);
		this.efecto.activarSobreJugadorAtacante(jugadorOponente);
		this.posicion = new PosicionArriba();
	}
	
	public String nombre() {
		return this.nombre;
	}

}
