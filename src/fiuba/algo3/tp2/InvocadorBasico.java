package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorBasico extends Invocador {

	@Override
	public boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return (cartasSacrificadas.size() == 0);
	}

}
