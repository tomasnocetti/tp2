package vista.eventHandlers;

import java.util.concurrent.TimeUnit;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import vista.ContenedorCarta;

public class OnMouseClickedContenedor implements EventHandler< MouseEvent>{
	
	private ContenedorCarta contenedor;
	
	public OnMouseClickedContenedor(ContenedorCarta contenedor) {
		this.contenedor = contenedor;
	} 
	
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		CartaMonstruo carta = (CartaMonstruo) contenedor.obtenerCarta();
		Jugador jugador_actual = Juego.ObtenerJuego().jugadorActual();
		Jugador jugador_oponente = Juego.ObtenerJuego().jugadorOponente();
		
		switch(controlador.obtenerAccion()) {
			case "SACRIFICIO":
				this.contenedor.setStyle("-fx-background-color: red");
				controlador.agregarCartaDeSacrificio(carta);
	            break;
			case "ATAQUE_1":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				this.contenedor.setStyle("-fx-background-color: green");
				controlador.agregarCartaAlAtaque(carta);
				break;
			case "ATAQUE_2":
				if(! jugador_oponente.equals(carta.obtenerJugador())) return;
				this.contenedor.setStyle("-fx-background-color: yellow");
				controlador.agregarCartaAlAtaque(carta);
				controlador.dibujar();
				System.out.println("ATAQUE2");
				break;
			case "ATAQUE_JUGADOR":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				this.contenedor.setStyle("-fx-background-color: yellow");
				controlador.atacarAlJugador(carta);
				controlador.iniciarAccion("NORMAL");
				controlador.dibujar();
				System.out.println("ATAQUE_JUGADOR");
				break;
			case "COLOCAR_ATAQUE":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				carta.colocarEnAccionDeAtaque();
				controlador.cancelarAccion();
				System.out.println("colocarAtaque");
				break;
			case "COLOCAR_DEFENSA":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				carta.colocarEnAccionDeDefensa();
				controlador.cancelarAccion();
				break;
			case "BOCA_ABAJO":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				carta.colocarBocaAbajo();
				controlador.cancelarAccion();
				break;
			case "BOCA_ARRIBA":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				carta.colocarBocaArriba();
				controlador.cancelarAccion();
				break;
		}		
	}
}
