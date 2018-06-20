package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public abstract class Efecto {
	public abstract void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta);
	public abstract void activarSobreJugadorAtacante(Jugador jugador);
	public abstract void activarSobreJugadorAtacado(Jugador jugador);
}
