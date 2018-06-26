package fiuba.algo3.tp2.Cartas ;

import java.io.Serializable;
import java.util.Observable;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.*;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;
import javafx.scene.input.DataFormat;

public abstract class Carta extends Observable implements Serializable{
	/**
	 * 
	 */
    private static final long serialVersionUID = -1458406119115196098L;

    public static final DataFormat Binding = 
            new DataFormat("com.buddyware.treefrog.filesystem.view.FileSystemBinding");
    
    public static final DataFormat Node =
            new DataFormat("com.buddyware.treefrog.filesystem.view.FileSystemNode");
	protected Efecto efecto;
	protected Posicionable posicion;
	protected Jugador jugador;
	protected String nombre;
	
	public abstract void enviarAlCementerio();
	
	public Carta(String nombre, Jugador jugador, Efecto efecto) {
		this.efecto = efecto;
		this.jugador = jugador;
		this.nombre = nombre;
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
