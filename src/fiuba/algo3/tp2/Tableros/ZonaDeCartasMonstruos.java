package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Hashtable;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class ZonaDeCartasMonstruos extends Zona{

	public ZonaDeCartasMonstruos() {
		this.limite = 5;
		this.cartas = new Hashtable<Integer,Carta>();
	}
	
	public void agregarCarta(CartaMonstruo carta, int posicion) {
		super.agregarCarta(carta, posicion);
	}

	public boolean estaVacia() {
		return this.cartas.isEmpty();
	}

	public ArrayList<CartaMonstruo> sacrificarMonstruos(int numeroDeSacrificios) {
		ArrayList<CartaMonstruo> monstruosSacrificados = new ArrayList<CartaMonstruo>();
		for (int i = 0 ; i < numeroDeSacrificios ; i++) {
			Carta monstruo = this.cartas.get(i);
			monstruosSacrificados.add((CartaMonstruo) monstruo); //que feo
			this.eliminarCarta(monstruo);
		}
		return monstruosSacrificados;
		
	}
	
}
