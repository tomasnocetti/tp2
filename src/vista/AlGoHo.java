package vista;

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
//	private VistaMonstruos vistaMonstruos;
//	private VistaTrampasOMagicas vistaTrampasOMagicas;
	private Scene sceneJuego;
	

	private VBox contenedorPrincipal;
	private Scene scenePrincipal;
	
	public static final String DOBLE_BARRA = "//";

    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlGoHo");
        
		layoutContenedorJuego = new BorderPane();
		layoutContenedorJuego.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		layoutContenedorJuego.getStyleClass().add("layout");
		
		
		vistaTableroDeJuego = new VistaTableroDeJuego();
		vistaInformacionDeCarta= new VistaInformacionDeCarta(layoutContenedorJuego);
		vistaMano = new VistaMano();
		
        layoutContenedorJuego.setCenter(vistaTableroDeJuego);
        layoutContenedorJuego.setLeft(vistaInformacionDeCarta);
		layoutContenedorJuego.setBottom(vistaMano);
		
        sceneJuego = new Scene(layoutContenedorJuego, 900, 1000);
        
		contenedorPrincipal = this.crearInterfazPrincipal(stage, sceneJuego);
        
        scenePrincipal = new Scene(contenedorPrincipal, 900, 1000);

        scenePrincipal.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        
        stage.setScene(scenePrincipal);
        stage.setFullScreen(true);
        stage.show();
	}

	private VBox crearInterfazPrincipal(Stage stage, Scene sceneJuego) {

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonJugar.getStyleClass().add("button");
        

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonSalir.getStyleClass().add("button");
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage,sceneJuego);
        botonJugar.setOnAction(botonJugarEventHandler);
        
        HBox contenedorHorizontal = new HBox(botonJugar,botonSalir);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        
        VBox contenedorPrincipal = new VBox(contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setAlignment(Pos.CENTER);
        
        return contenedorPrincipal;
	}


//	private Scene generarSceneEleccionAvatar() {
//		Scene eleccionAvatar = new Scene();
//		
//	}

	
}

