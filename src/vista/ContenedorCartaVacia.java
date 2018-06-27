package vista;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCartaVacia extends VBox{
	
	private Jugador jugador;
	public ContenedorCartaVacia(Jugador jugador, String zona) {
		super();
		this.jugador = jugador;
		Button button = new Button(zona);
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("button");
		button.setPrefHeight(180);
		button.setPrefWidth(150);
		this.setPrefHeight(180);
		this.setPrefWidth(150);
		this.setMaxSize(getPrefWidth(), getPrefHeight());
	}
	
	public boolean jugadorEsValido(Jugador jugador2) {
		return this.jugador.equals(jugador2);
	}

}
