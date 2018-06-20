package vista;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
//import javafx.scene.input.TouchEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CuadradoEventHandler implements EventHandler<MouseEvent> {
	
	private Rectangle cuadrado;
	private Color colorNuevo;
	
	public CuadradoEventHandler(Rectangle cuadrado,Color colorNuevo) {
		this.cuadrado = cuadrado;
		this.colorNuevo = colorNuevo;
	}
	
	public void handle(MouseEvent arg0) {
		Color aux = (Color) this.cuadrado.getFill();
		this.cuadrado.setFill(this.colorNuevo);
		this.colorNuevo = aux;
	}

}
