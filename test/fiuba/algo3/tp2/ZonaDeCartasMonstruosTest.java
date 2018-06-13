package fiuba.algo3.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

public class ZonaDeCartasMonstruosTest {
	
	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(3,1000,2000,jugador);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos();
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
}
