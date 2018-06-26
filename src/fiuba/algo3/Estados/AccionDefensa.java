package fiuba.algo3.Estados;

import java.io.Serializable;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;

public class AccionDefensa implements Accionable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		throw new CartaEnAccionDefensaException();
	}

	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = this.calcularDanio(cartaAtacante, cartaActual);
		
		if (diferenciaAtaque > 0) return;
		cartaActual.enviarAlCementerio();
	
	}

	public int calcularDanio(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = cartaActual.obtenerPuntosDefensa() - cartaAtacante.obtenerPuntosAtaque();
		return diferenciaAtaque;
	}

}
