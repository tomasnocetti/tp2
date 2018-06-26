package vista;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCartaVacia extends VBox{
	
	private Jugador jugador;
	public ContenedorCartaVacia(Jugador jugador) {
		super();
		this.jugador = jugador;
		Button button = new Button("+");
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("button");
		button.setPrefHeight(250);
		button.setPrefWidth(200);
		this.setPrefHeight(250);
		this.setPrefWidth(200);
	}
	
	public boolean jugadorEsValido(Jugador jugador2) {
		return this.jugador.equals(jugador2);
	}

}
