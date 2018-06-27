package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorSimple extends Invocador{
	private static int cartasNecesarias = 1;
	@Override
	public boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) {
		return (cartasSacrificadas.size() == cartasNecesarias);
	}
	@Override
	public int numeroInvocaciones() {
		// TODO Auto-generated method stub
		return cartasNecesarias;
	}

}
