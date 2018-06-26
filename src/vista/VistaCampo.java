package vista;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.scene.layout.HBox;

public class VistaCampo extends HBox{

	public VistaCampo(int num_jugador) {
		super();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		this.getChildren().add(new ContenedorCartaVacia(jugador,"Campo"));
	}
	
	
	
}
