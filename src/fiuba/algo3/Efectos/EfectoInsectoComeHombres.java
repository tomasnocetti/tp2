package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;	
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoInsectoComeHombres extends EfectoMonstruo {
	
	public void activarSobreJugadorAtacante(Jugador jugador) {
		return;
	}

	public void activarSobreJugadorAtacado(Jugador jugador) {
		return;
	}

	@Override
	public boolean activarAntesDeAtaque(CartaMonstruo atacante, CartaMonstruo atacada) {	
		return false;
	}

	@Override
	public boolean activarAntesDeDefensa(CartaMonstruo atacante, CartaMonstruo atacada) {
		return false;
	}

	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		return;		
	}
	
	@Override
	public void activarAlVoltear(CartaMonstruo cartaAtacante) {
		cartaAtacante.enviarAlCementerio();
	}
	
}
