package vista;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BotonHoverEventHandler implements EventHandler<MouseEvent>{
	
	private Button boton;
	public BotonHoverEventHandler(Button boton) {
		this.boton = boton;
	}
	@Override
	public void handle(MouseEvent event) {
		boton.setCursor(Cursor.HAND); //Change cursor to hand
	}

}
