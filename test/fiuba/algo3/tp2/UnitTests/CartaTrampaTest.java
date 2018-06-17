package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMagicasOTrampas;

public class CartaTrampaTest {

	@Test
	public void test01colocarCartaTrampaBocaAbajo() {
		CartaTrampa carta = new CartaTrampa();
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
	}
	
	@Test
	public void test02colocarCartaTrampaEnCampo() {
		CartaTrampa carta = new CartaTrampa();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta, 0);
		assertTrue(campo.obtenerCartas().contains(carta)); 
	}

}
