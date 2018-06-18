package fiuba.algo3.tp2.Cartas ;

import fiuba.algo3.Estados.Posicionable;

public abstract class Carta {
	
	protected TieneUnEfecto efecto;
	protected Posicionable posicion;
	
	public abstract void activarEfecto();
	public abstract void colocarBocaAbajo();
	public abstract void colocarBocaArriba();
	public abstract boolean estaEnElCampo();

	public Posicionable obtenerEstado() {
		return this.posicion ;
	}

}
