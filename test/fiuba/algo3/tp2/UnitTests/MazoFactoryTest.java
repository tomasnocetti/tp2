package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaFactory;

public class MazoFactoryTest {

	@Test
	public void test01obtenerCartasDeArchivo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		ArrayList<Carta> cartas = factory.obtenerCartasAleatorias(25);
		assertEquals(cartas.size(), 25);
	}
	
}
