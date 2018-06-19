package fiuba.algo3.tp2.Tableros;

import java.util.Hashtable;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;

public class ZonaDeCartasDeCampo extends Zona{
	
	
	public ZonaDeCartasDeCampo() {
		this.limite = 1;
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
	public void agregarCarta(CartaCampo carta, int posicion) {
		super.agregarCarta(carta, posicion);
	}
}
