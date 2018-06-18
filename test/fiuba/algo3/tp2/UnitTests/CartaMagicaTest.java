package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Estados.PosicionAbajo;
//import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.AgujeroNegro;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMagicasOTrampas;

public class CartaMagicaTest {

	
	@Test
	public void test01colocarCartaMagicaBocaAbajo() {
		CartaMagica carta = new CartaMagica();
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
	}
	
	@Test
	public void test02colocarCartaMagicaEnCampo() {
		CartaMagica carta = new CartaMagica();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta, 0);
		assertTrue(campo.obtenerCartas().contains(carta)); 
	}
	
	
	@Test
	public void test03agujeroNegroDetruyeMonstruosAtacante(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0);
		atacado.colocarCartaEnZona(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruos();
		
		assertTrue(monstruosAtacanteDestruidos);
	}
	
	@Test
	public void test04agujeroNegroDestruyeMonstruosAtacado(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0);
		atacado.colocarCartaEnZona(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruos();
		
		assertTrue(monstruosAtacadoDestruidos);
	}
	
	@Test
	public void test05agujeroNegroAtacanteNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.obtenerPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0);
		atacado.colocarCartaEnZona(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.obtenerPuntosDeVida();
		
		assertEquals(pvAtacanteAntesDelAtaque, pvAtacanteDespuesDelAtaque);
	}
	
	@Test
	public void test06agujeroNegroAtacadoNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0);
		atacado.colocarCartaEnZona(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		int pvAtacadoAntesDelAtaque = atacado.obtenerPuntosDeVida();
		atacante.colocarBocaArriba(agujeroNegro);
		int pvAtacadoDespuesDelAtaque = atacado.obtenerPuntosDeVida();
		
		assertEquals(pvAtacadoAntesDelAtaque, pvAtacadoDespuesDelAtaque);
	}
}
