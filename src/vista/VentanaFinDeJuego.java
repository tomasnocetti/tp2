package vista;

import vista.eventHandlers.BotonJugarEventHandler;
import vista.eventHandlers.BotonJuegoTerminadoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VentanaFinDeJuego {
	
	public static final String DOBLE_BARRA = "//";
	
	public static void display(String nombre,Stage stage) {
		
		Stage stage1 = new Stage();
		
		stage1.setTitle("Fin de juego");
		stage1.initModality(Modality.APPLICATION_MODAL);
		StackPane layout = new StackPane();
		
		VBox pane = new VBox();
		layout.getChildren().add(pane);
		
		Text text2 = new Text(5,5, "El Jugador " + nombre + " a ganado");
	    pane.getChildren().add(text2);
		
		Button boton = new Button("Salir");
		boton.setOnAction(new BotonJuegoTerminadoEventHandler(stage,stage1));
		pane.getChildren().add(boton);
		
		pane.setAlignment(Pos.CENTER);
	    pane.setSpacing(15);
	    
		Scene scene = new Scene(layout,300,100);
		stage1.setScene(scene);
		stage1.show();
	}
    

    
    
}

