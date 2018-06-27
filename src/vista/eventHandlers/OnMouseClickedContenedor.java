package vista.eventHandlers;

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
				break;
			case "COLOCAR_ATAQUE":
				carta.colocarEnAccionDeAtaque();
				controlador.iniciarAccion("NORMAL");
				System.out.println("colocarAtaque");
				controlador.dibujar();
				break;
			case "COLOCAR_DEFENSA":
				carta.colocarEnAccionDeDefensa();
				controlador.iniciarAccion("NORMAL");
				controlador.dibujar();
				break;
			case "BOCA_ABAJO":
				carta.colocarBocaAbajo();
				controlador.iniciarAccion("NORMAL");
				controlador.dibujar();
				break;
			case "BOCA_ARRIBA":
				carta.colocarBocaArriba();
				controlador.iniciarAccion("NORMAL");
				controlador.dibujar();
				break;
		}
		
		System.out.println("EN CLICK DE CONTENEDOR");
		
	}

}
