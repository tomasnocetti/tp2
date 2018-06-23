package vista;

import javafx.scene.layout.BorderPane;

public class LayoutContenedorJuego extends BorderPane {
	
	private VistaInformacionDeCarta vistaInformacionDeCarta;
	private VistaTableroDeJuego vistaTableroDeJuego;
	private VistaMano vistaMano;
	private SceneJuego sceneJuego;
	private SceneInicio sceneInicio;
	
	public LayoutContenedorJuego() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("layout");	
		
		vistaTableroDeJuego = new VistaTableroDeJuego();
		vistaInformacionDeCarta= new VistaInformacionDeCarta(this);
		vistaMano = new VistaMano();
		
        this.setCenter(vistaTableroDeJuego);
        this.setLeft(vistaInformacionDeCarta);
		this.setBottom(vistaMano);
	}

	public void agregarSceneJuego(SceneJuego sceneJuego) {
		this.sceneJuego = sceneJuego;
	}

	public void agregarSceneInicio(SceneInicio sceneInicio) {
		this.sceneInicio = sceneInicio;
		
	}
}
