package vista;

import java.util.Collection;
import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class VistaCementerio extends HBox {

	private Jugador jugador;
	private int num_jugador;

	public VistaCementerio(int num_jugador) {
		super();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		this.jugador = jugador;
		this.num_jugador = num_jugador;
		this.dibujar();
	}

	public void dibujar() {
		this.getChildren().clear();
		Collection<Carta> cartas = jugador.obtenerCartasEnCementerio();
		if(cartas.size()>0) {
			this.getChildren().add(new ContenedorCartaMazo("Cementerio", num_jugador));	
		} else {
			this.getChildren().add(new ContenedorCartaVacia(jugador, "Cementerio"));	
		}
		this.setAlignment(Pos.CENTER);
	if (jugador.equals(Juego.ObtenerJuego().jugadorOponente())) {
		this.setOpacity(0.5);	
	}else {
		this.setOpacity(1);	
	}
	}
}
