package vista;

import java.awt.Color;

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

public class AlGoHo extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("AlGoHo");
        
		BorderPane layoutJuego = new BorderPane();
		
		FlowPane zonaMano = this.crearZonaMano();
		VBox tableroDeJuego = this.crearTableroDeJuego();
		VBox zonaInformacionCarta = new VBox();
		
		layoutJuego.setBottom(zonaMano);
        layoutJuego.setCenter(tableroDeJuego);
        layoutJuego.setLeft(zonaInformacionCarta);
		Scene sceneJuego = new Scene(layoutJuego, 900, 1000);
        
		VBox contenedorPrincipal = this.crearInterfazPrincipal(stage, sceneJuego);
        
        Scene scenePrincipal = new Scene(contenedorPrincipal, 900, 1000);


        scenePrincipal.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        
        stage.setScene(scenePrincipal);
        stage.setFullScreen(true);
        stage.show();
	}

	private VBox crearTableroDeJuego() {
		
		GridPane zonaMonstruos1 = new GridPane();
		zonaMonstruos1.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaMonstruos1.getStyleClass().add("gridPane-cartas");
		zonaMonstruos1.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			zonaMonstruos1.add(contenedor, i+1 , 0);
		}
		GridPane zonaTrampas1 = new GridPane();
		zonaTrampas1.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaTrampas1.getStyleClass().add("gridPane-cartas");
		zonaTrampas1.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			zonaTrampas1.add(contenedor, i+1, 1);
		}
		
		GridPane zonaMonstruos2 = new GridPane();
		zonaMonstruos2.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaMonstruos2.getStyleClass().add("gridPane-cartas");
		zonaMonstruos2.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			zonaMonstruos2.add(contenedor, i+1 , 0);
		}
		GridPane zonaTrampas2 = new GridPane();
		zonaTrampas2.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaTrampas2.getStyleClass().add("gridPane-cartas");
		zonaTrampas2.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			Rectangle contenedor = new Rectangle(150,150);
			contenedor.setFill(javafx.scene.paint.Color.GRAY);
			contenedor.getStyleClass().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
			contenedor.setStyle("contenedorCarta");
			zonaTrampas2.add(contenedor, i+1, 1);
		}
		
		VBox jugador1 = new VBox(zonaMonstruos1,zonaTrampas1);
		VBox jugador2 = new VBox(zonaMonstruos2,zonaTrampas2);

		VBox tableroDeJuego = new VBox();
		tableroDeJuego.setSpacing(250);
		tableroDeJuego.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		tableroDeJuego.getStyleClass().add("tablero");
		tableroDeJuego.getChildren().addAll(jugador1,jugador2);

		
		return tableroDeJuego;
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
        
        VBox contenedorPrincipal = new VBox(contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));
        
        return contenedorPrincipal;
	}

	private FlowPane crearZonaMano() {
	
		FlowPane zonaMano = new FlowPane();
		zonaMano.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaMano.getStyleClass().add("flowPane");
		zonaMano.setAlignment(Pos.CENTER);
		
		Button pages[] = new Button[2];
		
		Image cartaBocaAbajo = new Image(AlGoHo.class.getResourceAsStream("cartaBocaAbajo.jpg"),150,150, true, true);
		
		for(int i =0; i < 2; i++) {
			pages[i] = new Button("",new ImageView(new Image(AlGoHo.class.getResourceAsStream("carta" + (i+1) +".jpg"),150,150, true, true)));
	        BotonCartaEventHandler botonCartaEventHandler = new BotonCartaEventHandler(pages[i],cartaBocaAbajo);
	        pages[i].setOnAction(botonCartaEventHandler);
	        BotonCartaEventHandlerDrag botonCartaEventHandlerDrag = new BotonCartaEventHandlerDrag(pages[i]);
	        pages[i].setOnDragDetected(botonCartaEventHandlerDrag);
			zonaMano.getChildren().add(pages[i]);
		}        

		return zonaMano;
	}

	
}

