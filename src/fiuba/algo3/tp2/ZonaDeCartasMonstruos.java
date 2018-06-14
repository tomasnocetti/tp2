package fiuba.algo3.tp2;

import java.util.Hashtable;

public class ZonaDeCartasMonstruos extends Zona{

	public ZonaDeCartasMonstruos() {
		this.limite = 5;
		this.cantidadDeCartas = 0;
//		this.settearDiccionarioInicial(this.limite);
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
	public void agregarCarta(CartaMonstruo carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}

	public boolean estaVacia() {
		return this.cartas.isEmpty();
	}
	
}
