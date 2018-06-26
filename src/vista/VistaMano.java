package vista;

import java.util.Collection;
import java.util.Iterator;
import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import vista.eventHandlers.ApretarEnImagenEventHandler;
import javafx.scene.text.Text;
import vista.eventHandlers.ControladorDeJuego;

public class VistaMano extends HBox{
	

	public static final String DOBLE_BARRA = "//";
	
	public VistaMano() {
		super();	    
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("vistaMano");
		this.setAlignment(Pos.CENTER);
	}
	
	public void dibujar() {
		this.getChildren().clear();
		System.out.println("REDIBUJAR TABLERO");
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.jugadorActual();
		Collection<Carta> cartas = jugador.obtenerCartasEnMano();
		this.getChildren().clear();
		Iterator<Carta> i = cartas.iterator();

		while (i.hasNext()) {
			Carta carta = i.next();
			ContenedorCarta contenedor = new ContenedorCarta(carta);
			contenedor.setOnDragDetected(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent event) {

			        ControladorDeJuego.setDraggedCard(carta);
			        Dragboard db = contenedor.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			        ClipboardContent content = new ClipboardContent();
			        content.put(Carta.Binding, carta);
			        db.setContent(content);			  
			        
			        event.consume();
			    }
			});
			this.getChildren().add(contenedor);
			VistaMano.setMargin(contenedor,new Insets(10));
		}
	}
}
