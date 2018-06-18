package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.TieneUnEfecto;
import fiuba.algo3.tp2.Excepciones.CartaBocaAbajoException;
import fiuba.algo3.tp2.Excepciones.MonstruoBocaAbajoException;

public class MonstruoPosicionAbajo implements MonstruoPosicionable {
	
	public MonstruoPosicionAbajo() {
	}
	
	public void atacar(Accionable posicion, CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		throw new MonstruoBocaAbajoException();
	}
	
	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		//should be implemented
		throw new MonstruoBocaAbajoException();
	}
	
	public void activarEfecto(TieneUnEfecto efecto) {
		// TODO Auto-generated method stub
		throw new MonstruoBocaAbajoException();
	}

}
