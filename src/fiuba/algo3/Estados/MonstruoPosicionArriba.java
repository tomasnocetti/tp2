package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.TieneUnEfecto;

public class MonstruoPosicionArriba implements MonstruoPosicionable {
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		Accionable accionAtacante = cartaAtacante.obtenerAccion(); 
		accionAtacante.atacar(cartaAtacante, cartaAtacada);
	}
	
	public void defender(int puntosDeAtaqueRecibidos,CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		posicion.defender(puntosDeAtaqueRecibidos, cartaAtacante,cartaActual);
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
