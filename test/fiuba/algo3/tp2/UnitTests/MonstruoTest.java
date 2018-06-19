package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.tp2.Cartas.CartaFactory;
//import fiuba.algo3.tp2.Cartas.AgujeroNegro;
//import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;
import fiuba.algo3.Estados.*;
import fiuba.algo3.tp2.Jugador;

public class MonstruoTest {
	
	@Test
	public void test01colocarCartaMonstruoPosicionAtaque() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo carta = factory.crearCartaMonstruoGenerica(1000, 1000);
		carta.colocarEnAccionDeDefensa();
		
		carta.colocarEnAccionDeAtaque();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionAtaque.class);
	}
	
	
	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		Jugador jugador = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaMonstruo carta = factory.crearCartaMonstruoGenerica(1000, 1000);
		carta.colocarEnAccionDeDefensa();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionDefensa.class); 
	}
	
	
	@Test
	public void test03monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaqueYQuitaPuntosDeVidaAlOponente(){
		
		Jugador atacado = new Jugador();
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		
		CartaMonstruo carta1 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1800, 1000);
		atacante.colocarCartaEnZona(carta2, 0, new ArrayList<CartaMonstruo>());
		atacado.colocarCartaEnZona(carta1, 0, new ArrayList<CartaMonstruo>());
		
		carta2.atacar(carta1);
		assertEquals(7200,atacado.obtenerPuntosDeVida());
	}
	
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test04monstruoConMayorAtaqueAtacaAOtroYLoDestruye() {
		Jugador atacado = new Jugador();
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		
		CartaMonstruo carta1 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1800, 1000);
		
		// Ataca y lo destruye.
		carta2.atacar(carta1); 
		// Ataca y lanza excepcion.
		carta2.atacar(carta1);
		
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSeDestruye(){
		Jugador atacado = new Jugador();
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		
		CartaMonstruo carta1 = factoryAtacado.crearCartaMonstruoGenerica(1800, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		
		carta1.atacar(carta2); //Ataca y se destruye
		
		carta2.atacar(carta1); // Ataca pero la carta1 esta destruida ; se lanza la excepcion CartaNoSeEncuentraEnZona
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElPrimerMonstruoSeDestruye(){
		Jugador atacado = new Jugador();
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		
		CartaMonstruo carta1 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		
		carta1.atacar(carta2); //se destruye la carta1
		carta1.atacar(carta1); //esta destruida la carta1 y por lo tanto lanza excepcion
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test08monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElSegundoSeDestruye(){
		Jugador atacado = new Jugador();
		Jugador atacante = new Jugador();
		CartaFactory factoryAtacado = new CartaFactory(atacado);
		CartaFactory factoryAtacante = new CartaFactory(atacante);
		
		CartaMonstruo carta1 = factoryAtacado.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factoryAtacante.crearCartaMonstruoGenerica(1000, 1000);
		
		carta1.atacar(carta2); // se destruye la carta2
		carta2.atacar(carta1); //esta destruida la carta2 y por lo tanto lanza excepcion
	}

}
