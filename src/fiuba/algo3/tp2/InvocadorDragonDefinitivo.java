package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorDragonDefinitivo extends Invocador {

	private static int cartasNecesarias = 3;
	
	@Override
	public boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) {
		if (cartasSacrificadas.size() != cartasNecesarias) {
			return false;
		}
		else {
			for (int i = 0; i < 3 ; i++) {
				if (cartasSacrificadas.get(i).nombre() != "Dragon Blanco De Ojos Azules") {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int numeroInvocaciones() {
		// TODO Auto-generated method stub
		return cartasNecesarias;
	}

}
