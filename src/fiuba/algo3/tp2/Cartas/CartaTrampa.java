package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Estados.PosicionArriba;

public class CartaTrampa extends CartaTrampaOMagica{
	
	public CartaTrampa() {
		super();
	}

	public void activarEfecto() {
		this.efecto.activarEfecto();
	}

	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
	@Override
	public void colocarBocaArriba() {
		// TODO Auto-generated method stub
		this.posicion = new PosicionArriba();
	}
}
