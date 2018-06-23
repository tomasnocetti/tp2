package vista;

import javafx.scene.layout.VBox;

public class VistaTableroDeJuego extends VBox {
	
	VBox jugador1;
	VBox jugador2;
	
	public VistaTableroDeJuego(VBox vistaTableroJugador1, VBox vistaTableroJugador2) {
		super();
		jugador1 = vistaTableroJugador1;
		jugador2 = vistaTableroJugador2;

		this.setSpacing(250);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("tablero");
		this.getChildren().addAll(jugador1,jugador2);	
	}
}
