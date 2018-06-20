package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaTrampa;

public class CartaTrampaTest {

	@Test
	public void test01colocarCartaTrampaBocaAbajo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaTrampa carta = factory.crearCartaTrampaGenerica();
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerPosicion().getClass(), PosicionAbajo.class);
	}
	
	@Test
	public void test02colocarCartaTrampaEnCampo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaTrampa carta = factory.crearCartaTrampaGenerica();
		
		jugador.colocarCartaEnZona(carta, 0);
		assertTrue(jugador.obtenerCartasMagicasYTrampas().contains(carta)); 
	}

}
