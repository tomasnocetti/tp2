package vista.eventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene sceneJuego;
	private MediaPlayer mediaPlayer;

	public BotonJugarEventHandler (Stage stage, Scene sceneJuego, MediaPlayer mediaPlayer) {
		this.stage = stage;
		this.sceneJuego = sceneJuego;
		this.mediaPlayer = mediaPlayer;
	}
	
	public void handle(ActionEvent event) {
		this.mediaPlayer.stop();
		this.stage.setScene(this.sceneJuego);
		this.stage.setFullScreen(true);
	}

}
