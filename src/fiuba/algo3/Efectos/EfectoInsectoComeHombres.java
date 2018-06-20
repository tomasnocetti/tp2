package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;	
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoInsectoComeHombres extends EfectoMonstruo {
	public void activarSobreJugadorAtacante(Jugador jugador) {

	}

	public void activarSobreJugadorAtacado(Jugador jugador) {		
	}

	@Override
	public boolean activarAntesDeAtaque(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		return false;
	}

	@Override
	public boolean activarAntesDeDefensa(CartaMonstruo atacante, CartaMonstruo atacada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		// TODO Auto-generated method stub
		
	};
}
