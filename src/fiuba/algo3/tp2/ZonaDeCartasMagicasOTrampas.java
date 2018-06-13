package fiuba.algo3.tp2;

import java.util.HashMap;

public class ZonaDeCartasMagicasOTrampas extends Zona{

	
	public ZonaDeCartasMagicasOTrampas() {
		this.limite = 5;
		this.cantidadDeCartas = 0;
		this.cartas = new HashMap<Integer,Carta>();
		this.settearDiccionarioInicial(limite,cartas);
	}

	public void agregarCarta(CartaTrampaOMagica carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}


}
