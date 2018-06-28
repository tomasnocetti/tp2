package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Excepciones.FinalDeJuegoException;

import org.junit.Test;

public class JuegoTest {
	
	
	@Test
	public void test01CrearJuegoAsignarGanadorYVerficarQueEsteTerminado() {
		Juego juego = Juego.ObtenerJuego();
		Jugador ganador = juego.jugadorActual();
		juego.asignarGanador(ganador, "PRUEBA");
		assertTrue(juego.estadoDelJuegoTerminado());
	}
	
	@Test
	public void test02CrearJuegoAsignarGanadorYVerficarQueEsteTerminado() {
		Juego juego = Juego.ObtenerJuego();
		Jugador perdedor = juego.jugadorActual();
		juego.asignarPerdedor(perdedor, "PRUEBA");
		assertTrue(juego.estadoDelJuegoTerminado());
	}
	
	@Test
	public void test03CrearJuegoAsignarGanadorYVerficarQueEsteGane() {
		Juego juego = Juego.ObtenerJuego();
		Jugador ganador = juego.jugadorActual();
		juego.asignarGanador(ganador, "PRUEBA");
		assertTrue(ganador == juego.obtenerGanador());
	}
	
	@Test
	public void test04CrearJuegoAsignarPerdedorYVerficarQueEsteNoGano() {
		Juego juego = Juego.ObtenerJuego();
		Jugador perdedor = juego.jugadorActual();
		juego.asignarPerdedor(perdedor, "PRUEBA");
		assertTrue(perdedor != juego.obtenerGanador());
	}
	
	@Test (expected = FinalDeJuegoException.class)
	public void test05CambioDeTurnoMientrasJuegoTerminadoLevantaExcepcion() {
		Juego juego = Juego.ObtenerJuego();
		Jugador perdedor = juego.jugadorActual();
		juego.asignarPerdedor(perdedor, "PRUEBA");
		juego.cambiarTurno();
	}

}