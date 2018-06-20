package vista.eventHandlers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SalirDeImagenEventHandler implements EventHandler<MouseEvent> {

	private ImageView view;
	private VBox zonaInfo;
	
	public SalirDeImagenEventHandler (ImageView imageView, VBox zonaInformacionCarta) {
		this.view = imageView;
		this.zonaInfo = zonaInformacionCarta;
	}	
	
	public void handle(MouseEvent event) {
		this.zonaInfo.getChildren().remove(0);
	}

}
