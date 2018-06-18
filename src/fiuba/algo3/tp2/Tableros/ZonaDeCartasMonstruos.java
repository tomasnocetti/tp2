package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Hashtable;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CantidadDeSacrificiosIncorrectoException;

public class ZonaDeCartasMonstruos extends Zona{

	public ZonaDeCartasMonstruos() {
		this.limite = 5;
		this.cartas = new Hashtable<Integer,Carta>();
	}
	

	public void agregarCartaMonstruo(CartaMonstruo carta, int posicion, ArrayList<CartaMonstruo> cartasSacrificio) {
		if (cartasSacrificio.size() != carta.numeroDeSacrificios()) {
			throw new CantidadDeSacrificiosIncorrectoException();
		}
		for(int i = 0; i<cartasSacrificio.size(); i++) {
		Carta cartaEliminar = cartasSacrificio.get(i);
		this.eliminarCarta(cartaEliminar);
		}
		super.agregarCarta(carta, posicion);	
	}

	public boolean estaVacia() {
		return this.cartas.isEmpty();
	}

	public ArrayList<CartaMonstruo> sacrificarMonstruos(int numeroDeSacrificios) {
		ArrayList<CartaMonstruo> monstruosSacrificados = new ArrayList<CartaMonstruo>();
		for (int i = 0 ; i < numeroDeSacrificios ; i++) {
			Carta monstruo = this.cartas.get(i);
			monstruosSacrificados.add((CartaMonstruo) monstruo); 
			this.eliminarCarta(monstruo);
		}
		return monstruosSacrificados;
		
	}
	
}
