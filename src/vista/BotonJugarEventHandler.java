package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene sceneJuego;

	public BotonJugarEventHandler (Stage stage, Scene sceneJuego) {
		this.stage = stage;
		this.sceneJuego = sceneJuego;
	}
	
	public void handle(ActionEvent arg0) {
		this.stage.setScene(this.sceneJuego);
		this.stage.setFullScreen(true);
	}

}
