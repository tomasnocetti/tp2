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
		carta.colocarBocaAbajo();
		jugador.colocarCartaEnZona(carta,  0);
		
		assertEquals(carta.obtenerEstado().getClass(), PosicionAbajo.class);
		assertTrue(jugador.obtenerCartasMagicasYTrampas().contains(carta)); 
	}
	
	@Test
	public void test04colocarCartaTrampaEnCampoBocaAbajo() {

		Jugador jugador = new Jugador();
		CartaFactory cartaFactory = new CartaFactory(jugador);
		CartaTrampa carta = cartaFactory.crearCartaTrampaGenerica();
		carta.colocarBocaAbajo();
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
		
		assertFalse(atacante.obtenerMonstruos().contains(carta));
		assertTrue(atacante.obtenerCartasEnCementerio().contains(carta));

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
		assertFalse(atacado.obtenerMonstruos().contains(carta2));
		assertTrue(atacado.obtenerCartasEnCementerio().contains(carta2));
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
	
	
	
	@Test
	public void test11SacrificioDeUnMonstruo() {
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaMonstruo mounstruo = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		
		atacante.colocarCartaEnZona(mounstruo, 0, new ArrayList<CartaMonstruo>());
		
		CartaMonstruo mounstruoSacrificio = factoryAtacante.crearCartaMonstruoGenerica1Sacrificio(1000, 1000);
		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(mounstruo);
		
		atacante.colocarCartaEnZona(mounstruoSacrificio, 1, sacrificios);
		
		assertTrue( mounstruoSacrificio.estaEnElCampo());
		assertTrue( atacante.obtenerCartasEnCementerio().contains(mounstruo));
	}
	
	@Test
	public void test12SacrificioDeDosMonstruos() {
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		CartaMonstruo mounstruo = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo mounstruo2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);

		atacante.colocarCartaEnZona(mounstruo, 0, new ArrayList<CartaMonstruo>());
		
		CartaMonstruo mounstruoSacrificio = factoryAtacante.crearCartaMonstruoGenerica2Sacrificio(1000, 1000);
		ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
		sacrificios.add(mounstruo);
		sacrificios.add(mounstruo2);
		
		atacante.colocarCartaEnZona(mounstruoSacrificio, 1, sacrificios);
		
		assertTrue( mounstruoSacrificio.estaEnElCampo());
		assertTrue( atacante.obtenerCartasEnCementerio().contains(mounstruo));
		
	}
	
}




