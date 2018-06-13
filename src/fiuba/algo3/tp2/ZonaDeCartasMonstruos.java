package fiuba.algo3.tp2;

public class ZonaDeCartasMonstruos extends Zona{

	public ZonaDeCartasMonstruos() {
		this.limite = 5;
		this.cantidadDeCartas = 0;
		this.settearArregleInicial(limite,cartas);
	}
	
	public void agregarCarta(CartaMonstruo carta, int posicion) {
		this._agregarCarta(carta, posicion);
	}
	
}
