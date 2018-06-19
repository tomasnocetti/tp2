package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CantidadDeSacrificiosIncorrectoException;

public class ZonaDeCartasMonstruos extends Zona{

	public ZonaDeCartasMonstruos(Jugador jugador) {
		super(jugador);
		this.limite = 5;
	}	

	public void agregarCarta(CartaMonstruo carta, int posicion, ArrayList<CartaMonstruo> cartasSacrificio) {
		if (cartasSacrificio.size() != carta.numeroDeSacrificios()) {
			throw new CantidadDeSacrificiosIncorrectoException();
		}
		
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
	
}
