package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventHandlers.BotonJugarEventHandler;
import vista.eventHandlers.BotonSalirEventHandler;

public class LayoutContenedorInicio extends VBox {
	
	public LayoutContenedorInicio(Stage stage, Scene sceneCompletarNombres) {
		super();
		
        Button botonJugar = new Button();
        botonJugar.setText("Continuar");
        botonJugar.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonJugar.getStyleClass().add("button");
        

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonSalir.getStyleClass().add("button");
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage,sceneCompletarNombres);
        botonJugar.setOnAction(botonJugarEventHandler);
        
        HBox contenedorHorizontal = new HBox(botonJugar,botonSalir);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(contenedorHorizontal);
	}
}
