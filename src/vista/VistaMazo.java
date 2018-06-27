package vista;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tableros.Mazo;
import javafx.scene.layout.HBox;
import vista.eventHandlers.ButtonMazoEventHandler;

public class VistaMazo extends HBox {
	private Jugador jugador;
	private int num_jugador;
	private VistaMano mano;

	public VistaMazo(int num_jugador) {
		super();
		this.num_jugador = num_jugador;
		this.mano = mano;
		this.dibujar();
	}

	public void dibujar() {
		this.getChildren().clear();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		Mazo mazo = jugador.obtenerMazo();
		this.getChildren().add(new ContenedorCartaMazo(String.valueOf(mazo.obtenerCantidadDeCartas()),num_jugador));
	}
}
