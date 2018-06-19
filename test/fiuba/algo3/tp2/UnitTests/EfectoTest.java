package fiuba.algo3.tp2.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class EfectoTest {
	
	@Test(expected = CartaNoSeEncuentraEnZona.class)
	public void test01activarEfectoAgujeroNegroSobreOponenteCon1Monstruo() {
		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();
		CartaMonstruo carta = CartaFactory.crearCartaMonstruoGenerica(1000, 1000, jugador);
		carta.colocarEnAccionDeAtaque();
		CartaMonstruo carta2 = CartaFactory.crearCartaMonstruoGenerica(1000, 1000, jugador2);
		carta2.colocarEnAccionDeAtaque();
		Efecto efecto = new EfectoAgujeroNegro();
		efecto.activarSobreJugadorDefensivo(jugador);
		carta.atacar(carta2);
	}
}
