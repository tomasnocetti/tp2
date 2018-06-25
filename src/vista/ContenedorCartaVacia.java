package vista;

import fiuba.algo3.tp2.Cartas.Carta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCartaVacia extends VBox{

	public ContenedorCartaVacia() {
		super();
		Button button = new Button("+");
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("button-cartas");
		button.setPrefHeight(250);
		this.setPrefWidth(200);
		this.setPrefHeight(250);
		this.setPrefWidth(200);
	}

}
