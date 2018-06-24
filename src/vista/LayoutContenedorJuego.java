package vista;

import fiuba.algo3.tp2.Juego;
import javafx.scene.layout.BorderPane;

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
		
		this.juego = new Juego(); 
			
		vistaTableroDeJuego = new VistaTableroDeJuego(juego);
		vistaInformacionDeCarta= new VistaInformacionDeCarta(this,juego);
		vistaMano = new VistaMano(juego);
		vistaPuntosDeVida = new VistaPuntosDeVida(this);
		
		
		this.setRight(vistaPuntosDeVida);
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
