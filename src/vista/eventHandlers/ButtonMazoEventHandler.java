package vista.eventHandlers;


import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tableros.Mazo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vista.VistaMazo;

public class ButtonMazoEventHandler implements EventHandler<ActionEvent> {
	
	private Jugador jugador;
	private VistaMazo vista;
	private int fasePermitida;
	private boolean habilitado;
	private Button button;



	public ButtonMazoEventHandler(int num_jugador, VistaMazo vista,int fasePermitida, Button button) {
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.obtenerJugador(num_jugador);
		this.jugador = jugador;
		this.button = button;
		this.vista = vista;
		this.fasePermitida = fasePermitida;
	}


	@Override
	public void handle(ActionEvent arg0) {
		if(fasePermitida == Juego.ObtenerJuego().iFaseActual() && jugador == Juego.ObtenerJuego().jugadorActual()) {
			jugador.agarrarCarta();
			vista.dibujar();
		}
		
	}

}
