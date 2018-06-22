package vista;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import vista.eventHandlers.ApretarEnImagenEventHandler;

public class VistaMano extends FlowPane {
	

	public static final String DOBLE_BARRA = "//";
	
	public VistaMano() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("flowPane");
		this.setAlignment(Pos.CENTER);
		
		ImageView pages[] = new ImageView[2];
		
		Image cartaBocaAbajo = new Image(this.getClass().getResourceAsStream("img" +DOBLE_BARRA+"cartaBocaAbajo.jpg"),150,150, true, true);
		
		for(int i =0; i < 2; i++) {
			pages[i] = new ImageView(new Image(this.getClass().getResourceAsStream("img" + DOBLE_BARRA +"carta" + (i+1) +".jpg"),150,150, true, true));
	        ApretarEnImagenEventHandler aprentarEnCartaEventHandler = new ApretarEnImagenEventHandler(cartaBocaAbajo,pages[i]);
	        pages[i].setOnMouseClicked(aprentarEnCartaEventHandler);
//	        PasarEnImagenEventHandler pasarEnCartaEventHandler = new PasarEnImagenEventHandler(pages[i],zonaInformacionCarta);
//	        pages[i].setOnMousePressed(pasarEnCartaEventHandler);
//	        SalirDeImagenEventHandler SalirDeCartaEventHandler = new SalirDeImagenEventHandler(pages[i],zonaInformacionCarta);
//	        pages[i].setOnMouseReleased(SalirDeCartaEventHandler);
			this.getChildren().add(pages[i]);
		}        
	
	}
}
