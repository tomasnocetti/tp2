package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Excepciones.*;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class ZonaDeCartasMonstruosTest {
	
	@Test
	public void test01agregoUnaCartaALaZonaYVerificoQueSeAgrego() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo carta = factory.crearCartaMonstruoGenerica(1000, 1000);
		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
		
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos(jugador);
		zona.agregarCarta(carta, 1,cartasSacrificio);
		
		assertTrue(zona.obtenerCartas().contains(carta));
	}

	@Test
	public void test02agregoCincoCartaALaZonaYVerificoQueSeAgregaron() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
		CartaMonstruo carta1 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta2 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta3 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta4 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta5 = factory.crearCartaMonstruoGenerica(1000, 2000);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos(jugador);
		zona.agregarCarta(carta1, 1,cartasSacrificio);
		zona.agregarCarta(carta2, 2,cartasSacrificio);
		zona.agregarCarta(carta3, 3,cartasSacrificio);
		zona.agregarCarta(carta4, 4,cartasSacrificio);
		zona.agregarCarta(carta5, 5,cartasSacrificio);
		assertTrue(zona.obtenerCartas().contains(carta1) &&
				zona.obtenerCartas().contains(carta2) &&
				zona.obtenerCartas().contains(carta3) &&
				zona.obtenerCartas().contains(carta4) &&
				zona.obtenerCartas().contains(carta5));
	}
	
	@Test(expected = PosicionDeLaZonaOcupadaException.class) 
	public void test03agregoCartaEnPosicionOcupadaDaExcepcion() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
		
		CartaMonstruo carta1 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta2 = factory.crearCartaMonstruoGenerica(1000, 2000);
		
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos(jugador);
		zona.agregarCarta(carta1, 1,cartasSacrificio);
		
		zona.agregarCarta(carta2, 1,cartasSacrificio);
	}
	
	@Test(expected = PosicionDeZonaFueraDeRangoExcepcion.class) 
	public void test04agregoCartaEnPosicionSeisDaExceptionFueraDeRango() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
		
		CartaMonstruo carta1 = factory.crearCartaMonstruoGenerica(1000, 2000);
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos(jugador);
		zona.agregarCarta(carta1, 6,cartasSacrificio);
	}
	
	@Test
	public void test05agregaCartasConSacrificio() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
		
		CartaMonstruo carta1 = factory.crearCartaMonstruoGenerica(1000, 2000);
		CartaMonstruo carta2 = factory.crearCartaMonstruoGenerica1Sacrificio(1000, 2000);
		
		ZonaDeCartasMonstruos zona = new ZonaDeCartasMonstruos(jugador);
		zona.agregarCarta(carta1, 1,cartasSacrificio);
		cartasSacrificio.add(carta1);
		zona.agregarCarta(carta2, 1,cartasSacrificio);
		assertTrue(zona.obtenerCartas().contains(carta2));
	}
	
	
}
