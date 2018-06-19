package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Excepciones.PosicionDeLaZonaOcupadaException;
import fiuba.algo3.tp2.Excepciones.PosicionDeZonaFueraDeRangoExcepcion;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;

public class ZonaDeCartasDeCampoTest {

	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		CartaCampo carta = new CartaCampo(jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
	
	@Test(expected = PosicionDeLaZonaOcupadaException.class) 
	public void test02agregoCartaEnPosicionOcupadaDaExcepcion() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		
		CartaCampo carta = new CartaCampo(jugador, efecto);
		CartaCampo carta2 = new CartaCampo(jugador, efecto);
		
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		
		zona.agregarCarta(carta, 1);
		zona.agregarCarta(carta2, 1);
	}
	
	@Test(expected = PosicionDeZonaFueraDeRangoExcepcion.class) 
	public void test03agregoCartaEnPosicionDosDaExceptionFueraDeRango() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		CartaCampo carta = new CartaCampo(jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, 2);
	}
	
	@Test
	public void test04agregarCartaYEliminarCarta() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		
		CartaCampo carta = new CartaCampo(jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, 1);
		zona.eliminarCarta(carta);
		assertFalse(zona.obtenerCartas().contains(carta));
	}
	
	@Test
	public void test05agregarCartaEliminarCartaYAgregarNuevamente() {
		Jugador jugador = new Jugador();
		EfectoVacio efecto = new EfectoVacio();
		
		CartaCampo carta = new CartaCampo(jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, 1);
		zona.eliminarCarta(carta);
		zona.agregarCarta(carta, 1);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
}
