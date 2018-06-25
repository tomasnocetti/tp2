package vista;


import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SceneCompletarNombres extends Scene{

	public SceneCompletarNombres(Stage stage, SceneJuego sceneJuego, MediaPlayer mediaPlayer) {
		super(new LayoutContenedorCompletarNombres(stage, sceneJuego, mediaPlayer),900,1000);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
	}
	
}
