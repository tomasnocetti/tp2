package fiuba.algo3.tp2.Tableros;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;

public class ZonaMano extends Zona{
		
	public ZonaMano(Jugador jugador) {
		super(jugador);
		this.limite = 10;
		// TODO Auto-generated constructor stub
	}
	
	public void agregarCarta(Carta carta) {
		super.agregarCarta(carta, this.cartas.size());
		Efecto efecto = carta.obtenerEfecto();
		efecto.activarAlAgregarAZonaMano(this, carta);
	}
}
