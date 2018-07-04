package vista;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vista.eventHandlers.ControladorDeJuego;

public class LayoutContenedorJuego extends BorderPane {
	
	private VistaInformacionDeJuego vistaInformacionDeJuego;
	private VistaTableroDeJuego vistaTableroDeJuego;
	private VistaMano vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;
	private SceneJuego sceneJuego;
	private SceneInicio sceneInicio;
	
	public LayoutContenedorJuego(Stage stage) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("layout");

		vistaTableroDeJuego = new VistaTableroDeJuego(stage);
		vistaInformacionDeJuego = new VistaInformacionDeJuego(this);
		vistaMano = new VistaMano();

	    ScrollPane scrollPane = new ScrollPane(vistaMano);
	    scrollPane.setFitToHeight(true);
	    scrollPane.setPadding(new Insets(15));
	    scrollPane.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		scrollPane.getStyleClass().add("scrollPane");
	    
	    BorderPane borderMano = new BorderPane(scrollPane);
	    borderMano.setPadding(new Insets(15));
		borderMano.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		borderMano.getStyleClass().add("contenedorMano");
	    
		vistaPuntosDeVida = new VistaPuntosDeVida(this);
		
		//this.setLeft(vistaPuntosDeVida);
        this.setCenter(vistaTableroDeJuego);
        this.setLeft(vistaInformacionDeJuego);
		this.setBottom(borderMano);
		
		ControladorDeJuego.inicializar(vistaMano, vistaInformacionDeJuego, vistaTableroDeJuego, vistaPuntosDeVida,stage);
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		controlador.dibujar();
	}

	public void agregarSceneJuego(SceneJuego sceneJuego) {
		this.sceneJuego = sceneJuego;
	}

	public void agregarSceneInicio(SceneInicio sceneInicio) {
		this.sceneInicio = sceneInicio;
		
	}
}
