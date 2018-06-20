package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.Carta;

public class Juego {
	
	private ArrayList<Jugador> jugadores;
	private static Juego instancia = null;
	private Integer iJugadorActual = null; 
	private NotificarFinalDeJuego finDeJuego;
	
	public Juego() {
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(new Jugador());
		this.jugadores.add(new Jugador());
		this.finDeJuego = new NotificarFinalDeJuego();
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
	
	private void verificarFinDeJuego() {
		//Se verifican todas las condiciones para el final del jeugo si alguna da true se notifica al jugador (y creo que deberiamos resetear el juego)
		
	}
	
	
}

