package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;

public class EfectoJinzo7 extends Efecto {


	@Override
	public void activarSobreJugadorAtacante(Jugador jugador) {
		return;
	}

	@Override
	public void activarSobreJugadorAtacado(Jugador jugador) {
		jugador.quitarPuntosDeVida(500);

	}

}
