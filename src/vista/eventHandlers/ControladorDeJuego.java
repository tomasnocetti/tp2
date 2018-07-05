package vista.eventHandlers;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;
import fiuba.algo3.tp2.Excepciones.MonstruoBocaAbajoException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vista.VentanaFinDeJuego;
import vista.VistaInformacionDeJuego;
import vista.VistaMano;
import vista.VistaPuntosDeVida;
import vista.VistaTableroDeJuego;

public class ControladorDeJuego {
	private VistaMano vistaMano;
	private VistaInformacionDeJuego vistaInformacionDeJuego;
	private String accionActual = MODO_NORMAL;
	private VistaTableroDeJuego vistaTableroDeJuego; 
	private static ControladorDeJuego controladorActual;
	private static Carta draggedCard;
	private ArrayList<CartaMonstruo> cartaClipboard = new ArrayList<CartaMonstruo>();
	private ArrayList<CartaMonstruo> cartasQueAtacaron = new ArrayList<CartaMonstruo>();
	private boolean colocoCartaEnCampoMonstruo;
	private CartaMonstruo cartaAInvocar; 
	private int posicionAColocarInvocacion;
	private VistaPuntosDeVida vistaPuntosDeVida;
	private Stage stage;
	
	public static final String MODO_SACRIFICIO = "SACRIFICIO";
	public static final String MODO_NORMAL = "NORMAL";
	public static final String MODO_ATAQUE_1 = "ATAQUE_1";
	public static final String MODO_ATAQUE_2 = "ATAQUE_2";
	public static final String COLOCAR_ATAQUE = "COLOCAR_ATAQUE";
	public static final String COLOCAR_DEFENSA = "COLOCAR_DEFENSA";
	public static final String BOCA_ABAJO = "BOCA_ABAJO";
	public static final String BOCA_ARRIBA = "BOCA_ARRIBA";
	public static final String ATAQUE_JUGADOR = "ATAQUE_JUGADOR";
	public static final String ACTIVAR_MAGICA = "ACTIVAR_MAGICA";
	
	public static void inicializar(VistaMano vistaMano, VistaInformacionDeJuego vistaInformacionDeJuego, VistaTableroDeJuego vistaTableroDeJuego, VistaPuntosDeVida vistaPuntosDeVida,Stage stage) {
		ControladorDeJuego controlador = new ControladorDeJuego();
		controlador.vistaTableroDeJuego = vistaTableroDeJuego;
		controlador.vistaMano = vistaMano;
		controlador.vistaInformacionDeJuego = vistaInformacionDeJuego;
		controlador.vistaPuntosDeVida = vistaPuntosDeVida;
		controlador.stage = stage;
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
		this.vistaMano.dibujar();
		this.vistaTableroDeJuego.dibujar();
		this.vistaInformacionDeJuego.dibujar();
		this.vistaPuntosDeVida.dibujar();
		Juego juego = Juego.ObtenerJuego();
		if(juego.estadoDelJuegoTerminado()) {
			VentanaFinDeJuego ventanaFin = new VentanaFinDeJuego();
			ventanaFin.display(juego.obtenerGanador().obtenerNombre(), stage,juego.obtenerRazonFinalizacion());
		}
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
				colocoCartaEnCampoMonstruo = false;
			case 2:
				cartasQueAtacaron = new ArrayList<CartaMonstruo>();
		        break;
	    }
		this.dibujar();
	}
	
	public void invocar(CartaMonstruo carta, int posicion) {
		if(colocoCartaEnCampoMonstruo) return;
		Jugador jugador = carta.obtenerJugador();
		if(carta.obtenerEstrellas() <= 4) {
			ArrayList<CartaMonstruo> cartasSacrificio = new ArrayList<CartaMonstruo>();
			jugador.colocarCartaEnZona((CartaMonstruo) carta , posicion, cartasSacrificio);
			colocoCartaEnCampoMonstruo = true;
			this.dibujar();
			return;
		} 
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
		colocoCartaEnCampoMonstruo = true;
		this.dibujar();
	}
	
	public void cancelarAccion() {
		this.accionActual = MODO_NORMAL;
		cartaClipboard.clear();
		this.dibujar();
	}
	
	public String obtenerAccion() {
		return this.accionActual;
	}

	public void iniciarAccion(String accion) {
		switch(accion) {
			case MODO_ATAQUE_1:
				this.accionActual = MODO_ATAQUE_1;
				this.vistaInformacionDeJuego.mostrarSeccionAtaque();
				break;
			case COLOCAR_ATAQUE:
				this.accionActual = COLOCAR_ATAQUE;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Colocar en ataque'");
				break;
			case COLOCAR_DEFENSA:
				this.accionActual = COLOCAR_DEFENSA;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Colocar en defensa'");
				break;
			case MODO_NORMAL:
				this.accionActual = MODO_NORMAL;
				break;
			case BOCA_ABAJO:
				this.accionActual = BOCA_ABAJO;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Colocar boca abajo'");
				break;
			case BOCA_ARRIBA:
				this.accionActual = BOCA_ARRIBA;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Colocar boca arriba'");
				break;
			case ATAQUE_JUGADOR:
				this.accionActual = ATAQUE_JUGADOR;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Atacar jugador'");
				break;
			case ACTIVAR_MAGICA:
				this.accionActual = ACTIVAR_MAGICA;
				this.vistaInformacionDeJuego.mostrarSeccionAccionGenerica("'Activar Magica'");
		}
	}

	public void atacarAlJugador(CartaMonstruo carta) {
		this.accionActual = MODO_NORMAL;
		Jugador jugador = Juego.ObtenerJuego().jugadorOponente();
		if(jugador.obtenerMonstruos().size() > 0 || this.cartasQueAtacaron.contains(carta)) return;
		try {
			carta.atacarJugador(jugador);
			cartasQueAtacaron.add(carta);
			this.vistaInformacionDeJuego.dibujar();
        }catch (CartaEnAccionDefensaException e) {
        	this.vistaInformacionDeJuego.mensajeDeError("La carta se encuentra en posicion de defensa. No puede atacar !");
        }catch (MonstruoBocaAbajoException e) {
        	this.vistaInformacionDeJuego.mensajeDeError("La carta se encuentra boca abajo. No puede atacar !");
        }
	}
	
	public void agregarCartaAlAtaque(CartaMonstruo carta) {
		Jugador jugador = Juego.ObtenerJuego().jugadorActual();
		Collection cartas = jugador.obtenerMonstruos();
		if (this.accionActual == MODO_ATAQUE_1) {
			cartaClipboard.add(carta);
			this.accionActual = MODO_ATAQUE_2;
			return;
		} 
		try {
			CartaMonstruo carta1 = cartaClipboard.get(0);
			carta1.atacar(carta);
			this.cancelarAccion();
        }catch (CartaEnAccionDefensaException e) {
        	this.vistaInformacionDeJuego.mensajeDeError("La carta se encuentra en posicion de defensa. No puede atacar !");
        }catch (MonstruoBocaAbajoException e) {
        	this.vistaInformacionDeJuego.mensajeDeError("La carta se encuentra boca abajo. No puede atacar !");
        }
	}
}
