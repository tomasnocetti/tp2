package vista;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class VistaTrampasOMagicas extends GridPane{
	
	public VistaTrampasOMagicas() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			ContenedorCartaVacia contenedor = new ContenedorCartaVacia();
			this.add(contenedor, i+1 , 1);
		}
	}
}
