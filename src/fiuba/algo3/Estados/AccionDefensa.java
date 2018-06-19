package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;

public class AccionDefensa implements Accionable {
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		throw new CartaEnAccionDefensaException();
	}

	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = cartaActual.obtenerPuntosDefensa() - cartaAtacante.obtenerPuntosAtaque();
		
		if (diferenciaAtaque > 0) return;
		cartaActual.enviarAlCementerio();
	
	}

}
