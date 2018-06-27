package vista.eventHandlers;

import java.util.ArrayList;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import vista.VistaInformacionDeJuego;
import vista.VistaMano;
import vista.VistaTableroDeJuego;

public class ControladorDeJuego {
	private VistaMano vistaMano;
	private VistaInformacionDeJuego vistaInformacionDeJuego;
	private String accionActual = MODO_NORMAL;
	private VistaTableroDeJuego vistaTableroDeJuego; 
	private static ControladorDeJuego controladorActual;
	private static Carta draggedCard;
	private ArrayList<CartaMonstruo> cartaClipboard = new ArrayList<CartaMonstruo>();
	private CartaMonstruo cartaAInvocar; 
	private int posicionAColocarInvocacion;
	
	static final String MODO_SACRIFICIO = "SACRIFICIO";
	static final String MODO_NORMAL = "NORMAL";

	
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

	public void continuarFase() {
		Juego juego = Juego.ObtenerJuego();
		juego.continuarASiguienteFase();
		Jugador actual = juego.jugadorActual();
		
		switch(juego.iFaseActual()) {
		case 0:
			actual.agarrarCartasDelMazo(1);
            break;
		case 1:
            break;
		case 2:
			
            break;
		case 3:
			
		    break;
		case 4:
			
            break;
        }
		this.dibujar();
	}
	
	public void invocarConSacrificios(CartaMonstruo carta, int posicion) {
		this.accionActual = MODO_SACRIFICIO;
		this.cartaClipboard = new ArrayList<CartaMonstruo>();
		this.vistaInformacionDeJuego.mostrarSeccionSacrificios(String.valueOf(carta.numeroDeSacrificios()));
		cartaAInvocar = carta;
		posicionAColocarInvocacion = posicion;
	}
	
	public void agregarCartaDeSacrificio(CartaMonstruo carta) {	
		cartaClipboard.add(carta);
		if(cartaAInvocar.numeroDeSacrificios() != cartaClipboard.size()) return;
		this.accionActual = MODO_NORMAL;
		Jugador jugador = cartaAInvocar.obtenerJugador();
		jugador.colocarCartaEnZona(cartaAInvocar, posicionAColocarInvocacion, cartaClipboard);
		this.cartaClipboard = new ArrayList<CartaMonstruo>();
		this.dibujar();	
	}
	
	public void cancelarAccion() {
		this.accionActual = MODO_NORMAL;
		this.dibujar();
	}
	
	public String obtenerAccion() {
		return this.accionActual;
	}
}
