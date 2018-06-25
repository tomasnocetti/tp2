package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import fiuba.algo3.tp2.Excepciones.FinalDeJuegoException;

public class Juego extends Observable{
	
	private ArrayList<Jugador> jugadores;
	private static Juego instancia = null;
	private Integer iJugadorActual = null; 
	private Integer iFaseActual = 0; 
	private boolean juegoTerminado  = false;
	private Jugador ganador = null;
	
	public Juego() {
		this.resetearJuego();
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
		if (this.estadoDelJuegoTerminado()) {
			throw new FinalDeJuegoException();
		}
		this.iJugadorActual = this.obtenerIJugadorOponente();
	}
	
	public Jugador jugadorActual() {
		return this.jugadores.get(this.iJugadorActual);
	}
	
	public Jugador jugadorOponente() {
		return this.jugadores.get(this.obtenerIJugadorOponente());
	}
	
	public void continuarASiguienteFase() {
		 if(iFaseActual == 4) {
			 this.cambiarTurno();
			 iFaseActual = 0;
		 }
		 
		 iFaseActual ++;
         this.setChanged();
         this.notifyObservers(); 
	}
	
	private int obtenerIJugadorOponente() {
		return 1 - this.iJugadorActual;
	}
	
	private void terminarJuego(Jugador jugador) { 
		this.ganador = jugador;
        this.juegoTerminado = true;
	    setChanged();
        notifyObservers();
	}
	
	public void asignarGanador(Jugador jugador) {
		this.terminarJuego(jugador);
	}
	
	public void asignarPerdedor(Jugador jugador) {
		if (this.jugadores.get(0) == jugador) {
			this.terminarJuego(this.jugadores.get(1));
			return;
		}
		this.terminarJuego(this.jugadores.get(0));
	}
	
	public boolean estadoDelJuegoTerminado() {
		return this.juegoTerminado;
	}
	
	public Jugador obtenerGanador() {
		return this.ganador;
	}
	
	public void resetearJuego() {
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(new Jugador());
		this.jugadores.add(new Jugador());
		Random random = new Random();
		this.iJugadorActual = random.nextInt(2);
	}
	
	public Jugador obtenerJugador(int num){
		return this.jugadores.get(num);
	}
	
}

