package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;

public class EfectoOllaDeLaCodicia extends Efecto {
	
	public void activarSobreJugadorAtacante(Jugador jugador) {
		jugador.agarrarCartasDelMazo(2);
	}
	
	public void activarSobreJugadorAtacado(Jugador jugador) {
		return;
	}
}
