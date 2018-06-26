package fiuba.algo3.Estados;

import java.io.Serializable;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.MonstruoBocaAbajoException;

public class MonstruoPosicionAbajo extends PosicionAbajo implements MonstruoPosicionable, Serializable{
	
	public MonstruoPosicionAbajo() {
	}
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		throw new MonstruoBocaAbajoException();
	}
	
	public void defender(CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		cartaActual.colocarBocaArriba();
		posicion.defender(cartaAtacante,cartaActual);
	}

}
