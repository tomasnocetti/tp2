package vista;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneCompletarNombres extends Scene{

	public SceneCompletarNombres(LayoutContenedorCompletarNombres layoutContenedorCompletarNombres) {
		super(layoutContenedorCompletarNombres,900,1000);
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
	}
	
}
