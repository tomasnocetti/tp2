package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class EfectoCilindroMagico extends Efecto {

	public void activar(Jugador jugadorAtacante, CartaMonstruo atacada, CartaMonstruo atacante) {
		int puntosDeDanio = atacada.obtenerAccion().calcularDanio(atacante, atacada);
		if (puntosDeDanio < 0) {
			//el atacante tiene mas puntos que el atacado
			jugadorAtacante.quitarPuntosDeVida(- puntosDeDanio);
		}
	}
}
