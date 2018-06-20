package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoVacio extends Efecto {
	
	public void activarSobreJugadorAtacante(Jugador jugador) {
		return;
	}
	
	public void activarSobreJugadorAtacado(Jugador jugador) {
		return;
	}

	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		// TODO Auto-generated method stub
		
	}
}
