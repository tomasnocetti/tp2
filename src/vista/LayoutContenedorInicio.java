package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vista.eventHandlers.BotonContinuarInicioEventHandler;
import vista.eventHandlers.BotonSalirEventHandler;

public class LayoutContenedorInicio extends HBox {
	
	public LayoutContenedorInicio(Stage stage, Scene sceneCompletarNombres) {
		super();
		
        Button botonContinuar = new Button();
        botonContinuar.setText("JUGAR");
        botonContinuar.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonContinuar.getStyleClass().add("button");
        
		//Esto tiene que ir en el contenedor inicio
		Text titulo = new Text(300, 300, "Bienvenidos a YuGiOh");
		titulo.setFill(Color.DARKORANGE);
		titulo.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 60));
	    final Light.Distant light = new Light.Distant();
	    light.setAzimuth(-135.0);
	    final Lighting lighting = new Lighting();
	    lighting.setLight(light);
	    lighting.setSurfaceScale(9.0);

        Button botonSalir = new Button();
        botonSalir.setText("SALIR");
        botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonSalir.getStyleClass().add("button");
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonContinuarInicioEventHandler botonJugarEventHandler = new BotonContinuarInicioEventHandler(stage,sceneCompletarNombres);
        botonContinuar.setOnAction(botonJugarEventHandler);
        
        VBox contenedorVertical = new VBox(titulo,botonContinuar,botonSalir);
        contenedorVertical.setSpacing(50);
        contenedorVertical.setPadding(new Insets(250));
        contenedorVertical.setAlignment(Pos.CENTER);
        
        this.setSpacing(30);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().add(contenedorVertical);
	}
}
