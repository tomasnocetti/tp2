package vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneJuego extends Scene {
	
	private SceneInicio sceneInicio;
	private Juego juego;
	
	public SceneJuego(Stage stage) {
		super(new LayoutContenedorJuegoTotal(stage),900,1000);        
		((LayoutContenedorJuegoTotal) this.getRoot()).agregarSceneJuego(this);
	}

	public void agregarSceneInicio(SceneInicio sceneInicio) {
		this.sceneInicio = sceneInicio;
		((LayoutContenedorJuego) this.getRoot()).agregarSceneInicio(sceneInicio);
	}
}
