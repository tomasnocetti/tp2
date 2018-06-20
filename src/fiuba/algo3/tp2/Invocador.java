package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.NumeroDeEstrellasInvalido;

public abstract class Invocador {
	
	private static InvocadorBasico invocadorBasico = new InvocadorBasico();
	private static InvocadorSimple invocadorSimple = new InvocadorSimple();
	private static InvocadorDoble invocadorDoble = new InvocadorDoble();
	private static InvocadorDragonDefinitivo invocadorDragonDefinitivo = new InvocadorDragonDefinitivo();

	public static Invocador obtenerInvocador(CartaMonstruo carta) {
		
		if (carta.nombre() == "Dragon Definitivo De Ojos Azules") {
			return invocadorDragonDefinitivo;
		}
		
		int estrellas = carta.estrellas();
		
		if (0 < estrellas && estrellas < 5) {
			return invocadorBasico;
		}
		if (4 < estrellas && estrellas < 7) {
			return invocadorSimple;
		}
		if (6 < estrellas && estrellas < 11) {
			return invocadorDoble;
		}
		else {
			throw new NumeroDeEstrellasInvalido();
		}
			
	}

	public abstract boolean invocar(ArrayList<CartaMonstruo> cartasSacrificadas) ;

}
