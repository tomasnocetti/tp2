package vista;

import vista.eventHandlers.BotonJuegoTerminadoEventHandler;
import vista.eventHandlers.BotonReiniciarEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VentanaFinDeJuego {
	
	public static final String DOBLE_BARRA = "//";
	
	public void display(String nombre,Stage stage,String motivo) {
		
		Stage stage1 = new Stage();
		
		stage1.setTitle("Fin de juego");
		stage1.initModality(Modality.APPLICATION_MODAL);
		StackPane layout = new StackPane();
	    layout.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		layout.getStyleClass().add("stackPane");
		layout.setPrefSize(500,500);
		
		
		VBox pane = new VBox();
		layout.getChildren().add(pane);
		
		Text text2 = new Text(5,5, "El Jugador " + nombre + " a ganado");
		text2.setFont(Font.font("Verdana", 50));
	    pane.getChildren().add(text2);
	    
	    Text text3 = new Text(5,5, "Motivo: " + motivo);
		text3.setFont(Font.font("Verdana", 50));
	    pane.getChildren().add(text3);
	    
	    HBox contenedorBotones = new HBox();
	    contenedorBotones.setSpacing(10);
	    contenedorBotones.setAlignment(Pos.CENTER);
	    pane.getChildren().add(contenedorBotones);
		
		Button botonSalir = new Button("Salir");
		botonSalir.setOnAction(new BotonJuegoTerminadoEventHandler(stage,stage1));
		contenedorBotones.getChildren().add(botonSalir);
	    botonSalir.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		botonSalir.getStyleClass().add("button-inicio");
		
		Button botonReiniciar = new Button("Reiniciar");
		botonReiniciar.setOnAction(new BotonReiniciarEventHandler(stage,stage1));
		contenedorBotones.getChildren().add(botonReiniciar);
	    botonReiniciar.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		botonReiniciar.getStyleClass().add("button-inicio");
		
		pane.setAlignment(Pos.CENTER);
	    pane.setSpacing(15);
	    
//		Scene scene = new Scene(layout,300,100);
		Scene sceneJuego = stage.getScene();
		LayoutContenedorJuegoTotal stackPane = (LayoutContenedorJuegoTotal) sceneJuego.getRoot();
		stackPane.getChildren().add(layout);
		stackPane.setPrefSize(500, 500);
	}
}

