package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Estados.PosicionAbajo;

public abstract class CartaTrampaOMagica extends Carta{
	

	public CartaTrampaOMagica() {
		this.posicion = new PosicionAbajo();
	}

	public void activarEfecto() {
		this.posicion.activarEfecto(this.efecto);
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method sub
		this.posicion = new PosicionAbajo();
	}

	public boolean estaBocaAbajo() {
		return this.posicion.estaBocaAbajo();
	}

//	public void colocarBocaArriba() {
//		// TODO Auto-generated method stub
//		this.estado = new BocaArriba();
//	}

	public boolean estaBocaArriba() {
		return this.posicion.estaBocaArriba();
	}

	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}

	public void destruirCarta() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaDestruida() {
		// TODO Auto-generated method stub
		return false;
	}

}
