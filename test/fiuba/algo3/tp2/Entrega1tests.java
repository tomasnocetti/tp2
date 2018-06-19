package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Cartas.AgujeroNegro;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;
//import fiuba.algo3.tp2.Cartas.EfectoVacio;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMagicasOTrampas;

public class Entrega1tests {

	@Before 
	public void initialize() {
		
	}
	
	@Test
	public void test01colocarCartaMonstruoAccionAtaque() {
		Jugador jugador = new Jugador();
		CartaFactory cartaFactory = new CartaFactory(jugador);
		CartaMonstruo carta = cartaFactory.crearCartaMonstruoGenerica(1000, 1000);		
		
	}

	@Test(expected = CartaEnAccionDefensaException.class)
	public void test02colocarCartaMonstruoAccionDefensa() {
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		atacante.colocarEnAccionDeDefensa(carta);
		carta.atacar(carta2);
	}

	@Test
	public void test03colocarCartaMagicaEnCampoBocaAbajo() {
		Jugador jugador = new Jugador();
		CartaFactory cartaFactory = new CartaFactory(jugador);
		CartaMagica carta = cartaFactory.crearCartaMagicaGenerica();
		jugador.colocarBocaAbajo(carta);
		jugador.colocarCartaEnZona(carta,  0);
		
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
		assertTrue(jugador.obtenerCartasMagicasYTrampas().contains(carta)); 
	}
	
	@Test
	public void test04colocarCartaTrampaEnCampoBocaAbajo() {

		Jugador jugador = new Jugador();
		CartaFactory cartaFactory = new CartaFactory(jugador);
		CartaTrampa carta = cartaFactory.crearCartaTrampaGenerica();
		jugador.colocarBocaAbajo(carta);
		jugador.colocarCartaEnZona(carta,  0);
		
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
		assertTrue(jugador.obtenerCartasMagicasYTrampas().contains(carta)); 
	}


	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test05monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1800, 100);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 100);
		carta.atacar(carta2);
		assertEquals(7200, atacado.obtenerPuntosDeVida());
		carta2.atacar(carta);
		
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 100);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1800, 100);
		carta.atacar(carta2);
		assertEquals(7200,atacante.obtenerPuntosDeVida());
		// La carta fue destruida.
		carta.atacar(carta2);
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 2000);
		carta.atacar(carta2);

		assertEquals(8000,atacante.obtenerPuntosDeVida());
		assertEquals(8000,atacado.obtenerPuntosDeVida());
	}

	@Test
	public void test08monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 2000);
		carta2.colocarEnAccionDeDefensa();
		carta.atacar(carta2);

		assertEquals(8000,atacado.obtenerPuntosDeVida());
		
	}

	@Test
	public void test09monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensa(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 500);
		
		carta2.colocarEnAccionDeDefensa();
		carta.atacar(carta2);

		assertEquals(8000,atacado .obtenerPuntosDeVida());
	}
	
	@Test
	public void test10agujeroNegro(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		
		CartaMagica agujeroNegro = CartaFactory.crearCartaAgujeroNegro(atacante);
		atacante.colocarCartaEnZona(agujeroNegro, 0);
		agujeroNegro.colocarBocaArriba(atacado);
		
		boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruos();
		boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruos();
		
		assertTrue(monstruosAtacanteDestruidos && monstruosAtacadoDestruidos);
	}
	
	
	
//	@Test
//	public void test11SacrificioDeUnMonstruo() {
//		Jugador jugador = new Jugador();
//		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruoSacrificado, 0);
//		
//		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruo6Estrellas, 0);
//		
//		assertTrue( monstruo6Estrellas.estaEnElCampo() && monstruoSacrificado.estaDestruida());
//		
//	}
	
//	@Test
//	public void test12SacrificioDeDosMonstruos() {
//		Jugador jugador = new Jugador();
//		CartaMonstruo monstruoSacrificado1 = new CartaMonstruo(4,1000,1200,jugador);
//		CartaMonstruo monstruoSacrificado2 = new CartaMonstruo(4,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruoSacrificado1, 0);
//		jugador.colocarBocaArriba(monstruoSacrificado2, 1);
//		
//		CartaMonstruo monstruo7Estrellas = new CartaMonstruo(7,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruo7Estrellas, 0);
//		
//		assertEquals( monstruo7Estrellas.estaEnElCampo() && monstruoSacrificado1.estaDestruida() && monstruoSacrificado2.estaDestruida(), true);
//		
//	}
	
}




