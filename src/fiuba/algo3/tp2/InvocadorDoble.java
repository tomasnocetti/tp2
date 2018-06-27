package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorDoble extends Invocador{
	
	private static int cartasNecesarias = 2;
	@Override
	public boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return (cartasSacrificadas.size() == 2);

	}
	@Override
	public int numeroInvocaciones() {
		// TODO Auto-generated method stub
		return cartasNecesarias;
	}

}
