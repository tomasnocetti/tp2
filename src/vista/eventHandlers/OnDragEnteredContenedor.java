package vista.eventHandlers;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import vista.ContenedorCarta;
import vista.ContenedorCartaVacia;

public class OnDragEnteredContenedor implements EventHandler<DragEvent>{
	private Class<?> clase = null; 
	private ContenedorCartaVacia contenedor = null;
	private Integer fasePermitida = null; 
	
	public OnDragEnteredContenedor(Class<?> superClass, ContenedorCartaVacia contenedor, Integer fasePermitida) {
		this.clase = superClass;
		this.contenedor = contenedor; 
		this.fasePermitida = fasePermitida;
	}
	
	public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
		Dragboard db = event.getDragboard();
        Carta carta = (Carta) db.getContent(Carta.Binding);
        
        Juego juego = Juego.ObtenerJuego();
        
        if(this.fasePermitida.equals(juego.iFaseActual()) && this.clase.isInstance(carta) ) {	
        	contenedor.setStyle("-fx-background-color: #FFFFFF;");	 
        }
                    
         event.consume();
    
    }
}
