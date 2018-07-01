package vista;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	public LayoutContenedorCompletarNombres(final Stage stage, final MediaPlayer mediaPlayer) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("fondoNombres");
		
		final VBox vbox1 = new VBox(20);
		final VBox vbox2 = new VBox();
		final VBox vbox3 = new VBox();
		
		vbox1.setPrefSize(300,300);
		vbox2.setPrefSize(300,300);
		vbox3.setPrefSize(500,300);
		
		Text textoNombre1= new Text(300, 300, "NOMBRE JUGADOR 1");
		textoNombre1.setFill(Color.DARKORANGE);
		textoNombre1.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 30));
	    final Light.Distant light1 = new Light.Distant();
	    light1.setAzimuth(-135.0);
	    final Lighting lighting1 = new Lighting();
	    lighting1.setLight(light1);
	    lighting1.setSurfaceScale(9.0);
		vbox1.getChildren().add(textoNombre1);
		
		final TextField name1 = new TextField();
	    name1.setPromptText("Enter name player one");
	    name1.setPrefColumnCount(10);
	    name1.setMaxWidth(300);
	    GridPane.setConstraints(name1, 0, 0);
	    vbox1.getChildren().add(name1);
	    
		Text textoNombre2= new Text(300, 300, "NOMBRE JUGADOR 2");
		textoNombre2.setFill(Color.DARKORANGE);
		textoNombre2.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 30));
	    final Light.Distant light2 = new Light.Distant();
	    light1.setAzimuth(-135.0);
	    final Lighting lighting2 = new Lighting();
	    lighting2.setLight(light2);
	    lighting2.setSurfaceScale(9.0);
		vbox1.getChildren().add(textoNombre2);
	    
		final TextField name2 = new TextField();
	    name2.setPromptText("Enter name player two");
	    name2.setPrefColumnCount(10);
	    name2.setMaxWidth(300);
	    GridPane.setConstraints(name2, 0, 0);
	    vbox1.getChildren().add(name2);
	    
	    final Text txtState = new Text();
	    
	    final Button buttonJugar = new Button("CONTINUAR");
	    buttonJugar.getStyleClass().add("button-inicio");
	    GridPane.setConstraints(buttonJugar, 1, 0);
	    vbox2.getChildren().add(buttonJugar);
	    buttonJugar.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
               
                if(name2.getText().isEmpty() || name1.getText().isEmpty()){
                    txtState.setText("Introducir nombres de ambos jugadores");
                    txtState.setFill(Color.RED);
                    txtState.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 25));
                    vbox1.getChildren().add(txtState);
                }
                else{
                	buttonJugar.setOnAction(new BotonJugarEventHandler(stage, mediaPlayer,name1.getText(),name2.getText()));
                }
            }
        });
	    
	    vbox1.setAlignment(Pos.TOP_LEFT);
	    vbox1.setPadding(new Insets(100));
	    vbox2.setAlignment(Pos.TOP_LEFT);
	    vbox2.setPadding(new Insets(100));
	    vbox3.setAlignment(Pos.TOP_LEFT);
	    vbox3.setPadding(new Insets(120));
	    
	    this.getChildren().add(vbox3);
	    this.getChildren().add(vbox1);
		this.getChildren().add(vbox2);
		
		this.setAlignment(Pos.TOP_LEFT);
	    this.setSpacing(15);
	}
}
