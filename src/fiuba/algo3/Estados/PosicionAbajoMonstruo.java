package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.TieneUnEfecto;
import fiuba.algo3.tp2.Excepciones.CartaBocaAbajoException;
import fiuba.algo3.tp2.Excepciones.MonstruoBocaAbajoException;

public class PosicionAbajoMonstruo implements VolteableMonstruo {
	
	public PosicionAbajoMonstruo() {
	}
	
	public void atacarMonstruo(Accionable posicion, CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		throw new MonstruoBocaAbajoException();
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		//should be implemented
		throw new MonstruoBocaAbajoException();
	}
	
	public void colocarPosicionAtaque() {
		//should be implemented and raise error
	}
	
	public boolean estaEnPosicionAtaque() {
		return false;
	}

	public boolean estaBocaAbajo() {
		return true;
	}
	
	public boolean estaBocaArriba() {
		return false;
	}

	public void activarEfecto(TieneUnEfecto efecto) {
		// TODO Auto-generated method stub
		throw new MonstruoBocaAbajoException();
	}

}
