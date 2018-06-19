package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class JugadorTest {

	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test04monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaqueYLoDestruye(){
		
		
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSeDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta1.estaDestruida());
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElPrimerMonstruoSeDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta1.estaDestruida()); // este metodo no esta bien
	}
	
	@Test
	public void test08monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElSegundoSeTestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta2.estaDestruida());
	}
	
	
	
	@Test
	public void test11monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensaNoDestruyeAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertFalse(carta2.estaDestruida());
		
	}
	
	@Test
	public void test13monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensaYLoDestruye(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertTrue(carta2.estaDestruida());
	}
	
	@Test
	public void test05monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSuJugadorPierdePuntosDeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(7200,atacante.obtenerPuntosDeVida());
	}
	
	
	@Test
	public void test09monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueAtacanteNoPierdeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,atacante.obtenerPuntosDeVida());
	}
	
	
	@Test
	public void test10monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueAtacadoNoPierdeVida(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnAccionDeAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}
	
	@Test
	public void test12monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensaNoQuitaPuntosDeVidaAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
		
	}

	
	@Test
	public void test14monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensaYNoQuitaPuntosDeVidaAlDefensor(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnAccionDeDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2);
		assertEquals(8000,defensor.obtenerPuntosDeVida());
	}
	
	@Test
	public void test15SacrificioDeUnMonstruoSacrificaElMonstruo() {
		Jugador jugador = new Jugador();
		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruoSacrificado, 0);
		
		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruo6Estrellas, 0);
		
		assertTrue(monstruoSacrificado.estaDestruida());
		
	}
	
	@Test
	public void test16SacrificioDeUnMonstruoColocaElNuevoMonstruoEnElCampo() {
		Jugador jugador = new Jugador();
		CartaMonstruo monstruoSacrificado = new CartaMonstruo(4,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruoSacrificado, 0);
		
		CartaMonstruo monstruo6Estrellas = new CartaMonstruo(6,1000,1200,jugador);
		jugador.colocarBocaArriba(monstruo6Estrellas, 0);
		
		assertTrue( monstruo6Estrellas.estaEnElCampo());
		
	}


}
