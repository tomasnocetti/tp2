package vista;

import javafx.scene.Scene;

public class SceneJuego extends Scene {
	
	private SceneInicio sceneInicio;
	
	public SceneJuego() {
		super(new LayoutContenedorJuego(),900,1000);        
		((LayoutContenedorJuego) this.getRoot()).agregarSceneJuego(this);
	}

	public void agregarSceneInicio(SceneInicio sceneInicio) {
		this.sceneInicio = sceneInicio;
		((LayoutContenedorJuego) this.getRoot()).agregarSceneInicio(sceneInicio);
	}
}
