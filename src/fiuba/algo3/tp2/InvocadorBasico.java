package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorBasico extends Invocador {
	
	private static int cartasNecesarias = 0;
	@Override
	public boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return (cartasSacrificadas.size() == 0);
	}
	@Override
	public int numeroInvocaciones() {
		// TODO Auto-generated method stub
		return cartasNecesarias;
	}

}
