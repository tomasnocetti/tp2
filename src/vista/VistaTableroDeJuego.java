package vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.layout.VBox;

public class VistaTableroDeJuego extends VBox {
	
	private VistaTableroJugador vistaTableroJugador1;
	private VistaTableroJugador vistaTableroJugador2;
	private Juego juego;
	
	public VistaTableroDeJuego(Juego juego) {
		super();
		
		this.juego = juego;
		
		vistaTableroJugador1 = new VistaTableroJugador(true, juego.jugadorActual());
		vistaTableroJugador2 = new VistaTableroJugador(false, juego.jugadorOponente());


		this.setSpacing(250);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("tablero");
		this.getChildren().addAll(vistaTableroJugador1,vistaTableroJugador2);	
	}
}
