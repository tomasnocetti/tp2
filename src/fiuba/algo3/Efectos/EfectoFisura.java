package fiuba.algo3.Efectos;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class EfectoFisura extends Efecto {

	public void activarSobreJugadorAtacante(Jugador jugador) {
		return;
	};

	public void activarSobreJugadorAtacado(Jugador jugador) {
		
		Collection<Carta> monstruos = jugador.obtenerMonstruos();
		Iterator<Carta> i = monstruos.iterator();
		CartaMonstruo cartaConMenorAtaqueBocaArriba = null;
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			MonstruoPosicionable posicion = (MonstruoPosicionable) monstruo.obtenerPosicion();
			if(!MonstruoPosicionArriba.class.isInstance(posicion)) continue;
			
			if(cartaConMenorAtaqueBocaArriba == null || cartaConMenorAtaqueBocaArriba.obtenerPuntosAtaque() > monstruo.obtenerPuntosAtaque()) {
				cartaConMenorAtaqueBocaArriba = monstruo;
			}
		}
		
		if(cartaConMenorAtaqueBocaArriba == null) return;
		
		cartaConMenorAtaqueBocaArriba.enviarAlCementerio();		
	};
}
