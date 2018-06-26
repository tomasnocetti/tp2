package fiuba.algo3.Efectos;

import java.io.Serializable;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class Efecto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {return;}
	public void activarSobreJugadorAtacante(Jugador jugador) {return;}
	public void activarSobreJugadorAtacado(Jugador jugador) {return;}
	public boolean activarAntesDeDefensa(Jugador jugador, CartaMonstruo cartaAtacada, CartaMonstruo cartaAtacante) {return true;}
}
