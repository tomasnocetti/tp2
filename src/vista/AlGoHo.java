package vista;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



public class AlGoHo extends Application{
	
	private SceneCompletarNombres sceneCompletarNombres;
	private SceneInicio sceneInicio;
	
	private MediaPlayer mediaPlayer;
	
	
	public static final String DOBLE_BARRA = "//";

    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlGoHo");
        
        mediaPlayer = new MediaPlayer(new Media(new File("src/vista/YugiohTema.wav").toURI().toString()));
		mediaPlayer.play();
		mediaPlayer.setVolume(0.04);
        
        sceneCompletarNombres = new SceneCompletarNombres(stage, mediaPlayer);
        
        sceneInicio = new SceneInicio(stage, sceneCompletarNombres, mediaPlayer);
	
        stage.setScene(sceneInicio);
        stage.setFullScreen(true);
        stage.show();
	}	
}

