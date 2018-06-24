package vista;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vista.eventHandlers.BotonJugarEventHandler;

public class LayoutContenedorCompletarNombres extends VBox{
	
	public LayoutContenedorCompletarNombres(Stage stage, Scene sceneJuego, MediaPlayer mediaPlayer) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("fondoNombres");
		
		
		
//		GridPane grid = new GridPane();
//		grid.setPadding(new Insets(10, 10, 10, 10));
//		grid.setVgap(10);
//		grid.setHgap(90);
		
		VBox vbox1 = new VBox(20);
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();
		
		vbox1.setPrefSize(300,300);
		vbox2.setPrefSize(300,300);
		vbox3.setPrefSize(500,300);
		
		Text titulo = new Text(300, 300, "Bienvenidos a YuGiOh");
		titulo.setFill(Color.DARKORANGE);
		titulo.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 60));
	    final Light.Distant light = new Light.Distant();
	    light.setAzimuth(-135.0);
	    final Lighting lighting = new Lighting();
	    lighting.setLight(light);
	    lighting.setSurfaceScale(9.0);
		vbox3.getChildren().add(titulo);
		
		TextField name1 = new TextField();
	    name1.setPromptText("Enter name player one");
	    name1.setPrefColumnCount(10);
	    name1.setMaxWidth(300);
	    GridPane.setConstraints(name1, 0, 0);
	    vbox1.getChildren().add(name1);
	    
		TextField name2 = new TextField();
	    name2.setPromptText("Enter name player two");
	    name2.setPrefColumnCount(10);
	    name2.setMaxWidth(300);
	    GridPane.setConstraints(name2, 0, 0);
	    vbox1.getChildren().add(name2);
	    
//	    BooleanBinding textField1Valid = Bindings.createBooleanBinding(name2.textProperty());
//	    BooleanBinding textField2Valid = Bindings.createBooleanBinding(name2.textProperty());
//	    buttonJugar.disableProperty().bind(textField1Valid.not().or(textField2Valid.not()));
	    
	    Button buttonJugar = new Button("Jugar");
	    GridPane.setConstraints(buttonJugar, 1, 0);
	    vbox2.getChildren().add(buttonJugar);
	    buttonJugar.setOnAction(new BotonJugarEventHandler(stage, sceneJuego, mediaPlayer));
	    
	    //Label label = new Label();
	    //this.getChildren().addAll(label, name);
	    vbox1.setAlignment(Pos.CENTER);
	    vbox2.setAlignment(Pos.CENTER);
	    vbox3.setAlignment(Pos.CENTER);
	    
	    this.getChildren().add(vbox3);
	    this.getChildren().add(vbox1);
		this.getChildren().add(vbox2);
		
		this.setAlignment(Pos.CENTER);
	    this.setSpacing(15);
	}
}
