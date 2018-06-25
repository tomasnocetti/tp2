package vista;

import java.util.Collection;
import java.util.Iterator;
import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import vista.eventHandlers.ApretarEnImagenEventHandler;

public class VistaMano extends HBox{
	

	public static final String DOBLE_BARRA = "//";
	
	public VistaMano() {
		super();	    
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("vistaMano");
		this.setAlignment(Pos.CENTER);
		
		this.dibujar(); 
	}
	
	public void dibujar() {
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.jugadorActual();
		Collection<Carta> cartas = jugador.obtenerCartasEnMano();
		this.getChildren().clear();
		Iterator<Carta> i = cartas.iterator();
		while (i.hasNext()) {
			Carta carta = i.next();
			ContenedorCarta contenedor = new ContenedorCarta(carta);
			this.getChildren().add(contenedor);
			VistaMano.setMargin(contenedor,new Insets(10));
		}
	}
}
