package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Efectos.*;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class EfectoTest {
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test01activarEfectoAgujeroNegroSobreOponenteCon1Monstruo() {
		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaFactory factory2 = new CartaFactory(jugador2);
		
		CartaMonstruo carta = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factory2.crearCartaMonstruoGenerica(1000, 1000);
		
		Efecto efecto = new EfectoAgujeroNegro();
		efecto.activarSobreJugadorAtacado(jugador);
		carta.atacar(carta2);
	}
	
	@Test
	public void test02EfectoMejoraAtaqueDefensaActivarSobreAtacanteMejoraAtaque() {
		EfectoMejoraAtaqueDefensa efecto = new EfectoMejoraAtaqueDefensa(100, 200, 300, 400);
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo monstruo = factory.crearCartaMonstruoGenerica(1000, 1000);
		ArrayList<CartaMonstruo> cartasSacrificadas = new ArrayList<CartaMonstruo>();
		
		jugador.colocarCartaEnZona(monstruo, 0, cartasSacrificadas);
		
		efecto.activarSobreJugadorAtacante(jugador);
		assertEquals(monstruo.obtenerPuntosAtaque(), 1100);
		
	}
	
	@Test
	public void test03EfectoMejoraAtaqueDefensaActivarSobreAtacanteMejoraDefensa() {
		EfectoMejoraAtaqueDefensa efecto = new EfectoMejoraAtaqueDefensa(100, 200, 300, 400);
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo monstruo = factory.crearCartaMonstruoGenerica(1000, 1000);
		ArrayList<CartaMonstruo> cartasSacrificadas = new ArrayList<CartaMonstruo>();
		
		jugador.colocarCartaEnZona(monstruo, 0, cartasSacrificadas);
		
		efecto.activarSobreJugadorAtacante(jugador);
		assertEquals(monstruo.obtenerPuntosDefensa(), 1200);
		
	}
	
	@Test
	public void test04EfectoMejoraAtaqueDefensaActivarSobreAtacadoMejoraAtaque() {
		EfectoMejoraAtaqueDefensa efecto = new EfectoMejoraAtaqueDefensa(100, 200, 300, 400);
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo monstruo = factory.crearCartaMonstruoGenerica(1000, 1000);
		ArrayList<CartaMonstruo> cartasSacrificadas = new ArrayList<CartaMonstruo>();
		
		jugador.colocarCartaEnZona(monstruo, 0, cartasSacrificadas);
		
		efecto.activarSobreJugadorAtacado(jugador);
		assertEquals(monstruo.obtenerPuntosAtaque(), 1300);
		
	}
	
	@Test
	public void test05EfectoMejoraAtaqueDefensaActivarSobreAtacanteMejoraDefensa() {
		EfectoMejoraAtaqueDefensa efecto = new EfectoMejoraAtaqueDefensa(100, 200, 300, 400);
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo monstruo = factory.crearCartaMonstruoGenerica(1000, 1000);
		ArrayList<CartaMonstruo> cartasSacrificadas = new ArrayList<CartaMonstruo>();
		
		jugador.colocarCartaEnZona(monstruo, 0, cartasSacrificadas);
		
		efecto.activarSobreJugadorAtacado(jugador);
		assertEquals(monstruo.obtenerPuntosDefensa(), 1400);
		
	}

}
