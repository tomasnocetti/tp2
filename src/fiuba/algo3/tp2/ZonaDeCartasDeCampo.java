package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Hashtable;

public class ZonaDeCartasDeCampo extends Zona{
	
	
	public ZonaDeCartasDeCampo() {
		this.limite = 1;
		this.cantidadDeCartas = 0;
		this.cartas = new Hashtable<Integer,Carta>();
		this.settearDiccionarioInicial(limite);
	}
	
	public void agregarCarta(CartaCampo carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}
	
	
}
