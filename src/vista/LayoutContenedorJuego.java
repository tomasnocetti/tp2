package vista;

import fiuba.algo3.tp2.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class LayoutContenedorJuego extends BorderPane {
	
	private VistaInformacionDeCarta vistaInformacionDeCarta;
	private VistaTableroDeJuego vistaTableroDeJuego;
	private VistaMano vistaMano;
	private VistaPuntosDeVida vistaPuntosDeVida;
	private SceneJuego sceneJuego;
	private SceneInicio sceneInicio;
	private Juego juego;
	
	public LayoutContenedorJuego() {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("layout");	

		vistaTableroDeJuego = new VistaTableroDeJuego();
		vistaInformacionDeCarta= new VistaInformacionDeCarta(this);
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
		
		this.setRight(vistaPuntosDeVida);
        this.setCenter(vistaTableroDeJuego);
        this.setLeft(vistaInformacionDeCarta);
		this.setBottom(borderMano);
	}

	public void agregarSceneJuego(SceneJuego sceneJuego) {
		this.sceneJuego = sceneJuego;
	}

	public void agregarSceneInicio(SceneInicio sceneInicio) {
		this.sceneInicio = sceneInicio;
		
	}
}
