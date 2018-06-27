package vista.eventHandlers;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCancelarHandler implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent arg0) {
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		controlador.cancelarAccion();
	}
	
}
