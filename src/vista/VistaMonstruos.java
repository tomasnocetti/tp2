package vista;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import vista.eventHandlers.OnDragDroppedContenedor;
import vista.eventHandlers.OnDragEnteredContenedor;
import vista.eventHandlers.OnDragExitedContenedor;
import vista.eventHandlers.OnDragOverContenedor;
import vista.eventHandlers.OnMouseClickedContenedor;

public class VistaMonstruos extends GridPane{
	
	private Integer num_jugador;
	
	public class VistaMonstruosObserver implements Observer { 
		private VistaMonstruos vista;
		
		public VistaMonstruosObserver(VistaMonstruos vista){
			this.vista = vista;
		}
		
		public void update(Observable observable, Object args) {
			vista.dibujar();
	    }
	}
	
	public VistaMonstruos(int num_jugador) {
		super();
		this.num_jugador = num_jugador;
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
//		this.setMaxHeight(200);
//		this.setMaxWidth(150);
		this.setPrefHeight(200);
		this.setPrefWidth(150);
//		this.setMinHeight(200);
//		this.setMinWidth(150);
	}

	public void dibujar() {
		this.getChildren().clear();
		
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);

		ZonaDeCartasMonstruos zona = jugador.obtenerZonaMonstruos();
		Hashtable<Integer, Carta> cartas = zona.obtenerCartasMonstruos();
 
		for(int i = 0; i < 5; i++) {
			if(cartas.containsKey(i)) {
				ContenedorCarta contenedor = new ContenedorCarta(cartas.get(i));
				OnMouseClickedContenedor evento = new OnMouseClickedContenedor(contenedor);
				contenedor.setId(String.valueOf(i));
				contenedor.setOnMouseClicked(evento);
				this.add(contenedor, i , 0);
			}else {
				ContenedorCartaVacia contenedor = new ContenedorCartaVacia(jugador, "Monstruo");
				contenedor.setId(String.valueOf(i));
				OnDragEnteredContenedor event = new OnDragEnteredContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragEntered(event);
				OnDragExitedContenedor event2 = new OnDragExitedContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragExited(event2);
				OnDragOverContenedor event3 = new OnDragOverContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragOver(event3);
				OnDragDroppedContenedor event4 = new OnDragDroppedContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragDropped(event4);
				
				
				this.add(contenedor, i , 0);
			}
		}
	}
}
