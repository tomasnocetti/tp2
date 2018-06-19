	package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;

public class EfectoAgujeroNegro extends Efecto {
	
	public void activarSobreJugadorOfensivo(Jugador jugador) {
		jugador.destruirMonstruos();
	};

	public void activarSobreJugadorDefensivo(Jugador jugador) {
		jugador.destruirMonstruos();
	};
}
