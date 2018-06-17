package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Estados.PosicionArriba;

public class CartaMagica extends CartaTrampaOMagica{
	
	public CartaMagica() {
		super();
	}

	public void colocarBocaArriba() {
		this.posicion = new PosicionArriba();
		this.posicion.activarEfecto(this.efecto);
	}
	
}
