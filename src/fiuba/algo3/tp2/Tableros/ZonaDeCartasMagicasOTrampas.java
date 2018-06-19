package fiuba.algo3.tp2.Tableros;

import java.util.Hashtable;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;

public class ZonaDeCartasMagicasOTrampas extends Zona{

	public ZonaDeCartasMagicasOTrampas(Jugador jugador) {
		super(jugador);
		this.limite = 5;
	}

	public void agregarCarta(CartaTrampaOMagica carta, int posicion) {
		super.agregarCarta(carta, posicion);
	}


}
