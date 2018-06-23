package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import vista.eventHandlers.CuadradoEventHandler;

public class VistaTrampasOMagicas extends GridPane{
	
	public VistaTrampasOMagicas() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			contenedor.setOnMouseClicked(new CuadradoEventHandler(contenedor,javafx.scene.paint.Color.GREEN));
			this.add(contenedor, i+1 , 1);
		}
	}
}
