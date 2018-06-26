package vista.eventHandlers;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import vista.ContenedorCartaVacia;

public class OnDragDroppedContenedor implements EventHandler<DragEvent>{
	private Class<?> clase = null; 
	private ContenedorCartaVacia contenedor = null;
	private Integer fasePermitida = null; 
	
	public OnDragDroppedContenedor(Class<?> superClass, ContenedorCartaVacia contenedor, Integer fasePermitida) {
		this.clase = superClass;
		this.contenedor = contenedor; 
		this.fasePermitida = fasePermitida;
	}
	
	public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
	
        Juego juego = Juego.ObtenerJuego();
        
        Carta carta = ControladorDeJuego.getDraggedCard();
        
        System.out.println("DENTRO DEL DRAG");
        System.out.println(contenedor.jugadorEsValido(carta.obtenerJugador()));
        System.out.println(this.clase.isInstance(carta));
        if(contenedor.jugadorEsValido(carta.obtenerJugador()) && this.fasePermitida.equals(juego.iFaseActual()) && this.clase.isInstance(carta) ) {
        	System.out.println("DENTRO DEL DRAG");
        	Jugador jugador = carta.obtenerJugador();
        	Integer id = Integer.parseInt(this.contenedor.getId());
        	ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
        	
        	if(this.clase.equals(CartaMonstruo.class)) {
        		
        		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
        		
        		jugador.colocarCartaEnZona((CartaMonstruo) carta , id, cartasSacrificio);
        		
        		controlador.dibujar();
        	}
        	System.out.println(this.clase);
        	if(this.clase.equals(CartaTrampaOMagica.class)) {
        		System.out.println("CartaTrampaOMagica");
        		jugador.colocarCartaEnZona((CartaTrampaOMagica) carta , id);
        		controlador.dibujar();
        	}
        	
        	contenedor.setStyle("-fx-background-color: #FFFFFF;");	 
        }
                    
         event.consume();
    
    }
}
