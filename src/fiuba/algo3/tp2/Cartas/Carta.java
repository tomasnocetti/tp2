package fiuba.algo3.tp2.Cartas ;

import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;

public abstract class Carta {
	
	protected TieneUnEfecto efecto;
	protected Posicionable posicion;
	protected Jugador jugador;
	
	public abstract void activarEfecto();
	public abstract void colocarBocaAbajo();
	public abstract void colocarBocaArriba();
	public abstract boolean estaEnElCampo();
	public abstract void enviarAlCementerio();

	public Posicionable obtenerEstado() {
		return this.posicion ;
	}

}
