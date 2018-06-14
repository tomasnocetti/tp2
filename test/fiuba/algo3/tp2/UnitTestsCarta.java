package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestsCarta {

	@Test
	public void test10agujeroNegroDetruyeMonstruosAtacante(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarMonstruo(monstruoAtacante, 0);
		atacado.colocarMonstruo(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoDespuesDelAtaque = atacado.darPuntosDeVida();
		
		boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruosEnElCampo();
		//boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruosEnElCampo();
		//boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
		//boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
		
		assertTrue(monstruosAtacanteDestruidos);
	}
	
	@Test
	public void test11agujeroNegroDestruyeMonstruosAtacado(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarMonstruo(monstruoAtacante, 0);
		atacado.colocarMonstruo(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoDespuesDelAtaque = atacado.darPuntosDeVida();
		
		//boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruosEnElCampo();
		boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruosEnElCampo();
		//boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
		//boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
		
		assertTrue(monstruosAtacadoDestruidos);
	}
	
	@Test
	public void test12agujeroNegroAtacanteNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarMonstruo(monstruoAtacante, 0);
		atacado.colocarMonstruo(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoDespuesDelAtaque = atacado.darPuntosDeVida();
		
		//boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruosEnElCampo();
		//boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruosEnElCampo();
		boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
		//boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
		
		assertTrue(atacanteNoRecibioDano);
	}
	
	@Test
	public void test13agujeroNegroAtacadoNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador atacado = new Jugador();
		int pvAtacanteAntesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoAntesDelAtaque = atacado.darPuntosDeVida();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo(4, 1000, 1200, atacante);
		CartaMonstruo monstruoAtacado = new CartaMonstruo(4, 1000, 1200, atacado);
		
		atacante.colocarMonstruo(monstruoAtacante, 0);
		atacado.colocarMonstruo(monstruoAtacado, 0);
		
		CartaMagica agujeroNegro = new AgujeroNegro(atacante, atacado);
		
		atacante.colocarBocaArriba(agujeroNegro);
		
		int pvAtacanteDespuesDelAtaque = atacante.darPuntosDeVida();
		int pvAtacadoDespuesDelAtaque = atacado.darPuntosDeVida();
		
		//boolean monstruosAtacanteDestruidos = atacante.noTieneMonstruosEnElCampo();
		//boolean monstruosAtacadoDestruidos = atacado.noTieneMonstruosEnElCampo();
		//boolean atacanteNoRecibioDano = (pvAtacanteAntesDelAtaque - pvAtacanteDespuesDelAtaque == 0);
		boolean atacadoNoRecibioDano = (pvAtacadoDespuesDelAtaque - pvAtacadoDespuesDelAtaque == 0);
		
		assertTrue(atacadoNoRecibioDano);
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
