package vista.eventHandlers;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;
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
        
        ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
        
        if(controlador.obtenerAccion() == "NORMAL" && contenedor.jugadorEsValido(carta.obtenerJugador()) && this.fasePermitida.equals(juego.iFaseActual())) {
        	Jugador jugador = carta.obtenerJugador();
        	Integer id = Integer.parseInt(this.contenedor.getId());
        	
        	
        	if(this.clase.equals(CartaMonstruo.class)) {
        
        		CartaMonstruo cartaMonstruo = (CartaMonstruo) carta;
    			controlador.invocar(cartaMonstruo, id);
        		
        	}
        	if(this.clase.equals(CartaTrampaOMagica.class)) {
        		CartaTrampaOMagica cartaTrampaOMagica = (CartaTrampaOMagica) carta; 
        		jugador.colocarCartaEnZona(cartaTrampaOMagica, id);
        		cartaTrampaOMagica.colocarBocaAbajo();
        		controlador.dibujar();
        	}
        	if(this.clase.equals(CartaCampo.class)) {
        		CartaCampo cartaCampo = (CartaCampo) carta;
        		jugador.colocarCartaEnZona(cartaCampo,juego.jugadorOponente());
        		controlador.dibujar();
        	}
        	contenedor.setStyle("-fx-background-color: #FFFFFF;");	 
        }
                    
         event.consume();
    
    }
}
