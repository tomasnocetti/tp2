package vista;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import vista.eventHandlers.OnDragDroppedContenedor;
import vista.eventHandlers.OnDragEnteredContenedor;
import vista.eventHandlers.OnDragExitedContenedor;
import vista.eventHandlers.OnDragOverContenedor;

public class VistaCampo extends HBox{

	private int num_jugador;
	private Jugador jugador;

	public VistaCampo(int num_jugador) {
		super();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		this.jugador = jugador;
		this.dibujar();
		this.num_jugador = num_jugador;
	}
	
	public void dibujar() {
		this.getChildren().clear();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);

		ZonaDeCartasDeCampo zona = jugador.obtenerZonaCartasDeCampo();
		Collection<Carta> cartas = zona.obtenerCartas();
		
		CartaCampo carta = null;

		Iterator<Carta> iter = cartas.iterator();
		while(iter.hasNext()) {
			carta = (CartaCampo) iter.next();
		}
		
		if(carta != null) {
			ContenedorCarta contenedor = new ContenedorCarta(carta);
			contenedor.setPrefHeight(180);
			contenedor.setPrefWidth(150);
			this.getChildren().add(contenedor);
		} else {
			ContenedorCartaVacia contenedor = new ContenedorCartaVacia(jugador, "Campo");
			contenedor.setId(String.valueOf(0));
			OnDragEnteredContenedor event = new OnDragEnteredContenedor(CartaCampo.class, contenedor, 1);
			contenedor.setOnDragEntered(event);
			OnDragExitedContenedor event2 = new OnDragExitedContenedor(CartaCampo.class, contenedor, 1);
			contenedor.setOnDragExited(event2);
			OnDragOverContenedor event3 = new OnDragOverContenedor(CartaCampo.class, contenedor, 1);
			contenedor.setOnDragOver(event3);
			OnDragDroppedContenedor event4 = new OnDragDroppedContenedor(CartaCampo.class, contenedor, 1);
			contenedor.setOnDragDropped(event4);
			this.getChildren().add(contenedor);
		}
		this.setAlignment(Pos.CENTER);
	}
}
