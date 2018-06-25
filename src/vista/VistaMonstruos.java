package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import vista.eventHandlers.CuadradoEventHandler;

public class VistaMonstruos extends GridPane{
	
	public VistaMonstruos() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			ContenedorCartaVacia contenedor = new ContenedorCartaVacia();
//			contenedor.setOnMouseClicked();
			this.add(contenedor, i+1 , 0);
		}
	}
}
