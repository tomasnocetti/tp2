package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;

public abstract class CartaTrampaOMagica extends Carta{

	public CartaTrampaOMagica(String nombre, Jugador jugador, Efecto efecto) {
		super(nombre, jugador, efecto);
		this.posicion = new PosicionArriba();
	}
	
	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
	
	public void colocarBocaArriba(Jugador oponente) {
		this.posicion = new PosicionArriba();
		this.activar(oponente);
	}
	
	public void colocarBocaAbajo() {
		this.posicion = new PosicionAbajo();
	}
	
	
	public void activar(Jugador oponente) {
		this.efecto.activarSobreJugadorAtacante(this.jugador);
		this.efecto.activarSobreJugadorAtacado(oponente);
	}
	
	public boolean activar(Jugador jugadorAtacante, CartaMonstruo cartaAtacada, CartaMonstruo cartaAtacante) {
		return this.efecto.activarAntesDeDefensa(jugadorAtacante, cartaAtacada, cartaAtacante);
	}

}
