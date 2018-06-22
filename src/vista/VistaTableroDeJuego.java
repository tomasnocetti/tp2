package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import vista.eventHandlers.CuadradoEventHandler;

public class VistaTableroDeJuego extends VBox {
	
	VBox jugador1;
	VBox jugador2;
	
	public VistaTableroDeJuego() {
		super();
		jugador1 = this.generarZonaMonstruosyTrampa(true);
		jugador1.setSpacing(10);
		jugador2 = this.generarZonaMonstruosyTrampa(false);
		jugador2.setSpacing(10);

		this.setSpacing(250);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("tablero");
		this.getChildren().addAll(jugador1,jugador2);	
	}
	
	private VBox generarZonaMonstruosyTrampa(boolean normal) {
		GridPane zonaMonstruos2 = new GridPane();
		zonaMonstruos2.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaMonstruos2.getStyleClass().add("gridPane-cartas");
		zonaMonstruos2.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			contenedor.setOnMouseClicked(new CuadradoEventHandler(contenedor,javafx.scene.paint.Color.BLUE));
			zonaMonstruos2.add(contenedor, i+1 , 0);
		}
		
		GridPane zonaTrampas2 = new GridPane();
		zonaTrampas2.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaTrampas2.getStyleClass().add("gridPane-cartas");
		zonaTrampas2.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			contenedor.setOnMouseClicked(new CuadradoEventHandler(contenedor,javafx.scene.paint.Color.GREEN));
			zonaTrampas2.add(contenedor, i+1, 1);
		}
		
		if (normal) {
			return new VBox(zonaTrampas2,zonaMonstruos2);
		}
		return new VBox(zonaMonstruos2,zonaTrampas2);
	}
}
