package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;

public abstract class CartaTrampaOMagica extends Carta{

	public CartaTrampaOMagica(Jugador jugador, Efecto efecto) {
		super(jugador, efecto);
		this.posicion = new PosicionAbajo();
	}

	public boolean estaEnElCampo() {
		return this.jugador.estaEnElCampo(this);
	}

	public void enviarAlCementerio( ) {
		this.jugador.enviarAlCementerio(this);
	}
	
	public void colocarBocaArriba(Jugador oponente) {
		this.posicion = new PosicionArriba();
		this.efecto.activarSobreJugadorOfensivo(this.jugador);
		this.efecto.activarSobreJugadorDefensivo(oponente);
	}
}
