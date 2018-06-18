package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class AccionAtaque implements Accionable {
	
	private int puntosDeAtaque;

	public AccionAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		cartaAtacada.defender(this.puntosDeAtaque, cartaAtacante);
	}
	
	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = this.puntosDeAtaque - puntosDeAtaqueRecibidos;
		if(diferenciaAtaque < 0) {
			cartaActual.quitarVidaAJugador(-1 * diferenciaAtaque);
			cartaActual.enviarAlCementerio();
			return;
		}
		if(diferenciaAtaque == 0) {
			cartaActual.enviarAlCementerio();
		}
		cartaActual.atacar(cartaAtacante);
	}
}
