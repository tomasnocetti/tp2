package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Estados.PosicionAbajo;
//import fiuba.algo3.Estados.PosicionArriba;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class CartaMagicaTest {

	
	@Test
	public void test01colocarCartaMagicaBocaAbajo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMagica carta = factory.crearCartaMagicaGenerica();
		carta.colocarBocaAbajo();
		assertEquals(carta.obtenerPosicion().getClass(), PosicionAbajo.class);
	}
	
	@Test
	public void test02colocarCartaMagicaEnCampo() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMagica carta = factory.crearCartaMagicaGenerica();
		
		jugador.colocarCartaEnZona(carta, 0);
		assertTrue(jugador.obtenerCartasMagicasYTrampas().contains(carta)); 
	}
	
	
	@Test
	public void test03agujeroNegroDetruyeMonstruosAtacante(){ 
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		
		CartaMonstruo monstruoAtacante = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo monstruo2 = factoryAtacante.crearCartaJinzo7();
		CartaMonstruo monstruo3 = factoryAtacante.crearCartaJinzo7();
		CartaMonstruo monstruoDefensor = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0, new ArrayList<CartaMonstruo>());
		atacante.colocarCartaEnZona(monstruo2, 1, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(monstruoDefensor, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(monstruo3, 1, new ArrayList<CartaMonstruo>());
		
		CartaMagica agujeroNegro = factoryAtacante.crearCartaAgujeroNegro();
		
		agujeroNegro.colocarBocaArriba(defensor);
		
		assertTrue(atacante.noTieneMonstruos());
	}
	
	@Test
	public void test04agujeroNegroDestruyeMonstruosAtacado(){ 
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		
		CartaMonstruo monstruoAtacante = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo monstruoDefensor = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(monstruoDefensor, 0, new ArrayList<CartaMonstruo>());
		
		CartaMagica agujeroNegro = factoryAtacante.crearCartaAgujeroNegro();
		
		agujeroNegro.colocarBocaArriba(defensor);
		
		assertTrue(defensor.noTieneMonstruos());
	}
	
	@Test
	public void test05agujeroNegroAtacanteNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		
		CartaMonstruo monstruoAtacante = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo monstruoDefensor = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(monstruoDefensor, 0, new ArrayList<CartaMonstruo>());
		
		CartaMagica agujeroNegro = factoryAtacante.crearCartaAgujeroNegro();
		
		int pvAtacanteAntesDelAtaque = atacante.obtenerPuntosDeVida();
		
		agujeroNegro.colocarBocaArriba(defensor);
		
		int pvAtacanteDespuesDelAtaque = atacante.obtenerPuntosDeVida();
		
		assertEquals(pvAtacanteAntesDelAtaque, pvAtacanteDespuesDelAtaque);
	}
	
	@Test
	public void test06agujeroNegroAtacadoNoRecibioDano(){ 
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaFactory factoryDefensor = new CartaFactory(defensor);
		
		CartaMonstruo monstruoAtacante = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo monstruoDefensor = factoryDefensor.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(monstruoAtacante, 0, new ArrayList<CartaMonstruo>());
		defensor.colocarCartaEnZona(monstruoDefensor, 0, new ArrayList<CartaMonstruo>());
		
		CartaMagica agujeroNegro = factoryAtacante.crearCartaAgujeroNegro();
		
		int pvAtacadoAntesDelAtaque = defensor.obtenerPuntosDeVida();
		
		agujeroNegro.colocarBocaArriba(defensor);
		
		int pvAtacadoDespuesDelAtaque = defensor.obtenerPuntosDeVida();
		
		assertEquals(pvAtacadoAntesDelAtaque, pvAtacadoDespuesDelAtaque);
	}
}
