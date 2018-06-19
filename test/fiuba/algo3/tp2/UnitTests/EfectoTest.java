package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;


import org.junit.Test;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class EfectoTest {
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test01activarEfectoAgujeroNegroSobreOponenteCon1Monstruo() {
		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();
		CartaFactory factory = new CartaFactory(jugador);
		CartaFactory factory2 = new CartaFactory(jugador2);
		
		CartaMonstruo carta = factory.crearCartaMonstruoGenerica(1000, 1000);
		CartaMonstruo carta2 = factory2.crearCartaMonstruoGenerica(1000, 1000);
		
		Efecto efecto = new EfectoAgujeroNegro();
		efecto.activarSobreJugadorAtacado(jugador);
		carta.atacar(carta2);
	}

}
