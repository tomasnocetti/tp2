package fiuba.algo3.tp2;

import java.util.HashMap;

public class ZonaDeCartasDeCampo extends Zona{
	
	
	public ZonaDeCartasDeCampo() {
		this.limite = 1;
		this.cantidadDeCartas = 0;
		this.cartas = new HashMap<Integer,Carta>();
		this.settearDiccionarioInicial(limite,cartas);
	}
	
	public void agregarCarta(CartaCampo carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}
	
	
}
