package vista;

import fiuba.algo3.tp2.Jugador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.control.Button;

public class VentanaFinDeJuego {
	
	public static final String DOBLE_BARRA = "//";
	
	public static void display(String nombre) {
		
		Stage stage = new Stage();
		
		stage.setTitle("Fin de juego");
		StackPane layout = new StackPane();
		
		VBox pane = new VBox();
		layout.getChildren().add(pane);
		
		Text text2 = new Text(5,5, "El Jugador " + nombre + " a ganado");
	    pane.getChildren().add(text2);
		
		Button boton = new Button("Reiniciar");
		pane.getChildren().add(boton);
		
		pane.setAlignment(Pos.CENTER);
	    pane.setSpacing(15);
	    
		Scene scene = new Scene(layout,300,100);
		stage.setScene(scene);
		stage.show();
	}
    

    
    
}

