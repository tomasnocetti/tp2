package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class MonstruoPosicionArriba extends PosicionArriba implements MonstruoPosicionable {
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		Accionable accionAtacante = cartaAtacante.obtenerAccion(); 
		accionAtacante.atacar(cartaAtacante, cartaAtacada);
	}
	
	public void defender(CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual) {
		posicion.defender(cartaAtacante,cartaActual);
	}

}
