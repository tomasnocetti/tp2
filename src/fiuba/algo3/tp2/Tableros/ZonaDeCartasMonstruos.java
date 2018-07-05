package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class ZonaDeCartasMonstruos extends Zona{

	private static final long serialVersionUID = -6769818391527323243L;

	public ZonaDeCartasMonstruos(Jugador jugador) {
		super(jugador);
		this.limite = 5;
	}	

	public void agregarCarta(CartaMonstruo carta, int posicion, ArrayList<CartaMonstruo> cartasSacrificio) {
		
		Iterator<CartaMonstruo> i = cartasSacrificio.iterator();
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			this.eliminarCarta(monstruo);
			this.jugador.enviarAlCementerio(monstruo);
			
		}
		super.agregarCarta(carta, posicion);	
	}

	public boolean estaVacia() {
		return this.cartas.isEmpty();
	}
	
	public Hashtable<Integer,Carta> obtenerCartasMonstruos() {
		return this.cartas;
	}
}
