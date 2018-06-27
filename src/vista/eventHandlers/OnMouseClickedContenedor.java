package vista.eventHandlers;

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
		switch(controlador.obtenerAccion()) {
		case "SACRIFICIO":
			this.contenedor.setStyle("-fx-background-color: red");
			controlador.agregarCartaDeSacrificio((CartaMonstruo) contenedor.obtenerCarta());
            break;
        }
		
		System.out.println("EN CLICK DE CONTENEDOR");
		
	}

}
