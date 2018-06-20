	package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;

public class EfectoAgujeroNegro extends Efecto {
	
	public void activarSobreJugadorAtacante(Jugador jugador) {
		jugador.destruirMonstruos();
	};

	public void activarSobreJugadorAtacado(Jugador jugador) {
		jugador.destruirMonstruos();
	}
}
