package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.eventHandlers.ButtonMazoEventHandler;

public class ContenedorCartaMazo extends VBox {
	
	public ContenedorCartaMazo(String cartas, int num_jugador, VistaMazo vista) {
		Button button = new Button(cartas);
		this.getChildren().add(button);
		this.setAlignment(Pos.CENTER);
		this.setPrefHeight(180);
		this.setPrefWidth(150);
		
//		ButtonMazoEventHandler buttonMazoEventHandler = new ButtonMazoEventHandler(num_jugador, vista,0,button); 
//		button.setOnAction(buttonMazoEventHandler);

		
		button.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		button.getStyleClass().add("button-cartas");
		button.setPrefHeight(250);
		button.setPrefWidth(200);
	}
}
