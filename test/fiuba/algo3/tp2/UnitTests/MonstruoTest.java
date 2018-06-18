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
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador); //estrellas,ataque,def
		carta.colocarEnAccionDeAtaque();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionAtaque.class);
	}
	
	
	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador);
		carta.colocarEnAccionDeDefensa();
		Accionable accionMonstruo = carta.obtenerAccion();
		assertEquals(accionMonstruo.getClass(), AccionDefensa.class); 
	}
	
	
	@Test
	public void test03monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaqueYQuitaPuntosDeVidaAlOponente(){
		
		Jugador atacado = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacado);
		atacado.colocarMonstruo(carta1, 0, new ArrayList<CartaMonstruo>());
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(1800, 1000);
		carta1.colocarEnAccionDeAtaque();
		carta2.colocarEnAccionDeAtaque();
		carta2.atacar(carta1);
		assertEquals(7200,atacado.obtenerPuntosDeVida());
	}
	
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test04monstruoConMayorAtaqueAtacaAOtroYLoDestruye() {
		CartaMonstruo carta1 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(2000, 1000);
		carta1.colocarEnAccionDeAtaque();
		carta2.colocarEnAccionDeAtaque();
		// Ataca y lo destrulle.
		carta2.atacar(carta1); 
		// Ataca y lanza excepcion.
		carta2.atacar(carta1);
		
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaqueYSeDestruye(){
		CartaMonstruo carta1 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(2000, 1000);
		carta2.colocarEnAccionDeAtaque();
		carta1.colocarEnAccionDeAtaque();
		carta1.atacar(carta2); //Ataca y se destruye
		
		carta2.atacar(carta1); // Ataca pero la carta1 esta destruida ; se lanza la excepcion CartaNoSeEncuentraEnZona
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElPrimerMonstruoSeDestruye(){
		CartaMonstruo carta1 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		carta2.colocarEnAccionDeAtaque();
		carta1.colocarEnAccionDeAtaque();
		
		carta1.atacar(carta2); //se destruye la carta1
		carta1.atacar(carta1); //esta destruida la carta1 y por lo tanto lanza excepcion
	}
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test08monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaqueElSegundoSeDestruye(){
		CartaMonstruo carta1 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000);
		carta2.colocarEnAccionDeAtaque();
		carta1.colocarEnAccionDeAtaque();
		
		carta1.atacar(carta2); // se destruye la carta2
		carta2.atacar(carta1); //esta destruida la carta2 y por lo tanto lanza excepcion
	}

}
