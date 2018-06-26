package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContenedorCartaMazo extends VBox {
	
	public ContenedorCartaMazo(String cartas) {
		Button button = new Button(cartas);
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.setPrefHeight(250);
		this.setPrefWidth(200);
		
		button.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		button.getStyleClass().add("button-cartas");
		button.setPrefHeight(250);
		button.setPrefWidth(200);
	}
}
