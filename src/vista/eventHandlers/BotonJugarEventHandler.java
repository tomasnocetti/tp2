package vista.eventHandlers;

import vista.SceneJuego;
import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene sceneJuego;
	private MediaPlayer mediaPlayer;
	private String nombre1;
	private String nombre2;

	public BotonJugarEventHandler (Stage stage, MediaPlayer mediaPlayer,String nombre1, String nombre2) {
		this.stage = stage;
		this.mediaPlayer = mediaPlayer;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
	}
	
	public void handle(ActionEvent event) {
		sceneJuego = new SceneJuego(stage);
		mediaPlayer.stop();
		this.stage.setScene(sceneJuego);
		this.stage.setFullScreen(true);
	}

}
