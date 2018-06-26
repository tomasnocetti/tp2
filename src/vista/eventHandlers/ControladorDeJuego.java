package vista.eventHandlers;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import vista.VistaInformacionDeJuego;
import vista.VistaMano;
import vista.VistaTableroDeJuego;

public class ControladorDeJuego {
	private VistaMano vistaMano;
	private VistaInformacionDeJuego vistaInformacionDeJuego;
	private String accionActua;
	private VistaTableroDeJuego vistaTableroDeJuego; 
	private static ControladorDeJuego controladorActual;
	private static Carta draggedCard;  
	
	public static void inicializar(VistaMano vistaMano, VistaInformacionDeJuego vistaInformacionDeJuego, VistaTableroDeJuego vistaTableroDeJuego) {
		ControladorDeJuego controlador = new ControladorDeJuego();
		controlador.vistaTableroDeJuego = vistaTableroDeJuego;
		controlador.vistaMano = vistaMano;
		controlador.vistaInformacionDeJuego = vistaInformacionDeJuego;
		controladorActual = controlador;
	}

	public static void clearDraggedCard() {
		draggedCard = null;
	}
	
	public static void setDraggedCard(Carta carta) {
		draggedCard = carta;
	}

	public static Carta getDraggedCard() {
		return draggedCard;
	}
	
	public static ControladorDeJuego obtenerInstancia () {
		return controladorActual;
	}
	
	public void dibujar() {
		System.out.println("REDIBUJAR TABLERO");
		this.vistaMano.dibujar();
		this.vistaTableroDeJuego.dibujar();
		this.vistaInformacionDeJuego.dibujar();
	}
}
