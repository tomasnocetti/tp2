package vista;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.scene.layout.HBox;

public class VistaCementerio extends HBox {

	public VistaCementerio(int num_jugador) {
		super();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		this.getChildren().add(new ContenedorCartaVacia(jugador,"Cementerio"));
	}

}
