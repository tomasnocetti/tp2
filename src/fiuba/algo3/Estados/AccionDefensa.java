package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;

public class AccionDefensa implements Accionable {

	private int puntosDeDefensa;
	
	public AccionDefensa (int puntosDefensa) {
		this.puntosDeDefensa = puntosDefensa;
	}
	
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		throw new CartaEnAccionDefensaException();
	}

	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, CartaMonstruo cartaActual) {
		int diferenciaAtaque = this.puntosDeDefensa - puntosDeAtaqueRecibidos;
		if(diferenciaAtaque > 0) return;
		cartaActual.enviarAlCementerio();
	}

}
