package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorDoble extends Invocador{

	@Override
	public boolean invocacionValida(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return (cartasSacrificadas.size() == 2);

	}

}
