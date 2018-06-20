package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BotonCartaEventHandler implements EventHandler<ActionEvent> {

	private Node image;
	private Button button;

	public BotonCartaEventHandler(Button button, Image image) {
        this.image = new ImageView(image);
        this.button = button;
    }
	
	public void handle(ActionEvent arg0) {
		Node aux = button.getGraphic();
		button.setGraphic(image);
		this.image = aux;
	}
	

}
