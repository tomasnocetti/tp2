package vista;

import java.io.File;

//import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
//import javafx.scene.paint.Color;
import vista.eventHandlers.ApretarEnImagenEventHandler;
import vista.eventHandlers.BotonJugarEventHandler;
import vista.eventHandlers.BotonSalirEventHandler;
import vista.eventHandlers.CuadradoEventHandler;
import vista.eventHandlers.PasarEnImagenEventHandler;
import vista.eventHandlers.SalirDeImagenEventHandler;


public class AlGoHo extends Application{
	
	private	BorderPane layoutContenedorJuego;
	private VistaTableroDeJuego vistaTableroDeJuego;
	private VistaInformacionDeCarta vistaInformacionDeCarta;
	private VistaMano vistaMano;
	private VistaMonstruos vistaMonstruos1;
	private VistaTrampasOMagicas vistaTrampasOMagicas1;
	private VistaMonstruos vistaMonstruos2;
	private VistaTrampasOMagicas vistaTrampasOMagicas2;
	private Scene sceneJuego;
	
	private LayoutContenedorInicio layoutContenedorInicio;
	private Scene scenePrincipal;
	
	private MediaPlayer mediaPlayer;
	
	private VBox vistaTableroJugador1;
	private VBox vistaTableroJugador2;
	private SceneCompletarNombres sceneCompletarNombres;
	private LayoutContenedorCompletarNombres layoutContenedorCompletarNombres;
	
	public static final String DOBLE_BARRA = "//";

    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlGoHo");
        
		layoutContenedorJuego = new LayoutContenedorJuego();
		
		vistaMonstruos1 = new VistaMonstruos();
		vistaTrampasOMagicas1 = new VistaTrampasOMagicas();
		vistaTableroJugador1 = new VBox(vistaTrampasOMagicas1, vistaMonstruos1);
		vistaTableroJugador1.setSpacing(10);
		vistaMonstruos2 = new VistaMonstruos();
		vistaTrampasOMagicas2 = new VistaTrampasOMagicas();
		vistaTableroJugador2 = new VBox(vistaMonstruos2, vistaTrampasOMagicas2);
		vistaTableroJugador2.setSpacing(10);
		
		vistaTableroDeJuego = new VistaTableroDeJuego(vistaTableroJugador1, vistaTableroJugador2);
		vistaInformacionDeCarta= new VistaInformacionDeCarta(layoutContenedorJuego);
		vistaMano = new VistaMano();
		
        layoutContenedorJuego.setCenter(vistaTableroDeJuego);
        layoutContenedorJuego.setLeft(vistaInformacionDeCarta);
		layoutContenedorJuego.setBottom(vistaMano);
		
        sceneJuego = new Scene(layoutContenedorJuego, 900, 1000);
        
        mediaPlayer = new MediaPlayer(new Media(new File("src/vista/YugiohTema.wav").toURI().toString()));
		mediaPlayer.play();
		mediaPlayer.setVolume(0.05);
        
        layoutContenedorCompletarNombres = new LayoutContenedorCompletarNombres(stage, sceneJuego, mediaPlayer);
        sceneCompletarNombres = new SceneCompletarNombres(layoutContenedorCompletarNombres);
        
		layoutContenedorInicio = new LayoutContenedorInicio(stage, sceneCompletarNombres);
        
        scenePrincipal = new Scene(layoutContenedorInicio, 900, 1000);

        scenePrincipal.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        
        stage.setScene(scenePrincipal);
        stage.setFullScreen(true);
        stage.show();
	}	
}

