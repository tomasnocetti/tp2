package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;

import org.junit.Test;

public class JuegoTest {
	
	
	@Test
	public void test01CrearJuegoAsignarGanadorYVerficarQueEsteTerminado() {
		Juego juego = Juego.ObtenerJuego();
		Jugador ganador = juego.jugadorActual();
		juego.asignarGanador(ganador);
		assertTrue(juego.estadoDelJuegoTerminado());
	}
	
	@Test
	public void test02CrearJuegoAsignarGanadorYVerficarQueEsteTerminado() {
		Juego juego = Juego.ObtenerJuego();
		Jugador perdedor = juego.jugadorActual();
		juego.asignarPerdedor(perdedor);
		assertTrue(juego.estadoDelJuegoTerminado());
	}
	
	@Test
	public void test03CrearJuegoAsignarGanadorYVerficarQueEsteGane() {
		Juego juego = Juego.ObtenerJuego();
		Jugador ganador = juego.jugadorActual();
		juego.asignarGanador(ganador);
		assertTrue(ganador == juego.obtenerGanador());
	}
	
	@Test
	public void test04CrearJuegoAsignarPerdedorYVerficarQueEsteNoGano() {
		Juego juego = Juego.ObtenerJuego();
		Jugador perdedor = juego.jugadorActual();
		juego.asignarPerdedor(perdedor);
		assertTrue(perdedor != juego.obtenerGanador());
	}
	
	
//	@Test
//	public void testCrearJuegoYTerminarJuegoConNotificacion() {
//		Juego juego = Juego.ObtenerJuego();
//		JuegoObserver juegoObserver = new JuegoObserver(juego);
//		juego.addObserver(juegoObserver);
//		
//		juego.verificarFinDeJuego();
//		
//	}
//}
}