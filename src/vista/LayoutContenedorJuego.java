package vista;

import javafx.scene.layout.BorderPane;

public class LayoutContenedorJuego extends BorderPane {
	
	public LayoutContenedorJuego () {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("layout");		
	}
}
