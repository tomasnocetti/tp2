package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {

	@Test
	public void test01colocarCartaMonstruoPosicionAtaque() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador); //estrellas,ataque,def
		carta.colocarPosicionAtaque();
		assertEquals(carta.estaEnPosicionAtaque() == true);
		//deberiamos tener un atriubuto para definir su posicion? si
	}

	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		Jugador jugador = new Jugador();
		CartaMonstruo carta = new CartaMonstruo(4,1000,100,jugador);
		carta.colocarPosicionDefenza();
		assertEquals(carta.estaEnPosicionDefenza() == true); 
	}

	@Test
	public void test03colocarCartaMagicaEnCampoBocaAbajo() {
		CartaMagica carta = new CartaMagica();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta);
		carta.colocarBocaAbajo();
		assertEquals(carta.estaBocaAbajo() == true);
		assertEquals(campo.cantidadDeCartas() == 1); 
	}
	
	@Test
	public void test04colocarCartaTrampaEnCampoBocaAbajo() {
		CartaTrampa carta = new CartaTrampa();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta);
		carta.colocarBocaAbajo();
		assertEquals(carta.estaBocaAbajo() == true);
		assertEquals(campo.cantidadDeCartas() == 1);
	}
	
	@Test
	public void test05monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionAtaque();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnPosicionAtaque();
		carta2.atacarMonstruo(carta1);
		assertEquals(defensor.darPuntosDeVida() == 7200);
		equals(carta1.estaMuerta() == true);
	}
	
	@Test
	public void test06monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100,defensor);
		carta2.colocarEnPosicionAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionAtaque();
		carta1.atacarMonstruo(carta2);
		assertEquals(atacante.darPuntosDeVida() == 7200);
		equals(carta1.estaMuerta() == true);
	}
	
	@Test
	public void test07monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,100,defensor);
		carta2.colocarEnPosicionAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionAtaque();
		carta1.atacarMonstruo(carta2);
		equals(carta1.estaMuerta() == true);
		equals(carta2.estaMuerta() == true);
		assertEquals(atacante.darPuntosDeVida() == 8000);
		assertEquals(defensor.darPuntosDeVida() == 8000);
	}

	@Test
	public void test08monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnPosicionDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100,atacante);
		carta1.colocarEnPosicionAtaque();
		carta1.atacarMonstruo(carta2);
		equals(carta2.estaMuerta() == false);
		assertEquals(defensor.darPuntosDeVida() == 8000);
		
	}

	@Test
	public void test09monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensa(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1000,1200,defensor);
		carta2.colocarEnPosicionDefensa();
		CartaMonstruo carta1 = new CartaMonstruo(4,1800,100,atacante);
		carta1.colocarEnPosicionAtaque();
		carta1.atacarMonstruo(carta2);
		equals(carta2.estaMuerta() == true);
		assertEquals(defensor.darPuntosDeVida() == 8000);
	}
	
	@Test
	public void test10agujeroNegro(){ 
		
	}
}




