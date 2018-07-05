package vista.eventHandlers;

import java.util.concurrent.TimeUnit;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMagica;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorCarta;

public class OnMouseClickedMagica implements EventHandler<MouseEvent> {
	
	private ContenedorCarta contenedor;
	
	public OnMouseClickedMagica(ContenedorCarta contenedor) {
		this.contenedor = contenedor;
	} 
	
	@Override
	public void handle(MouseEvent event) {
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		CartaMagica carta = (CartaMagica) contenedor.obtenerCarta();
		Jugador jugador_actual = Juego.ObtenerJuego().jugadorActual();
		Jugador jugador_oponente = Juego.ObtenerJuego().jugadorOponente();

		switch(controlador.obtenerAccion()) {
			case "ACTIVAR_MAGICA":
				if(! jugador_actual.equals(carta.obtenerJugador())) return;
				carta.colocarBocaArriba(jugador_oponente);
				carta.enviarAlCementerio();
				controlador.dibujar();
				controlador.cancelarAccion();
				break;
		}		
	}
}