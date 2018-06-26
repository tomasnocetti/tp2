package vista;

import java.io.File;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



public class AlGoHo extends Application{
	
	private SceneJuego sceneJuego;
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
//		mediaPlayer.play();
		mediaPlayer.setVolume(0.02);
        
        sceneCompletarNombres = new SceneCompletarNombres(stage, mediaPlayer);
        
        sceneInicio = new SceneInicio(stage, sceneCompletarNombres);
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
	
        stage.setScene(new SceneJuego(stage));
        stage.setFullScreen(true);
        stage.show();
	}	
}

