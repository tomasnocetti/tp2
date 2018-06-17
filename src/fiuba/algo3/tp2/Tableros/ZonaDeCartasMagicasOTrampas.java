package fiuba.algo3.tp2.Tableros;

import java.util.Hashtable;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;

public class ZonaDeCartasMagicasOTrampas extends Zona{

	
	public ZonaDeCartasMagicasOTrampas() {
		this.limite = 5;
		this.cartas = new Hashtable<Integer,Carta>();
	}

	public void agregarCarta(CartaTrampaOMagica carta, int posicion) {
		super.agregarCarta(carta, posicion);
	}


}
