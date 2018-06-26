package vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
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

public class VistaPuntosDeVida extends VBox {
	
	private BorderPane layoutContenedorJuego;
	private VBox boxJugador1;
	private VBox boxJugador2;
	
	
	public class PuntosDeVidaObserver implements Observer { 
		private VistaPuntosDeVida vista;
		
		public PuntosDeVidaObserver(VistaPuntosDeVida vistaPuntosDeVida) {
			this.vista = vistaPuntosDeVida;
		}
		
		public void update(Observable observable, Object args) {
			this.vista.dibujar();
	    }
	}
	
	public void dibujar() {
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
		this.modificarVBoxJugador(this.boxJugador1,jugador1);
		this.modificarVBoxJugador(this.boxJugador2,jugador2);
	}
	
	public VistaPuntosDeVida(BorderPane layoutContenedorJuego) {
		super();
		
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
		PuntosDeVidaObserver puntosDeVidaObserver1 = new PuntosDeVidaObserver(this);
		jugador1.addObserver(puntosDeVidaObserver1);
		PuntosDeVidaObserver puntosDeVidaObserver2 = new PuntosDeVidaObserver(this);
		jugador2.addObserver(puntosDeVidaObserver2);
		
		this.layoutContenedorJuego = layoutContenedorJuego;
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("fondoPuntosDeVida");
		this.setSpacing(20);
		this.boxJugador1 = new VBox();
		this.boxJugador1.setSpacing(10);
		this.boxJugador2 = new VBox();
		this.boxJugador2.setSpacing(10);
		this.setSpacing(400);
		this.getChildren().addAll(this.boxJugador1,this.boxJugador2);
		this.dibujar();
		this.setPrefWidth(70);
	}
	
	private void modificarVBoxJugador(VBox box,Jugador jugador) {
		int puntosDeVida = jugador.obtenerPuntosDeVida();
		box.getChildren().clear();
		box.getChildren().add(this.darTextoNombreJugador(jugador.obtenerNombre()));
		Text text1 = this.darTextoNombreJugador(""+puntosDeVida);
		box.getChildren().add(text1);
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
