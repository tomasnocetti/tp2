package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.eventHandlers.ButtonMazoEventHandler;

public class ContenedorCartaMazo extends VBox {
	
	public ContenedorCartaMazo(String cartas, int num_jugador) {
		Button button = new Button(cartas);

		button.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		button.getStyleClass().add("button-cartas");
		button.setPrefHeight(250);
		button.setPrefWidth(200);
		
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.setPrefHeight(180);
		this.setPrefWidth(150);

	}
}
