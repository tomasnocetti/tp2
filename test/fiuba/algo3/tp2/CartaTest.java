package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {

	@Test
	public void test01colocarCartaMonstruoPosicionAtaque() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador); //estrellas,ataque,def
		carta.colocarEnPosicionDeAtaque();
		assertTrue(carta.estaEnPosicionDeAtaque());
		//deberiamos tener un atriubuto para definir su posicion? si
	}

	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador);
		carta.colocarEnPosicionDeDefensa();
		assertTrue(carta.estaEnPosicionDeDefensa()); 
	}

	@Test
	public void test03colocarCartaMagicaEnCampoBocaAbajo() {
		CartaMagica carta = new CartaMagica();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta, 0);
		carta.colocarBocaAbajo();
		assertTrue(carta.estaBocaAbajo());
		assertEquals(campo.cantidadDeCartas(), 1); 
	}
	
//	@Test
//	public void test04colocarCartaTrampaEnCampoBocaAbajo() {
//		CartaTrampa carta = new CartaTrampa();
//		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
//		campo.agregarCarta(carta);
//		carta.colocarBocaAbajo();
//		assertEquals(carta.estaBocaAbajo() == true);
//		assertEquals(campo.cantidadDeCartas() == 1);
//	}


	@Test
	public void test05monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,defensor);
		carta1.colocarEnPosicionDeAtaque();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,atacante);
		carta2.colocarEnPosicionDeAtaque();
		carta2.atacarMonstruo(carta1);
		assertEquals(7200,defensor.darPuntosDeVida());
		assertTrue(carta1.estaDestruida());
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnPosicionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionDeAtaque();
		carta1.atacarMonstruo(carta2);
		assertEquals(7200,atacante.darPuntosDeVida());
		assertTrue(carta1.estaDestruida());
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnPosicionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionDeAtaque();
		carta1.atacarMonstruo(carta2);
		assertTrue(carta1.estaDestruida());
		assertTrue(carta2.estaDestruida());
		assertEquals(8000,atacante.darPuntosDeVida());
		assertEquals(8000,defensor.darPuntosDeVida());
	}

	@Test
	public void test08monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnPosicionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionDeAtaque();
		carta1.atacarMonstruo(carta2);
		assertFalse(carta2.estaDestruida());
		assertEquals(8000,defensor.darPuntosDeVida());
		
	}

	@Test
	public void test09monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnPosicionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnPosicionDeAtaque();
		carta1.atacarMonstruo(carta2);
		assertTrue(carta2.estaDestruida());
		assertEquals(8000,defensor.darPuntosDeVida());
	}
	
//	@Test
//	public void test10agujeroNegro(){ 
//		Jugador atacante = new Jugador();
//		Jugador atacado = new Jugador();
//		int pvAtacanteAntesDelAtaque = atacante.darPuntosDeVida();
//		int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
//		
//		atacante.colocarMonstruos();
//		atacado.colocarMonstruos();
//		
//		CartaMagica agujeroNegro = new AgujeroNegro();
//		
//		atacante.colocarBocaArriba(agujeroNegro);
//		
//		int pvAtacanteDespuesDelAtaque = atacante.darPuntosDeVida();
//		int pvAtacadoDespuesDelAtaque = atacado.darPuntosDeVida();
//		
//		boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruosEnElCampo();
//		boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruosEnElCampo();
//		boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
//		boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
//		
//		assertEquals(monstruosAtacanteDestruidos && monstruosAtacadoDestruidos && atacanteNoRecibioDano && atacadoNoRecibioDano, true);
//	}
//	
//	// me parecen malos estos tests unitarios porque comproban varias cosas, serian mas bien tests de integracion y habria que dividirlos en varios tests unitarios
//	
//	
//	@Test
//	public void test11SacrificioDeUnMonstruo() {
//		Jugador jugador = new Jugador();
//		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruoSacrificado);
//		
//		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruo6Estrellas);
//		
//		assertEquals( monstruo6Estrellas.estaEnElCampo() && monstruoSacrificado.estaMuerta(), true);
//		
//	}
	
//	@Test
//	public void test12SacrificioDeDosMonstruos() {
//		Jugador jugador = new Jugador();
//		CartaMonstruo monstruoSacrificado1 = new CartaMonstruo(4,1000,1200,jugador);
//		CartaMonstruo monstruoSacrificado2 = new CartaMonstruo(4,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruoSacrificado1);
//		jugador.colocarBocaArriba(monstruoSacrificado2);
//		
//		CartaMonstruo monstruo7Estrellas = new CartaMonstruo(7,1000,1200,jugador);
//		jugador.colocarBocaArriba(monstruo6Estrellas);
//		
//		assertEquals( monstruo7Estrellas.estaEnElCampo() && monstruoSacrificado1.estaMuerta() && monstruoSacrificado2.estaMuerta(), true);
//		
//	}
	
}




