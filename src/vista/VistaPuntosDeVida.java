package vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaPuntosDeVida extends VBox {
	
	private BorderPane layoutContenedorJuego;
	private VBox boxJugador1;
	private VBox boxJugador2;
	private ProgressBar pBar1;
	private ProgressBar pBar2;
	private int puntosDeVidaViejos1;
	private int puntosDeVidaViejos2;
	
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
		
        Task task = taskCreator(jugador1.obtenerPuntosDeVida(),this.puntosDeVidaViejos1);
        this.pBar1.progressProperty().unbind();
        this.pBar1.progressProperty().bind(task.progressProperty());
        this.puntosDeVidaViejos1 = jugador1.obtenerPuntosDeVida();
        new Thread(task).start();
        
        task = taskCreator(jugador2.obtenerPuntosDeVida(),this.puntosDeVidaViejos2);
        this.pBar2.progressProperty().unbind();
        this.pBar2.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        this.puntosDeVidaViejos2 = jugador2.obtenerPuntosDeVida();
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
		//this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		//this.getStyleClass().add("informacion");
		this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
		this.setSpacing(20);
		
		this.pBar1 = new ProgressBar(8000);
		this.pBar2 = new ProgressBar(8000);
		this.puntosDeVidaViejos1 = 8000;
		this.puntosDeVidaViejos2 = 8000;
		
		
		this.boxJugador1 = new VBox();
		this.boxJugador1.setSpacing(10);
		this.boxJugador1.setAlignment(Pos.BOTTOM_CENTER);
		this.boxJugador2 = new VBox();
		this.boxJugador2.setSpacing(10);
		this.boxJugador2.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(10);
		this.getChildren().add(this.boxJugador1);
		this.getChildren().addAll(this.pBar1);
		
		this.getChildren().add(this.boxJugador2);
		this.getChildren().addAll(this.pBar2);
		this.dibujar();
		this.setPrefWidth(300);
		this.setPrefWidth(getScaleY());
		this.setAlignment(Pos.CENTER_LEFT);
	}
	
	private void modificarVBoxJugador(VBox box,Jugador jugador) {
		final int puntosDeVida = jugador.obtenerPuntosDeVida();
		box.getChildren().clear();
		Text text0 = this.darTextoNombreJugador(jugador.obtenerNombre());
		Text text1 = this.darTextoNombreJugador(""+puntosDeVida);
		Juego juego = Juego.ObtenerJuego();
		Jugador jugadorActual = juego.jugadorActual();
		box.getChildren().add(text0);
		box.getChildren().add(text1);
		if(jugador.equals(jugadorActual)) {
			Text active = new Text();
			active.setText("●");
			active.setFill(Color.RED);
			box.getChildren().add(active);
			
		}
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
	
    //Create a New Task
    private Task taskCreator(final int puntosActuales,final int puntosDeVidaViejos){
        return new Task() {

                   @Override
                   protected Object call() throws Exception {
                       for(float i=puntosDeVidaViejos; i>=puntosActuales;i-=10){
                           Thread.sleep(25);
                           updateProgress(i,8000);
                          
                          }
                       return true;
                   }
               };
    }
}
