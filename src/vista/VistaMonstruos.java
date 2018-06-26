package vista;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import vista.eventHandlers.OnDragEnteredContenedor;
import vista.eventHandlers.OnDragExitedContenedor;
import vista.eventHandlers.OnDragOverContenedor;

public class VistaMonstruos extends GridPane{
	
	public VistaMonstruos(int num_jugador) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("gridPane-cartas");
		this.setAlignment(Pos.CENTER);
		
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);

		ZonaDeCartasMonstruos zona = jugador.obtenerZonaMonstruos();
		Hashtable<Integer, Carta> cartas = zona.obtenerCartasMonstruos();
		
		
		for(int i = 0; i < 5; i++) {
			if(cartas.containsKey(i)) {
				ContenedorCarta contenedor = new ContenedorCarta(cartas.get(i));
				contenedor.setId(String.valueOf(i));
				this.add(contenedor, i , 0);
			}else {
				ContenedorCartaVacia contenedor = new ContenedorCartaVacia();
				OnDragEnteredContenedor event = new OnDragEnteredContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragEntered(event);
				OnDragExitedContenedor event2 = new OnDragExitedContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragExited(event2);
				OnDragOverContenedor event3 = new OnDragOverContenedor(CartaMonstruo.class, contenedor, 1);
				contenedor.setOnDragOver(event3);
				
				contenedor.setId(String.valueOf(i));
				this.add(contenedor, i , 0);
			}
		}
	}
}
