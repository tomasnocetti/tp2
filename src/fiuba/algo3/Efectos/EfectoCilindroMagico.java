package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class EfectoCilindroMagico extends Efecto {

	public void activar(Jugador jugadorAtacado, CartaMonstruo atacada, CartaMonstruo atacante) {
		int puntosDeDanio = atacada.obtenerAccion().calcularDanio(atacante, atacada);
		if (puntosDeDanio < 0) {
			//el atacante tiene mas puntos que el atacado
			jugadorAtacado.quitarPuntosDeVida(puntosDeDanio);
		}
	}

	@Override
	public void activarSobreJugadorAtacante(Jugador jugador) {
		return;
	}

	@Override
	public void activarSobreJugadorAtacado(Jugador jugador) {
		return;
	}
	
}
