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
		// TODO Auto-generated method stub
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		CartaMagica carta = (CartaMagica) contenedor.obtenerCarta();
		Jugador jugador_actual = Juego.ObtenerJuego().jugadorActual();
		Jugador jugador_oponente = Juego.ObtenerJuego().jugadorOponente();
		int fasePermitida = 3;
			if(carta.obtenerJugador().equals(jugador_actual) && (Juego.ObtenerJuego().iFaseActual()) == fasePermitida) {
				carta.colocarBocaArriba(jugador_oponente);
				controlador.dibujar();
				this.contenedor.setStyle("-fx-background-color: red");
				controlador.dibujar();
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				carta.enviarAlCementerio();
				controlador.dibujar();	
			}
			
//		controlador.dibujar();

//		carta.activar(jugador_actual);
//		controlador.dibujar();
	}
}