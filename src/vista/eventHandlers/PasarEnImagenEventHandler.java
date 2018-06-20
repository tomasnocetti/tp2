package vista.eventHandlers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PasarEnImagenEventHandler implements EventHandler<MouseEvent> {
	
	private ImageView view;
	private VBox zonaInfo;
	
	public PasarEnImagenEventHandler (ImageView imageView, VBox zonaInformacionCarta) {
		this.view = imageView;
		this.zonaInfo = zonaInformacionCarta;
	}	
	
	public void handle(MouseEvent event) {
		this.zonaInfo.getChildren().add(new ImageView(this.view.getImage()));
	}

}
