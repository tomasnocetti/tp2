package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class EfectoReinforcements extends Efecto {
	private int mejoraAtaqueAtacante = 500;
	
	public boolean activarAntesDeDefensa(Jugador jugador, CartaMonstruo cartaAtacada, CartaMonstruo cartaAtacante) {
		cartaAtacada.configurarPuntosAtaque(cartaAtacada.obtenerPuntosAtaque() + this.mejoraAtaqueAtacante);
		return true;
	}
}
