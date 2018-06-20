package fiuba.algo3.Efectos;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

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
			Posicionable posicion =  monstruo.obtenerPosicion();
			if(!PosicionArriba.class.isInstance(posicion)) continue;
			
			if(cartaConMenorAtaqueBocaArriba == null || cartaConMenorAtaqueBocaArriba.obtenerPuntosAtaque() > monstruo.obtenerPuntosAtaque()) {
				cartaConMenorAtaqueBocaArriba = monstruo;
			}
		}
		
		if(cartaConMenorAtaqueBocaArriba == null) return;
		
		cartaConMenorAtaqueBocaArriba.enviarAlCementerio();		
	}

	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		// TODO Auto-generated method stub
		
	}

}
