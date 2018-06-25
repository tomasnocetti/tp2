package vista.eventHandlers;

import fiuba.algo3.tp2.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vista.LayoutContenedorJuego;


public class BotonContinuarFaseEventHandler implements EventHandler<ActionEvent> {

	private LayoutContenedorJuego  layoutContenedor = null;
	
	public BotonContinuarFaseEventHandler(LayoutContenedorJuego layoutContenedor) {
		this.layoutContenedor = layoutContenedor;
    }
	
	public void handle(ActionEvent arg0) {
		Juego juego = Juego.ObtenerJuego();
		juego.continuarASiguienteFase();
	}
}
