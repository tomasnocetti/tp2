package fiuba.algo3.tp2;

import java.util.ArrayList;

public class ZonaDeCartasDeCampo extends Zona{
	
	
	public ZonaDeCartasDeCampo() {
		this.limite = 1;
		this.cantidadDeCartas = 0;
		this.cartas = new ArrayList<Carta>();
		this.settearArregleInicial(limite,cartas);
	}
	
	public void agregarCarta(CartaCampo carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}
	
	
}
