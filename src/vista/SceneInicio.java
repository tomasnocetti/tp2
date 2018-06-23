package vista;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneInicio extends Scene {

	public SceneInicio(Stage stage, SceneCompletarNombres sceneCompletarNombres) {
		super(new LayoutContenedorInicio(stage, sceneCompletarNombres),900,1000);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
	}

}
