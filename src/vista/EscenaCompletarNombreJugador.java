package vista;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;

public class EscenaCompletarNombreJugador extends Application{
	
	private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Completar info");
		
		mediaPlayer = new MediaPlayer(new Media(new File("src/vista/YugiohTema.wav").toURI().toString()));
		mediaPlayer.play();
	    
		StackPane layout = new StackPane();
		Scene scene = new Scene(layout,500,500);
		scene.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
		stage.show();
		
		VBox pane = new VBox();
		layout.getChildren().add(pane);
		layout.getStyleClass().add("fondoNombres");
		pane.getStyleClass().add("fondoNombres");
		
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
	    
	    Button submit = new Button("Siguiente");
	    GridPane.setConstraints(submit, 1, 0);
	    grid.getChildren().add(submit);
	    
	    
	    Button clear = new Button("Borrar");
	    GridPane.setConstraints(clear, 1, 1);
	    grid.getChildren().add(clear);
	    
	    Label label = new Label();
	    pane.getChildren().addAll(label, name);
		pane.getChildren().add(grid);
		
		pane.setAlignment(Pos.CENTER);
	    pane.setSpacing(15);
	}
	
	
	

}
