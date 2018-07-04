package vista;

import java.util.Observable;
import java.util.Observer;

import vista.VistaPuntosDeVida.PuntosDeVidaObserver;

import fiuba.algo3.tp2.Juego;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaTableroDeJuego extends VBox {
	
	private VistaTableroJugador vistaTableroJugador1;
	private VistaTableroJugador vistaTableroJugador2;
	private Stage stage;
	
	public class FinalizacionDeJuegoObserver implements Observer { 
		private VistaTableroDeJuego vista;
		
		public FinalizacionDeJuegoObserver(VistaTableroDeJuego vistaTableroDeJuego) {
			this.vista = vistaTableroDeJuego;
		}
		
		public void update(Observable observable, Object args) {
			this.vista.dibujar();
	    }
	}

	
	public VistaTableroDeJuego(Stage stage) {
		super();
		
		this.vistaTableroJugador1 = new VistaTableroJugador(true,0);
		this.vistaTableroJugador2 = new VistaTableroJugador(false,1);
		this.stage = stage;
		
		FinalizacionDeJuegoObserver finalizacionDeJuegoObserver = new FinalizacionDeJuegoObserver(this);
		Juego.ObtenerJuego().addObserver(finalizacionDeJuegoObserver);

		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("tablero");
		Rectangle rectanguloSeparador = new Rectangle();
		rectanguloSeparador.setFill(Color.YELLOW);
		rectanguloSeparador.setHeight(15);
		rectanguloSeparador.setWidth(1500);
		this.getChildren().addAll(vistaTableroJugador1,rectanguloSeparador,vistaTableroJugador2);	
	}


	@SuppressWarnings("static-access")
	public void dibujar() {
		this.vistaTableroJugador1.dibujar();
		this.vistaTableroJugador2.dibujar();
	}
}
