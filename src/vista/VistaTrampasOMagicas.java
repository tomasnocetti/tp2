package vista;

import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import vista.eventHandlers.OnDragEnteredContenedor;
import vista.eventHandlers.OnDragExitedContenedor;
import vista.eventHandlers.OnDragOverContenedor;

public class VistaTrampasOMagicas extends GridPane{
	
	public VistaTrampasOMagicas() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			ContenedorCartaVacia contenedor = new ContenedorCartaVacia();
			OnDragEnteredContenedor event = new OnDragEnteredContenedor(CartaTrampaOMagica.class, contenedor, 1);
			contenedor.setOnDragEntered(event);
			OnDragExitedContenedor event2 = new OnDragExitedContenedor(CartaTrampaOMagica.class, contenedor, 1);
			contenedor.setOnDragExited(event2);
			OnDragOverContenedor event3 = new OnDragOverContenedor(CartaTrampaOMagica.class, contenedor, 1);
			contenedor.setOnDragOver(event3);
			contenedor.setId("" + (i));
			this.add(contenedor, i , 1);
		}
	}
}
