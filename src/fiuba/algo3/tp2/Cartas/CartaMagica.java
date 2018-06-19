package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;

public class CartaMagica extends CartaTrampaOMagica{
	
	public CartaMagica(Jugador jugador, Efecto efecto) {
		super(jugador, efecto);
	}

	public void activar(Jugador oponente) {
		this.efecto.activarSobreJugadorAtacante(this.jugador);
		this.efecto.activarSobreJugadorAtacado(oponente);
	}
}
