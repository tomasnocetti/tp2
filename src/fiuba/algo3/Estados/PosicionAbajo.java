package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.TieneUnEfecto;
import fiuba.algo3.tp2.Excepciones.CartaBocaAbajoException;

public class PosicionAbajo implements Posicionable {
	
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
