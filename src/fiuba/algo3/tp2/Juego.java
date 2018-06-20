package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.tp2.Cartas.Carta;

public class Juego extends Observable{
	
	private ArrayList<Jugador> jugadores;
	private static Juego instancia = null;
	private Integer iJugadorActual = null; 
	private String estado = "Jugando";
	
	public Juego() {
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(new Jugador());
		this.jugadores.add(new Jugador());
	}
	
	public static Juego ObtenerJuego() {
		if (instancia == null) {
			instancia = new Juego();
		}
		return instancia;
	}
	
	public static void setInstancia(Juego j){
		if (instancia == null)
			instancia = j;
	}
	
	public void cambiarTurno() {
		this.iJugadorActual = this.obtenerIJugadorOponente();
	}
	
	public Jugador jugadorActual() {
		return this.jugadores.get(this.iJugadorActual);
	}
	
	public Jugador jugadorOponente() {
		return this.jugadores.get(this.obtenerIJugadorOponente());
	}
	
	private int obtenerIJugadorOponente() {
		return 1 - this.iJugadorActual;
	}
	
	public void verificarFinDeJuego() {
       this.estado = "Terminado";
	   setChanged();
       notifyObservers();
	}
	
	public String estadoDelJuego() {
		return this.estado;
	}
}

