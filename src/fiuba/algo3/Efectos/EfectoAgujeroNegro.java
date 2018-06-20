	package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoAgujeroNegro extends Efecto {
	
	public void activarSobreJugadorAtacante(Jugador jugador) {
		jugador.destruirMonstruos();
	};

	public void activarSobreJugadorAtacado(Jugador jugador) {
		jugador.destruirMonstruos();
	}
}
