package vista;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlGoHo extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ejemplo Integrador");
		
		
        TextField texto = new TextField();
        texto.setPromptText("Ingrese el texto deseado");
        
        Label etiqueta = new Label();
        etiqueta.setText(texto.getText());
        
		BorderPane layoutJuego = new BorderPane();
		
		FlowPane zonaMano = new FlowPane();
		zonaMano.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		zonaMano.getStyleClass().add("flowPane");
		zonaMano.setAlignment(Pos.CENTER);
		ImageView pages[] = new ImageView[2];
		
		pages[0] = new ImageView(new Image(AlGoHo.class.getResourceAsStream("carta1.jpg"),150,150, true, true));
		pages[1] = new ImageView(new Image(AlGoHo.class.getResourceAsStream("carta2.jpg"),150,150, true, true));
	    zonaMano.getChildren().addAll(pages[0],pages[1]);
		
		
		layoutJuego.setBottom(zonaMano);
        Scene sceneJuego = new Scene(layoutJuego, 900, 1000);
        
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
//        botonSalir.setStyle();
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage,sceneJuego);
        botonJugar.setOnAction(botonJugarEventHandler);
        
        
        HBox contenedorHorizontal = new HBox(botonJugar,botonSalir);
        contenedorHorizontal.setSpacing(10);
        
        VBox contenedorPrincipal = new VBox(texto, contenedorHorizontal, etiqueta);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));
        

        
        Scene scene = new Scene(contenedorPrincipal, 900, 1000);


        scene.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        
        stage.setScene(scene);
//        stage.setFullScreen(true);
        stage.show();
	}

	
}
