package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;

public abstract class Efecto {
	public abstract void activarSobreJugadorAtacante(Jugador jugador);
	public abstract void activarSobreJugadorAtacado(Jugador jugador);
}
