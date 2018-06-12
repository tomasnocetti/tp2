package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {

	@Test
	public void test01colocarCartaMonstruoPosicionAtaque() {
		CartaMonstruo carta = new CartaMonstruo(4,1000,100); //estrellas,ataque,def
		carta.colocarPosicionAtaque();
		assertEquals(carta.estaEnPosicionAtaque() == true);
		//deberiamos tener un atriubuto para definir su posicion?
	}

	@Test
	public void test02colocarCartaMonstruoPosicionDefensa() {
		CartaMonstruo carta = new CartaMonstruo(4,1000,100);
		carta.colocarPosicionDefenza();
		assertEquals(carta.estaEnPosicionDefenza() == true); //nose si seria mejor (carta.estaEnPosicionAtaque == false) para tener 1 solo metodo
	}

	@Test
	public void test03colocarCartaMagicaEnCampoBocaAbajo() {
		CartaMagica carta = new CartaMagica();
		ZonaDeCartasMagicasOTrampas campo = new ZonaDeCartasMagicasOTrampas();
		campo.agregarCarta(carta);
		carta.colocarBocaAbajo();
		assertEquals(carta.estaBocaAbajo() == true);
		assertEquals(campo.cantidadDeCartas() == 1); //no estoy seguro si agregar carta tendria que tener un parametro que pase el estado por ahi
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
	public void test06monstruoConMayorAtaqueAtacaAOtroConMenorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100);
		carta1.colocarPosicionAtaque();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100);
		carta2.colocarPosicionAtaque();
		carta2.atacarMonstruo(carta1, atacante, defensor);
		assertEquals(defensor.darPuntosDeVida() == 7200);
		//para verificar si una carta esta muerta deferiamos tener un atributo estado?
	}
	
	@Test
	public void test07monstruoConMenorAtaqueAtacaAOtroConMayorAtaqueAmbosEnPosicionDeAtaque(){
		Jugador atacante = new Jugador();
		Jugador defensor = new Jugador();
		CartaMonstruo carta2 = new CartaMonstruo(4,1800,100);
		carta2.colocarPosicionAtaque();
		CartaMonstruo carta1 = new CartaMonstruo(4,1000,100);
		carta1.colocarPosicionAtaque();
		carta1.atacarMonstruo(carta2, atacante, defensor);
		assertEquals(atacante.darPuntosDeVida() == 7200);
		//misma duda que test06
	}
	
	@Test
	public void test08monstruoAtacaAOtroConIgualAtaqueAmbosEnPosicionDeAtaque(){
		fail("Not yet implemented");
	}

	@Test
	public void test09monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMenorDefensa(){
		fail("Not yet implemented");
	}

	@Test
	public void test10monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		fail("Not yet implemented");
	}
	
	@Test
	public void test11monstruoEnPosicionAtaqueAtacaOtroEnPosicionDefensaConMayorDefensa(){
		fail("Not yet implemented");
	}
	
	@Test
	public void test12agujeroNegro(){ 
		fail("Not yet implemented");
	}
}




