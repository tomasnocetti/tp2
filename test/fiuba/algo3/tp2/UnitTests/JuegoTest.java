package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.JuegoObserver;
import fiuba.algo3.tp2.Excepciones.JuegoNoHaSidoInicializado;
import org.junit.Test;

public class JuegoTest {
	
	@Test
	public void testCrearJuegoYTerminarJuegoConNotificacion() {
		Juego juego = Juego.ObtenerJuego();
		JuegoObserver juegoObserver = new JuegoObserver(juego);
		juego.addObserver(juegoObserver);
		
		juego.verificarFinDeJuego();
		
	}
}
