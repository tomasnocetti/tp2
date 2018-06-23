package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventHandlers.BotonContinuarInicioEventHandler;
import vista.eventHandlers.BotonSalirEventHandler;

public class LayoutContenedorInicio extends VBox {
	
	public LayoutContenedorInicio(Stage stage, Scene sceneCompletarNombres) {
		super();
		
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonContinuar.getStyleClass().add("button");
        

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonSalir.getStyleClass().add("button");
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonContinuarInicioEventHandler botonJugarEventHandler = new BotonContinuarInicioEventHandler(stage,sceneCompletarNombres);
        botonContinuar.setOnAction(botonJugarEventHandler);
        
        HBox contenedorHorizontal = new HBox(botonContinuar,botonSalir);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(contenedorHorizontal);
	}
}
