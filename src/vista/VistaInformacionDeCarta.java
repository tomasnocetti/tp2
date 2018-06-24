package vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaInformacionDeCarta extends VBox {
	
	private BorderPane layoutContenedorJuego;
	private Juego juego;
	
	public VistaInformacionDeCarta(BorderPane layoutContenedorJuego, Juego juego) {
		super();
	
		this.layoutContenedorJuego = layoutContenedorJuego;
		this.juego = juego;
		
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("informacion");
		this.getChildren().add(new Button("Info"));
		this.setPrefWidth(300);
	}
}
