package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.*;

public class ZonaDeCartasMagicasOTrampasTest {

	@Test
	public void test01TieneTrampa() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaTrampa trampa = factory.crearCartaTrampaGenerica();
		jugador.colocarCartaEnZona(trampa, 0);
		
		assertTrue(jugador.tieneTrampaEnElCampo());
	}
	
	@Test
	public void test02DevolverLaProximaCartaTrampa() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaTrampa trampa = factory.crearCartaTrampaGenerica();
		CartaTrampa trampa2 = factory.crearCartaTrampaGenerica();
		CartaMagica magica1 = factory.crearCartaMagicaGenerica();
		CartaMagica magica2 = factory.crearCartaMagicaGenerica();
		
		jugador.colocarCartaEnZona(magica1, 0);
		jugador.colocarCartaEnZona(trampa, 1);
		jugador.colocarCartaEnZona(magica2, 2);
		jugador.colocarCartaEnZona(trampa2, 3);
		jugador.enviarAlCementerio(trampa);
		
		assertEquals(jugador.obtenerProximaCartaTrampa(), trampa2);
	}

}
