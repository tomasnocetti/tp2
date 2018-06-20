package fiuba.algo3.Efectos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.Estados.Posicionable;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class EfectoExodia extends EfectoMonstruo{
	private String cartasNecesarias[] = {
			"Cabeza Exodia", 
			"Brazo Izquierdo Exodia", 
			"Brazo Derecho Exodia", 
			"Pierna Izquierda Exodia",
			"Pierna Derecha Exodia"};  
	
	@Override
	public void activarAlAgregarAZonaMano(ZonaMano zona, Carta carta) {
		Jugador jugador = carta.obtenerJugador();
		Collection<Carta> cartasEnMano = jugador.obtenerCartasEnMano();
		
		List<String> list = Arrays.asList(this.cartasNecesarias);

		Iterator<String> i = list.iterator();
		
		while (i.hasNext()) {
			final String nombre = i.next();
			Optional<Carta> cartaBuscada = cartasEnMano.stream().filter(new Predicate<Carta>() {
				public boolean test(Carta p) {
					return nombre.equals(p.nombre());
				}
			}).findFirst();
			if(!cartaBuscada.isPresent()) return;
		}
		
		// ACA GANAR EL JUEGO ! 
		
	}

	@Override
	public boolean activarAntesDeAtaque(CartaMonstruo atacante, CartaMonstruo atacada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean activarAntesDeDefensa(CartaMonstruo atacante, CartaMonstruo atacada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void activarSobreJugadorAtacante(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activarSobreJugadorAtacado(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
}
