package fiuba.algo3.Efectos;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoWasteland extends Efecto {

	@Override
	public void activarSobreJugadorAtacante(Jugador jugador) {
		Collection<Carta> monstruos = jugador.obtenerMonstruos();
		Iterator<Carta> i = monstruos.iterator();
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			int puntosAtaque = monstruo.obtenerPuntosAtaque() + 200;
			monstruo.configurarPuntosAtaque(puntosAtaque);
		}
	}

	@Override
	public void activarSobreJugadorAtacado(Jugador jugador) {
		Collection<Carta> monstruos = jugador.obtenerMonstruos();
		Iterator<Carta> i = monstruos.iterator();
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			int puntosDefensa = monstruo.obtenerPuntosDefensa() + 300;
			monstruo.configurarPuntosDefensa(puntosDefensa);
		}
	}

}
