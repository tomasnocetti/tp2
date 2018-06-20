package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class Entrega2tests {
	
	@Test
	public void test01colocarCartaMagicaWastelandEnCampoYVerificarEfecto() {
		Jugador atacante = new Jugador();
		CartaFactory cartaFactoryAtacante = new CartaFactory(atacante);
		Jugador atacado = new Jugador();
		
		CartaFactory cartaFactoryAtacado = new CartaFactory(atacado);
		
		CartaMonstruo cA1 = cartaFactoryAtacante.crearCartaMonstruoGenerica(300, 500);
		atacante.colocarCartaEnZona(cA1, 0, new ArrayList<CartaMonstruo>());
		
		CartaMonstruo c1 = cartaFactoryAtacado.crearCartaMonstruoGenerica(500, 250);
		atacado.colocarCartaEnZona(c1, 0, new ArrayList<CartaMonstruo>());
		c1.colocarEnAccionDeDefensa();
		
		int cartaAtacantePuntosDeAtaque = cA1.obtenerPuntosAtaque();
		int cartaAtacadaPuntosDeDefensa = c1.obtenerPuntosDefensa();
		
		CartaCampo wasteland = cartaFactoryAtacante.crearCartaWasteland();
		atacante.colocarCartaEnZona(wasteland, atacado);
		
		cA1.atacar(c1);
		assertTrue(cartaAtacantePuntosDeAtaque + 200 == cA1.obtenerPuntosAtaque());
		assertTrue(cartaAtacadaPuntosDeDefensa + 300 == c1.obtenerPuntosDefensa());
		assertFalse(atacado.obtenerCartasEnCementerio().contains(c1));	
	}
	
	@Test
	public void test02colocarCartaMagicaSogenEnCampoYVerificarEfecto() {
		Jugador atacante = new Jugador();
		CartaFactory cartaFactoryAtacante = new CartaFactory(atacante);
		Jugador atacado = new Jugador();
		
		CartaFactory cartaFactoryAtacado = new CartaFactory(atacado);
		
		CartaMonstruo cA1 = cartaFactoryAtacante.crearCartaMonstruoGenerica(300, 100);
		atacante.colocarCartaEnZona(cA1, 0, new ArrayList<CartaMonstruo>());
		cA1.colocarEnAccionDeDefensa();
		
		CartaMonstruo c1 = cartaFactoryAtacado.crearCartaMonstruoGenerica(300, 250);
		atacado.colocarCartaEnZona(c1, 0, new ArrayList<CartaMonstruo>());
		
		
		int cartaAtacantePuntosDeDefensa = cA1.obtenerPuntosDefensa();
		int cartaAtacadaPuntosDeAtaque = c1.obtenerPuntosAtaque();
		
		CartaCampo sogen = cartaFactoryAtacante.crearCartaSogen();
		atacante.colocarCartaEnZona(sogen, atacado);
		
		c1.atacar(cA1);
		assertTrue(cartaAtacantePuntosDeDefensa + 500 == cA1.obtenerPuntosDefensa());
		assertTrue(cartaAtacadaPuntosDeAtaque + 200 == c1.obtenerPuntosAtaque());
		assertFalse(atacado.obtenerCartasEnCementerio().contains(c1));
	}

	@Test
	public void test03activarCartaMagicaOllaDeLaCodiciaYVerificarEfecto() {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		
		CartaMagica ollaCodicia = factory.crearCartaOllaDeLaCodicia();
		jugador.colocarCartaEnZona(ollaCodicia, 0);
		ollaCodicia.colocarBocaArriba(oponente);
		
		assertEquals(jugador.obtenerCartasEnMano().size(), 2);
	}
	
	@Test
	public void test04activarCartaMagicaFisuraYVerificarEfecto() {
		Jugador atacante = new Jugador();
		CartaFactory cartaFactoryAtacante = new CartaFactory(atacante);
		Jugador atacado = new Jugador();
		CartaFactory cartaFactoryAtacado = new CartaFactory(atacado);
		CartaMagica fisura = cartaFactoryAtacante.crearCartaFisura();
		
		CartaMonstruo c1 = cartaFactoryAtacado.crearCartaMonstruoGenerica(300, 100);
		CartaMonstruo c2 = cartaFactoryAtacado.crearCartaMonstruoGenerica(500, 100);
		atacado.colocarCartaEnZona(c1, 0, new ArrayList<CartaMonstruo>());
		atacado.colocarCartaEnZona(c2, 1, new ArrayList<CartaMonstruo>());
		
		fisura.activar(atacado);
		
		assertTrue(atacado.obtenerCartasEnCementerio().contains(c1));
		assertFalse(atacado.obtenerCartasEnCementerio().contains(c2));
	}

	@Test
	public void test05colocarJinzo7EnElCampoVerificarAtaqueALosPuntosDeVidaDirecto() {
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		
		CartaMonstruo monstruoAtacado = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo jinzo7 = factoryAtacante.crearCartaJinzo7(atacado);
		
		atacado.colocarCartaEnZona(monstruoAtacado, 0, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(jinzo7, 0, new ArrayList<CartaMonstruo>());
		
		jinzo7.activar(atacado);
		
	}

	@Test
	public void test06invocarAlDragonDefinitivoDeOjosAzulesSacrificando3DragonesBlancos() {
		Jugador atacante = new Jugador();
		CartaFactory factory = new CartaFactory(atacante);

		CartaMonstruo dragon1 = factory.crearCartaDragonBlancoDeOjosAzules();
		CartaMonstruo dragon2 = factory.crearCartaDragonBlancoDeOjosAzules();
		CartaMonstruo dragon3 = factory.crearCartaDragonBlancoDeOjosAzules();
		
		CartaMonstruo sacrificado1 = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo sacrificado2 = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo sacrificado3 = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo sacrificado4 = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo sacrificado5 = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo sacrificado6 = factory.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(sacrificado1, 0, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(sacrificado2, 1, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(sacrificado3, 2, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(sacrificado4, 3, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(sacrificado5, 4, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(sacrificado6, 5, new ArrayList<CartaMonstruo>());
		
		ArrayList<CartaMonstruo> sacrificio1 = new ArrayList<CartaMonstruo>();
		sacrificio1.add(sacrificado1);
		sacrificio1.add(sacrificado2);
		atacante.colocarCartaEnZona(dragon1, 0, sacrificio1);
		
		ArrayList<CartaMonstruo> sacrificio2 = new ArrayList<CartaMonstruo>();
		sacrificio2.add(sacrificado3);
		sacrificio2.add(sacrificado4);
		atacante.colocarCartaEnZona(dragon2, 0, sacrificio2);
		
		ArrayList<CartaMonstruo> sacrificio3 = new ArrayList<CartaMonstruo>();
		sacrificio3.add(sacrificado5);
		sacrificio3.add(sacrificado6);
		atacante.colocarCartaEnZona(dragon3, 0, sacrificio3);
		
		CartaMonstruo dragonDefinitivo = factory.crearCartaDragonDefinitivo();
		
		ArrayList<CartaMonstruo> sacrificioDragones = new ArrayList<CartaMonstruo>();
		sacrificioDragones.add(dragon1);
		sacrificioDragones.add(dragon2);
		sacrificioDragones.add(dragon3);
		atacante.colocarCartaEnZona(dragonDefinitivo, 0, sacrificioDragones);
		
		assertTrue(atacante.obtenerMonstruos().contains(dragonDefinitivo));
		assertEquals(atacante.obtenerMonstruos().size(), 1);

	}
	
	@Test
	public void test07colocarInsectoComeHombresEnDefensaBocaAbajoYProbarEfectoEnBatalla() {
		
	}

	@Test
	public void test08colocarCartaTrampaCilindroMagicoDelLadoDelCampoYAtacarConElMonstruoEnemigoVerificandoEfecto() {
		
	}

	@Test
	public void test09colocarCartaTrampaReinforcementsYProbarEfectoEnBatalla() {
		
	}

	@Test
	public void test10extraerTodasLasCartasDelMazoYVerificarPartidaTerminada() {
		
	}

	@Test
	public void test11colocarPartesDeExodiaEnLaManoYVerificarPartidaTerminada() {
		
	}

}
