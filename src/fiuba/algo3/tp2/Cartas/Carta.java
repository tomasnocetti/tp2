package fiuba.algo3.tp2.Cartas ;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;

public abstract class Carta {
	
	protected Efecto efecto;
	protected Posicionable posicion;
	protected Jugador jugador;
	
	public abstract boolean estaEnElCampo();
	public abstract void enviarAlCementerio();
	
	public Carta(Jugador jugador, Efecto efecto) {
		this.efecto = efecto;
		this.jugador = jugador;
	}
	
	public Posicionable obtenerEstado() {
		return this.posicion ;
	}

}
