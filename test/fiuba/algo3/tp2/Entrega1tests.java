package fiuba.algo3.tp2;

import static org.junit.Assert.*;

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

	@Test
	public void test01colocarCartaMonstruoAccionAtaque() {
		CartaMonstruo carta = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);		
		carta.colocarEnAccionDeAtaque();
		
	}

	@Test(expected = CartaEnAccionDefensaException.class)
	public void test02colocarCartaMonstruoAccionDefensa() {
		CartaMonstruo carta = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		carta.colocarEnAccionDeDefensa();
		carta.atacar(carta2);
	}

	@Test
	public void test03colocarCartaMagicaEnCampoBocaAbajo() {
		CartaMagica carta = new CartaMagica();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta, 0);
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
		assertTrue(campo.obtenerCartas().contains(carta)); 
	}
	
	@Test
	public void test04colocarCartaTrampaEnCampoBocaAbajo() {
		CartaTrampa carta = new CartaTrampa();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta, 0);
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
		assertTrue(campo.obtenerCartas().contains(carta)); 
	}


	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test05monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4, 1000, 100, defensor);
		carta1.colocarEnAccionDeAtaque();
		CartaMonstruo carta2 = new CartaMonstruo(4, 1800, 100, atacante);
		carta2.colocarEnAccionDeAtaque();
		carta2.atacar(carta1);
		assertEquals(7200, defensor.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(7200,atacante.obtenerPuntosDeVida());
//		assertTrue(carta1.estaDestruida());
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		//assertTrue(carta1.estaDestruida());
		//assertTrue(carta2.estaDestruida());
		assertEquals(8000,atacante.obtenerPuntosDeVida());
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}

	@Test
	public void test08monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		//assertFalse(carta2.estaDestruida());
		assertEquals(8000,defensor.obtenerPuntosDeVida());
		
	}

	@Test
	public void test09monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		//assertTrue(carta2.estaDestruida());
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}
	
	@Test
	public void test10agujeroNegro(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.obtenerPuntosDeVida();
		//int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarMonstruo(monstruoAtacante, 0);
		atacado.colocarMonstruo(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.obtenerPuntosDeVida();
		int pvAtacadoDespuesDelAtaque = atacado.obtenerPuntosDeVida();
		
		boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruos();
		boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruos();
		boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
		boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
		
		assertTrue(monstruosAtacanteDestruidos && monstruosAtacadoDestruidos && atacanteNoRecibioDano && atacadoNoRecibioDano);
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




