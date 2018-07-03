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
        botonContinuar.getStyleClass().add("button-inicio");
        
		Text titulo = new Text(100, 100, "Bienvenidos a YuGiOh");
		titulo.setFill(Color.RED);
		titulo.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 70));
	    final Light.Distant light = new Light.Distant();
	    light.setAzimuth(-135.0);
	    final Lighting lighting = new Lighting();
	    lighting.setLight(light);
	    lighting.setSurfaceScale(9.0);

        Button botonSalir = new Button();
        botonSalir.setText("SALIR");
        botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        botonSalir.getStyleClass().add("button-inicio");
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler(stage);
        botonSalir.setOnAction(botonSalirEventHandler);
        
        BotonContinuarInicioEventHandler botonJugarEventHandler = new BotonContinuarInicioEventHandler(stage,sceneCompletarNombres);
        botonContinuar.setOnAction(botonJugarEventHandler);
        
        VBox contenedorBotones = new VBox(botonContinuar,botonSalir); 
        contenedorBotones.setSpacing(50);
        contenedorBotones.setPadding(new Insets(100));
        contenedorBotones.setAlignment(Pos.CENTER);
        
        VBox contenedorVertical = new VBox(titulo,contenedorBotones);
        contenedorVertical.setSpacing(180);
        contenedorVertical.setPadding(new Insets(100));
        contenedorVertical.setAlignment(Pos.CENTER);
        
        this.setSpacing(30);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(contenedorVertical);
	}
}
