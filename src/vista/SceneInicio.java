package vista;

import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SceneInicio extends Scene {

	public SceneInicio(Stage stage, SceneCompletarNombres sceneCompletarNombres, MediaPlayer mediaPlayer) {
		super(new LayoutContenedorInicio(stage, sceneCompletarNombres, mediaPlayer),900,1000);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
	}

}
