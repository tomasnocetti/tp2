package fiuba.algo3.Estados;

import java.io.Serializable;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class AccionAtaque implements Accionable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		cartaAtacada.defender(cartaAtacante);
	}
	
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = this.calcularDanio(cartaAtacante,  cartaActual);
		if(diferenciaAtaque < 0) {
			cartaActual.quitarVidaAJugador(-1 * diferenciaAtaque);
			cartaActual.enviarAlCementerio();
			return;
		} else if(diferenciaAtaque == 0) {
			cartaActual.enviarAlCementerio();
			cartaAtacante.enviarAlCementerio();
		} else {
			cartaActual.atacar(cartaAtacante);
		}
	}

	public int calcularDanio(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = cartaActual.obtenerPuntosAtaque() - cartaAtacante.obtenerPuntosAtaque();
		return diferenciaAtaque;
	}

	@Override
	public void atacarJugador(CartaMonstruo cartaAtacante, Jugador otro) {
		otro.quitarPuntosDeVida(cartaAtacante.obtenerPuntosAtaque());
	}
}
