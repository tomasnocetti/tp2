package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.eventHandlers.ControladorDeJuego;

public class BotonAccionHandlerEvent implements EventHandler<ActionEvent> {

	private String accion;

	public BotonAccionHandlerEvent(String accion) {
		this.accion = accion;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
		controlador.iniciarAccion(this.accion);
	}
	
}
