package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

	public BotonSalirEventHandler(Stage stage) {
        this.stage = stage;
    }
    
	public void handle(ActionEvent event) {
		this.stage.close();
	}
	
}
