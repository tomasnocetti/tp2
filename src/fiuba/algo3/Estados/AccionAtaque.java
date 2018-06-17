package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo.CartaMonstruo;

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
		// TODO Auto-generated method stub
		int diferenciaAtaque = this.puntosDeAtaque - puntosDeAtaqueRecibidos;
		if(diferenciaAtaque < 0) {
			cartaActual.destruirCarta();
			System.out.println(diferenciaAtaque);
			cartaActual.quitarVidaAJugador(-1 * diferenciaAtaque);
		} else if ( diferenciaAtaque > 0) {
			cartaAtacante.recibirCoontraataque(diferenciaAtaque);
		} else {
			cartaActual.destruirCarta();
			cartaAtacante.recibirCoontraataque(0);
		}
	}

}
