package vista.eventHandlers;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ApretarEnImagenEventHandler implements EventHandler<MouseEvent> {
	
	private Image newImage;
	private ImageView view;
	
	public ApretarEnImagenEventHandler(Image newImage, ImageView view) {
		this.newImage = newImage;
		this.view = view;
	}
	public void handle(MouseEvent arg0) {
		Image aux = this.view.getImage();
		this.view.setImage(this.newImage);
		this.newImage = aux;
	}

}
