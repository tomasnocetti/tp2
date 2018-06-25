package vista;

import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import javafx.scene.control.Button;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.eventHandlers.BotonContinuarFaseEventHandler;

public class VistaInformacionDeCarta extends VBox {
	
	private LayoutContenedorJuego layoutContenedorJuego;
	
	public class VistaInformacionCartaObserver implements Observer { 
		private VistaInformacionDeCarta vista;
		
		public void update(Observable observable, Object args) {
			System.out.println("ACTUALIZAR VISTA INFORMACION");
			
			
	    }
	}
	
	public VistaInformacionDeCarta(LayoutContenedorJuego layoutContenedorJuego) {
		super();
	
		Juego juego = Juego.ObtenerJuego();
		VistaInformacionCartaObserver vistaInformacionCartaObserver = new VistaInformacionCartaObserver();
		juego.addObserver(vistaInformacionCartaObserver);
		
		this.layoutContenedorJuego = layoutContenedorJuego;
		
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("informacion");
	
		
		Button botonContinuar = new Button("Continuar Fase");
		BotonContinuarFaseEventHandler botonContinuarHandler = new BotonContinuarFaseEventHandler(layoutContenedorJuego);
		botonContinuar.setOnAction(botonContinuarHandler);
		this.getChildren().add(botonContinuar);
		Text t = new Text();
		this.getChildren().add(t);
		this.getChildren().clear();
		
		t.setText("This is a text sample");
		this.setPrefWidth(300);
	}
}
