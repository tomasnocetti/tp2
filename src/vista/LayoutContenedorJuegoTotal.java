package vista;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayoutContenedorJuegoTotal extends StackPane {
	
	public LayoutContenedorJuegoTotal(Stage stage) {
		super(new LayoutContenedorJuego(stage));		
	}

	public void agregarSceneJuego(SceneJuego sceneJuego) {
		((LayoutContenedorJuego) this.getChildren().get(0)).agregarSceneJuego(sceneJuego);
		
	}
}
