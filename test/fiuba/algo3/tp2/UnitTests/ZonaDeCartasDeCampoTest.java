package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;

public class ZonaDeCartasDeCampoTest {

	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		Efecto efecto = new Efecto();
		CartaCampo carta = new CartaCampo("Carta Campo Generica", jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, oponente);
		assertTrue(zona.obtenerCartas().contains(carta));
	}

	
	@Test
	public void test02agregarCartaYEliminarCarta() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		Efecto efecto = new Efecto();
		
		CartaCampo carta = new CartaCampo("Carta Campo Generica",  jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, oponente);
		zona.eliminarCarta(carta);
		assertFalse(zona.obtenerCartas().contains(carta));
	}
	
	@Test
	public void test03agregarCartaEliminarCartaYAgregarNuevamente() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		Efecto efecto = new Efecto();
		
		CartaCampo carta = new CartaCampo("Carta Campo Generica",  jugador, efecto);
		ZonaDeCartasDeCampo zona = new ZonaDeCartasDeCampo(jugador);
		zona.agregarCarta(carta, oponente);
		zona.eliminarCarta(carta);
		zona.agregarCarta(carta, oponente);
		assertTrue(zona.obtenerCartas().contains(carta));
	}
}
