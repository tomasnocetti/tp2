package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.Estados.AccionAtaque;
import fiuba.algo3.Estados.Accionable;
import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;
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
		
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionAtaque.class);		
	}

	@Test(expected = CartaEnAccionDefensaException.class)
	public void test02colocarCartaMonstruoAccionDefensa() {
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		atacante.colocarCartaEnZona(carta,  0, new ArrayList<CartaMonstruo>());
		carta.colocarEnAccionDeDefensa();
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


	@Test
	public void test05monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		CartaMonstruo carta1 = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1800, 1000);
		atacante.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(carta1, 0, new ArrayList<CartaMonstruo>());
		
		carta2.atacar(carta1); // carta1 se destruye
		assertEquals(7200, defensor.obtenerPuntosDeVida());
		assertFalse(defensor.obtenerMonstruos().contains(carta1));
		assertTrue(defensor.obtenerCartasEnCementerio().contains(carta1));
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		CartaMonstruo carta1 = factoryDefensor.crearCartaMonstruoGenerica(1800, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		atacante.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(carta1, 0, new ArrayList<CartaMonstruo>());
		
		carta2.atacar(carta1); //carta2 se destruye
		assertEquals(7200,atacante.obtenerPuntosDeVida());
		assertFalse(atacante.obtenerMonstruos().contains(carta2));
		assertTrue(atacante.obtenerCartasEnCementerio().contains(carta2));
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		CartaMonstruo carta1 = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		atacante.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(carta1, 0, new ArrayList<CartaMonstruo>());
		
		carta1.atacar(carta2); // ambas cartas se destruyen
		assertEquals(8000,atacante.obtenerPuntosDeVida());
		assertEquals(8000,defensor.obtenerPuntosDeVida());
		
		assertFalse(atacante.obtenerMonstruos().contains(carta2));
		assertTrue(atacante.obtenerCartasEnCementerio().contains(carta2));
		
		assertFalse(defensor.obtenerMonstruos().contains(carta1));
		assertTrue(defensor.obtenerCartasEnCementerio().contains(carta1));
	}

	@Test
	public void test08monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaMonstruo carta = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacado.crearCartaMonstruoGenerica(1000, 2000);
		atacante.colocarCartaEnZona(carta, 0, new ArrayList<CartaMonstruo>());
		atacado.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());		
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
		atacante.colocarCartaEnZona(carta, 0, new ArrayList<CartaMonstruo>());
		atacado.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());
		
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




