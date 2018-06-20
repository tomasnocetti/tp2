package fiuba.algo3.tp2.Tableros;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;

public class ZonaDeCartasDeCampo extends Zona{
	
	
	public ZonaDeCartasDeCampo(Jugador jugador) {
		super(jugador);
		this.limite = 1;
	}
	
	private void agregarCarta(CartaCampo carta, int posicion) {
		super.agregarCarta(carta, posicion);
	}
	
	public void agregarCarta(CartaCampo carta, Jugador jugadorOponente) {
		Carta cartaEnCampo = this.cartas.get(0);
		if(cartaEnCampo != null) {
			this.eliminarCarta(cartaEnCampo);			
		}
		this.agregarCarta(carta, 0);
		carta.activar(jugadorOponente);
	}
}
