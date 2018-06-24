package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VistaPuntosDeVida extends HBox {
	
	private BorderPane layoutContenedorJuego;
	
	public VistaPuntosDeVida(BorderPane layoutContenedorJuego) {
		super();
		this.layoutContenedorJuego = layoutContenedorJuego;
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("fondoPuntosDeVida");
		this.setSpacing(20);
		this.getChildren().add(this.informacionPuntosDeVida("Jugador1"));
		this.getChildren().add(this.informacionPuntosDeVida("Jugador2"));
		this.setPrefWidth(100);
	}
	
	
	
	private HBox informacionPuntosDeVida(String jugador) {
		HBox hbox = new HBox(5);
		Text nombre = this.darTextoNombreJugador(jugador);
		hbox.getChildren().add(nombre);
		return hbox;
		
	}
	
	private Text darTextoNombreJugador(String jugador) {
		Text nombre = new Text(300, 300, jugador);
		nombre.setFill(Color.DARKORANGE);
		nombre.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 30));
	    final Light.Distant light = new Light.Distant();
	    light.setAzimuth(-135.0);
	    final Lighting lighting = new Lighting();
	    lighting.setLight(light);
	    lighting.setSurfaceScale(9.0);
		return nombre;
	}

	
}
