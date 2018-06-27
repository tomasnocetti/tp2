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
        
//        System.out.println("DENTRO DEL DRAG");
//        System.out.println(contenedor.jugadorEsValido(carta.obtenerJugador()));
//        System.out.println(this.clase.isInstance(carta));
        ControladorDeJuego controlador = ControladorDeJuego.obtenerInstancia();
        
        if(controlador.obtenerAccion() == "NORMAL" && contenedor.jugadorEsValido(carta.obtenerJugador()) && this.fasePermitida.equals(juego.iFaseActual())) {
        	System.out.println("DENTRO DEL DRAG");
        	Jugador jugador = carta.obtenerJugador();
        	Integer id = Integer.parseInt(this.contenedor.getId());
        	
        	
        	if(this.clase.equals(CartaMonstruo.class)) {
        		
        		ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
        		CartaMonstruo cartaMonstruo = (CartaMonstruo) carta;
        		
        		if(cartaMonstruo.obtenerEstrellas() <= 4) {
        			jugador.colocarCartaEnZona((CartaMonstruo) carta , id, cartasSacrificio);	
            		controlador.dibujar();
        		} else {
        			controlador.invocarConSacrificios(cartaMonstruo, id);
        		}
        	}
        	System.out.println(this.clase);
        	if(this.clase.equals(CartaTrampaOMagica.class)) {
        		System.out.println("CartaTrampaOMagica");
        		CartaTrampaOMagica cartaTrampaOMagica = (CartaTrampaOMagica) carta; 
        		jugador.colocarCartaEnZona(cartaTrampaOMagica, id);
        		cartaTrampaOMagica.colocarBocaAbajo();
        		controlador.dibujar();
        	}
        	if(this.clase.equals(CartaCampo.class)) {
        		System.out.println("CartaCampo");
        		CartaCampo cartaCampo = (CartaCampo) carta;
        		jugador.colocarCartaEnZona(cartaCampo,juego.jugadorOponente());
        		controlador.dibujar();
        	}
        	contenedor.setStyle("-fx-background-color: #FFFFFF;");	 
        }
                    
         event.consume();
    
    }
}
