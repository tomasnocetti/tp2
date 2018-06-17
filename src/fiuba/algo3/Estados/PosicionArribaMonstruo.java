package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.TieneUnEfecto;

public class PosicionArribaMonstruo implements VolteableMonstruo {
	
	public PosicionArribaMonstruo() {
		
	}
	
	public void atacarMonstruo(Accionable posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		posicion.atacarMonstruo(cartaAtacante, cartaAtacada);
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos,CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		
		posicion.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante,cartaActual);
	}

	public boolean estaBocaAbajo() {
		return false;
	}
	
	public boolean estaBocaArriba() {
		return true;
	}

	public void activarEfecto(TieneUnEfecto efecto) {
		// TODO Auto-generated method stub
		efecto.activarEfecto();
	}
	
//	public void colocarPosicionAtaque() {
//		this.posicion = new PosicionAtaque();
//	}
//	
//	public boolean estaEnPosicionAtaque() {
//		return this.posicion.estaEnPosicionAtaque() ;
//	}

}
