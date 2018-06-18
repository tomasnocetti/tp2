package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class AccionAtaque implements Accionable {
	
	private int puntosDeAtaque;

	public AccionAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}
	public void atacarMonstruo(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		// to be implemented
		cartaAtacada.recibirAtaque(this.puntosDeAtaque, cartaAtacante);
	}
	
	public boolean estaEnPosicionAtaque() {
		return true;
	}

	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = this.puntosDeAtaque - puntosDeAtaqueRecibidos;
		if(diferenciaAtaque < 0) {
			// DESTRUIR
			cartaActual.quitarVidaAJugador(-1 * diferenciaAtaque);
		} else if ( diferenciaAtaque > 0) {
			cartaAtacante.recibirCoontraataque(diferenciaAtaque);
		} else {
			// DESTRUIR
			cartaAtacante.recibirCoontraataque(0);
		}
	}

}
