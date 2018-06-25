package vista;

import fiuba.algo3.tp2.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.eventHandlers.ApretarEnImagenEventHandler;

public class VistaMano extends HBox{
	

	public static final String DOBLE_BARRA = "//";
	
	public VistaMano(Juego juego) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("contenedorMano");
		this.setAlignment(Pos.CENTER);
		
		ContenedorCarta pages[] = new ContenedorCarta[20];
		
//		Image cartaBocaAbajo = new Image(this.getClass().getResourceAsStream("img" +DOBLE_BARRA+"cartaBocaAbajo.jpg"),150,150, true, true);

		for(int i =0; i < 5; i++) {
			pages[i] = new ContenedorCarta(i,3000,"InsectoComeHombres");
	        this.getChildren().add(pages[i]);
	        VistaMano.setMargin(pages[i],new Insets(10));
		}        
	
	}
}
