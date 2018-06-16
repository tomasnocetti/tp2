package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.tp2.Excepciones.CartaBocaAbajoException;

public class BocaAbajo implements Volteable {
	
	public boolean estaBocaAbajo() {
		return true;
	}
	
	public boolean estaBocaArriba() {
		return false;
	}

	public void activarEfecto(TieneUnEfecto efecto) {
		// TODO Auto-generated method stub
		throw new CartaBocaAbajoException();
	}
}
