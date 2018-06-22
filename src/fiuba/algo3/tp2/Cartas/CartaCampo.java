package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;

public class CartaCampo extends Carta{
	
	public CartaCampo(Jugador jugador, Efecto efecto) {
		super(jugador, efecto);
		this.posicion = new PosicionArriba();
	}

	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
	public void activar(Jugador jugadorOponente) {
		this.efecto.activarSobreJugadorAtacante(this.jugador);
		this.efecto.activarSobreJugadorAtacado(jugadorOponente);
	}
	
	
}
