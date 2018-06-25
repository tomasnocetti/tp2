package vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.layout.VBox;

public class VistaTableroDeJuego extends VBox {
	
	private VistaTableroJugador vistaTableroJugador1;
	private VistaTableroJugador vistaTableroJugador2;

	
	public VistaTableroDeJuego() {
		super();

		
		vistaTableroJugador1 = new VistaTableroJugador(true);
		vistaTableroJugador2 = new VistaTableroJugador(false);


		this.setSpacing(300);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("tablero");
		this.getChildren().addAll(vistaTableroJugador1,vistaTableroJugador2);	
	}
}
