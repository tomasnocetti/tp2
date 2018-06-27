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
				"Se pueden colocar tantas cartas de magia y trampa como se quiera, pero solo una invocacion de monstruo (no se puede cambiar la posicion del monstruo "
				+ " ni voltearla el mismo turno que es colocada en el campo).\n" + 
				"");
				Button boton1 = new Button("POSICION ATAQUE");
        	    boton1.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAccionHandlerEvent1 = new BotonAccionHandlerEvent(ControladorDeJuego.COLOCAR_ATAQUE); 
        	    boton1.setOnAction(botonAccionHandlerEvent1);
				Button boton2 = new Button("POSICION DEFENSA");
        	    boton2.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAccionHandlerEvent2 = new BotonAccionHandlerEvent(ControladorDeJuego.COLOCAR_DEFENSA); 
        	    boton2.setOnAction(botonAccionHandlerEvent2);
				Button boton3 = new Button("BOCA ABAJO");
        	    boton3.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAccionHandlerEvent3 = new BotonAccionHandlerEvent(ControladorDeJuego.BOCA_ABAJO); 
        	    boton3.setOnAction(botonAccionHandlerEvent3);
				Button boton4 = new Button("BOCA ARRIBA");
        	    boton4.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAccionHandlerEvent4 = new BotonAccionHandlerEvent(ControladorDeJuego.BOCA_ARRIBA); 
        	    boton4.setOnAction(botonAccionHandlerEvent4);
        	    contenedorInformacionJuego.getChildren().addAll(boton1,boton2,boton3,boton4);
//        	    contenedorInformacionJuego.setMargin(this.getChildren().get(0),new Insets(5));
//        	    contenedorInformacionJuego.setMargin(this.getChildren().get(1),new Insets(5));
//        	    contenedorInformacionJuego.setMargin(this.getChildren().get(2),new Insets(5));
//        	    contenedorInformacionJuego.setMargin(this.getChildren().get(3),new Insets(5));
        	    break;
			case 2:
				t.setText("En esta fase, se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez.");
                Button boton = new Button("ATACAR");
        	    boton.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAtacarHandlerEvent = new BotonAccionHandlerEvent(ControladorDeJuego.MODO_ATAQUE_1);
        	    boton.setOnAction(botonAtacarHandlerEvent);
        	    Button botonAtacarJugador = new Button("ATACAR JUGADOR");
        	    botonAtacarJugador.getStyleClass().add("info-window-button");
        	    BotonAccionHandlerEvent botonAtacarHandlerEvent2 = new BotonAccionHandlerEvent(ControladorDeJuego.ATAQUE_JUGADOR);
        	    botonAtacarJugador.setOnAction(botonAtacarHandlerEvent2);
        	    this.contenedorInformacionJuego.getChildren().addAll(boton, botonAtacarJugador);
				break;
			case 3:
				t.setText("En esta fase, se pueden activar cartas de magia.");
//				Button botonMag = new Button("ACTIVAR MAGICA");
//				botonMag.getStyleClass().add("info-window-button");
////        	    BotonAccionHandlerEvent botonAccionHandlerEvent = new BotonAccionHandlerEvent(ControladorDeJuego.ACTIVAR_MAGICA); 
////        	    boton.setOnAction(botonAccionHandlerEvent);
//				 contenedorInformacionJuego.getChildren().add(botonMag);
			    break;
			case 4:
				t.setText("CAMBIO DE TURNO!");
                break;
		}
	    
	    t.setWrappingWidth(300);
	    t.minWidth(300);
		this.contenedorInformacionJuego.getChildren().add(0,t);
		this.contenedorInformacionJuego.setSpacing(10);	
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
	}

	public void mostrarSeccionAtaque() {
		this.contenedorInformacionJuego.getChildren().clear();
		Text t = new Text();
		t.setText("Primero selecciona una carta de la Zona Monstruos para realizar el ataque y luego, una del "
				+ "contrincante para atacar");
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
	
	public void mostrarSeccionAccionGenerica(String accion) { 
		this.contenedorInformacionJuego.getChildren().clear();
		Text t = new Text();
		t.setText("Selecciona la carta de tu campo a la cual le queres aplicar la accion: " + accion);
		t.setWrappingWidth(300);
	    t.minWidth(300);
	    t.setFont(Font.font ("Verdana", 13));
	    t.setFill(Color.RED);
	    
	    Button boton = new Button("Cancelar");
	    BotonCancelarHandler handler = new BotonCancelarHandler (); 
	    boton.setOnAction(handler);
	    boton.getStyleClass().add("info-window-button");
		this.contenedorInformacionJuego.getChildren().addAll(t, boton);
	}

	public void mostrarSeccionFinDeJuego(String nombre, String razon) {
		this.contenedorInformacionJuego.getChildren().clear();
		Text t = new Text();
		t.setText("El juego se ha terminado ! Razon: " + razon);
		t.setWrappingWidth(300);
	    t.minWidth(300);
	    t.setFont(Font.font ("Verdana", 13));
	    Text t2 = new Text();
		t2.setText("Ganador: " + nombre);
		t2.setWrappingWidth(300);
	    t2.minWidth(300);
	    t2.setFont(Font.font ("Verdana", 20));
	    System.out.println("ACA TERMINADO EL JUEGO");
	  
		this.contenedorInformacionJuego.getChildren().addAll(t, t2);
	}
	
	public void mensajeDeError(String mensaje) {
		this.contenedorInformacionJuego.getChildren().clear();
	    Text t = new Text();
		t.setText(mensaje);
		t.setWrappingWidth(300);
	    t.minWidth(300);
	   
	    Button boton = new Button("OK");
	    BotonCancelarHandler handler = new BotonCancelarHandler (); 
	    boton.setOnAction(handler);
	    boton.getStyleClass().add("info-window-button");
		this.contenedorInformacionJuego.getChildren().addAll(t, boton);
	}
}
