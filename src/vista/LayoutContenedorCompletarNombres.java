package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.eventHandlers.BotonJugarEventHandler;

public class LayoutContenedorCompletarNombres extends VBox{
	
	public LayoutContenedorCompletarNombres(Stage stage, Scene sceneJuego, MediaPlayer mediaPlayer) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("fondoNombres");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(90);
		
		TextField name = new TextField();
	    name.setPromptText("Enter name player one");
	    name.setPrefColumnCount(10);
	    name.setMaxWidth(300);
	    GridPane.setConstraints(name, 0, 0);
	    grid.getChildren().add(name);
	    
	    Button buttonJugar = new Button("Jugar");
	    GridPane.setConstraints(buttonJugar, 1, 0);
	    grid.getChildren().add(buttonJugar);
	    buttonJugar.setOnAction(new BotonJugarEventHandler(stage, sceneJuego, mediaPlayer));
	    
	    
	    Button clear = new Button("Borrar");
	    GridPane.setConstraints(clear, 1, 1);
	    grid.getChildren().add(clear);
	    
	    Label label = new Label();
	    this.getChildren().addAll(label, name);
		this.getChildren().add(grid);
		
		this.setAlignment(Pos.CENTER);
	    this.setSpacing(15);
	}
}
