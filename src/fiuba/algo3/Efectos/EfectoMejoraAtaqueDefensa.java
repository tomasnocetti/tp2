package fiuba.algo3.Efectos;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoMejoraAtaqueDefensa extends Efecto {

	private int mejoraAtaqueAtacante;
	private int mejoraDefensaAtacante;
	private int mejoraAtaqueAtacado;
	private int mejoraDefensaAtacado;
	
	public EfectoMejoraAtaqueDefensa(int mejoraAtaqueAtacante, int mejoraDefensaAtacante, int mejoraAtaqueAtacado, int mejoraDefensaAtacado) {
		this.mejoraAtaqueAtacado = mejoraAtaqueAtacado;
		this.mejoraDefensaAtacado = mejoraDefensaAtacado;
		this.mejoraDefensaAtacante = mejoraDefensaAtacante;
		this.mejoraAtaqueAtacante = mejoraAtaqueAtacante;
	}
	
	@Override
	public void activarSobreJugadorAtacante(Jugador jugador) {
		Collection<Carta> monstruos = jugador.obtenerMonstruos();
		Iterator<Carta> i = monstruos.iterator();
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			monstruo.configurarPuntosAtaque(monstruo.obtenerPuntosAtaque() + this.mejoraAtaqueAtacante);
			monstruo.configurarPuntosDefensa(monstruo.obtenerPuntosDefensa() + this.mejoraDefensaAtacante);
		}
	}

	@Override
	public void activarSobreJugadorAtacado(Jugador jugador) {
		Collection<Carta> monstruos = jugador.obtenerMonstruos();
		Iterator<Carta> i = monstruos.iterator();
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			monstruo.configurarPuntosAtaque(monstruo.obtenerPuntosAtaque() + this.mejoraAtaqueAtacado);
			monstruo.configurarPuntosDefensa(monstruo.obtenerPuntosDefensa() + this.mejoraDefensaAtacado);
		}
	}

	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		// TODO Auto-generated method stub
		
	}
}
