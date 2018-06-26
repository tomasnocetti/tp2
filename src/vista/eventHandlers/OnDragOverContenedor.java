package vista.eventHandlers;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import vista.ContenedorCarta;
import vista.ContenedorCartaVacia;

public class OnDragOverContenedor implements EventHandler<DragEvent>{
	private String nombreDeClase = null; 
	private ContenedorCartaVacia contenedor = null;
	private Integer fasePermitida = null; 
	
	public OnDragOverContenedor(String nombreDeClase, ContenedorCartaVacia contenedor, Integer fasePermitida) {
		this.nombreDeClase = nombreDeClase;
		this.contenedor = contenedor; 
		this.fasePermitida = fasePermitida;
	}
	
	public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
		Dragboard db = event.getDragboard();
        Carta carta = (Carta) db.getContent(Carta.Binding);
        
        System.out.println(carta.getClass().getSimpleName());
        System.out.println(this.nombreDeClase);
        Juego juego = Juego.ObtenerJuego();
        
        if(this.fasePermitida.equals(juego.iFaseActual()) && this.nombreDeClase.equals(carta.getClass().getSimpleName())) {	
        	event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
                    
         event.consume();
    
    }
}
