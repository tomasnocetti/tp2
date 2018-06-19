package vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
//        botonSalir.setStyle();
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
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
