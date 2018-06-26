package vista.eventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class OnMouseClickedContenedor implements EventHandler< MouseEvent>{
	
	public OnMouseClickedContenedor() {
		
	} 
	
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println("EN CLICK DE CONTENEDOR");
		
	}

}
