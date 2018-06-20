package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class InvocadorTest {

	@Test
	public void test01CreacionInvocadorBasico() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Nombre", jugador, efecto, 1, 1000, 1000);
		
		assertTrue(carta.invocacionValida(new ArrayList<CartaMonstruo>()));
	}

}
