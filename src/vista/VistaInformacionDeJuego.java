package vista;

import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import vista.eventHandlers.BotonCancelarHandler;
import vista.eventHandlers.BotonContinuarFaseEventHandler;
import vista.eventHandlers.ControladorDeJuego;

public class VistaInformacionDeJuego extends VBox {
	
	private LayoutContenedorJuego layoutContenedorJuego;
	private VBox contenedorInformacionJuego;
	
	public class VistaInformacionDeJuegoObserver implements Observer { 
		private VistaInformacionDeJuego vista;
		
		public VistaInformacionDeJuegoObserver(VistaInformacionDeJuego vista){
			this.vista = vista;
		}
		
		public void update(Observable observable, Object args) {
			ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
			controlador.dibujar();
	    }
	}
	
	public VistaInformacionDeJuego(LayoutContenedorJuego layoutContenedorJuego) {
		super();
	
		Juego juego = Juego.ObtenerJuego();
		VistaInformacionDeJuegoObserver vistaInformacionCartaObserver = new VistaInformacionDeJuegoObserver(this);
		juego.addObserver(vistaInformacionCartaObserver);
		
		this.layoutContenedorJuego = layoutContenedorJuego;
		
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("informacion");
	
		Button botonContinuar = new Button("Continuar");
		botonContinuar.prefWidth(350);
		botonContinuar.maxWidth(350);
		botonContinuar.setMinWidth(350);
		
		BotonContinuarFaseEventHandler botonContinuarHandler = new BotonContinuarFaseEventHandler(layoutContenedorJuego);
		botonContinuar.setOnAction(botonContinuarHandler);
		
		this.contenedorInformacionJuego = new VBox();
		this.contenedorInformacionJuego.setStyle("-fx-background-color: #FFFFFF;");
		this.contenedorInformacionJuego.setPadding(new Insets(10));
		this.getChildren().add(botonContinuar);
		this.getChildren().add(this.contenedorInformacionJuego);
	}
	
	public void dibujar() {
		this.contenedorInformacionJuego.getChildren().clear();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.jugadorActual();
		
		Text t = new Text();
		switch(juego.iFaseActual()) {
			case 0:
				t.setText("Hay una nueva carta en la mano !");
                break;
			case 1:
				t.setText("En esta fase, es el momento de poner cartas en el campo. \n" + 
				"Se pueden colocar tantas cartas de magia y trampa como se quiera, pero solo una invocación de monstruo (no se puede cambiar la posición del monstruo ni voltearla el mismo turno que es colocada en el campo).\n" + 
				"");
                break;
			case 2:
				t.setText("En esta fase, se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez.");
                break;
			case 3:
				t.setText("En esta fase, se pueden activar cartas de magia.");
			    break;
			case 4:
				t.setText("CAMBIO DE TURNO!");
                break;
		}
	    
	    t.setWrappingWidth(300);
	    t.minWidth(300);
		this.contenedorInformacionJuego.getChildren().add(t);
		
	}

	public void mostrarSeccionSacrificios(String numeroNecesario) {
		this.contenedorInformacionJuego.getChildren().clear();
		Text t = new Text();
		t.setText("Selecciona " + numeroNecesario + " cartas de la Zona Monstruos para sacrificar!");
		t.setWrappingWidth(300);
	    t.minWidth(300);
	    t.setFont(Font.font ("Verdana", 16));
	    t.setFill(Color.RED);
	    
	    Button boton = new Button("Cancelar");
	    BotonCancelarHandler handler = new BotonCancelarHandler (); 
	    boton.setOnAction(handler);
	    boton.getStyleClass().add("info-window-button");
		this.contenedorInformacionJuego.getChildren().addAll(t, boton);
		this.contenedorInformacionJuego.setSpacing(10);		
	}
	
}
