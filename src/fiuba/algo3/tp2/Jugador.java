package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaCampo;
import fiuba.algo3.tp2.Cartas.CartaFactory;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import fiuba.algo3.tp2.Cartas.CartaTrampa;
import fiuba.algo3.tp2.Cartas.CartaTrampaOMagica;
import fiuba.algo3.tp2.Excepciones.InvocacionInvalida;
import fiuba.algo3.tp2.Tableros.Cementerio;
import fiuba.algo3.tp2.Tableros.Mazo;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMagicasOTrampas;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasMonstruos;
import fiuba.algo3.tp2.Tableros.ZonaDeCartasDeCampo;
import fiuba.algo3.tp2.Tableros.ZonaMano;

public class Jugador extends Observable{
	
	private int puntosDeVida;
	private ZonaMano mano;
	private Mazo mazo;
	private ZonaDeCartasMonstruos zonaMonstruos;
	private ZonaDeCartasDeCampo zonaCartasDeCampo;
	private ZonaDeCartasMagicasOTrampas zonaCartasMagicasOTrampas;
	private Cementerio cementerio;
		
	public Jugador() {
		this.puntosDeVida = 8000;
		this.mano = new ZonaMano(this);
		this.mazo = new Mazo(this, CartaFactory.inicializarMazoGenerico(this));
		this.cementerio = new Cementerio();
		this.zonaCartasMagicasOTrampas = new ZonaDeCartasMagicasOTrampas(this);
		this.zonaMonstruos = new ZonaDeCartasMonstruos(this);
		this.zonaCartasDeCampo = new ZonaDeCartasDeCampo(this);
	}

	public void agarrarCartasDelMazo(int numero) {
		for (int i = 0; i < numero; i++ ) {
			Carta nuevaCarta = mazo.agarrarCarta();
			this.mano.agregarCarta(nuevaCarta);
		}
	}
	
	public int obtenerCantidadDeCartasDelMazo() {
		return mazo.obtenerCantidadDeCartas();
	}
	
	public void colocarEnMano(Carta carta) {
		this.mano.agregarCarta(carta);
	}
	
	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public boolean tieneTrampaEnElCampo() {
		return this.zonaCartasMagicasOTrampas.tieneTrampa();
	}

	public void destruirMonstruos() {
		this.zonaMonstruos.vaciar();
		Collection<Carta> monstruos = this.zonaMonstruos.obtenerCartas();
		Iterator<Carta> i = monstruos.iterator();
		while (i.hasNext()) {
			CartaMonstruo monstruo = (CartaMonstruo) i.next();
			this.enviarAlCementerio(monstruo);
		}
	}	
	
	public void enviarAlCementerio(CartaCampo carta) {
		cementerio.agregarCarta(carta);
		zonaCartasDeCampo.eliminarCarta(carta);
	}
	
	public void enviarAlCementerio(CartaTrampaOMagica carta) {
		cementerio.agregarCarta(carta);
		zonaCartasMagicasOTrampas.eliminarCarta(carta);
	}
	
	public void enviarAlCementerio(CartaMonstruo carta) {
		cementerio.agregarCarta(carta);
		zonaMonstruos.eliminarCarta(carta);
	}
	
	
	public void colocarCartaEnZona(CartaMonstruo carta, int posicion, ArrayList<CartaMonstruo> cartasSacrificadas) {
		if (carta.invocacionValida(cartasSacrificadas)) {
		this.mano.eliminarCarta(carta);
		this.zonaMonstruos.agregarCarta(carta, posicion, cartasSacrificadas);
		}
		else {
			throw new InvocacionInvalida();
		}
	}

	public void colocarCartaEnZona(CartaTrampaOMagica carta, int posicion) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, posicion);
	}
	
	public void colocarCartaEnZona(CartaCampo carta, Jugador jugadorOponente) {
		this.mano.eliminarCarta(carta);
		this.zonaCartasDeCampo.agregarCarta(carta, jugadorOponente);
	}
	
	public boolean noTieneMonstruos() {
		return this.zonaMonstruos.estaVacia();
	}
	
	public boolean estaEnElCampo(CartaMonstruo cartaMonstruo) {
		return this.zonaMonstruos.obtenerCartas().contains(cartaMonstruo);
	}
	
	public void agarrarCarta() {
		Carta nuevaCarta = mazo.agarrarCarta();
		this.mano.agregarCarta(nuevaCarta);
	}

	public Collection<Carta> obtenerCartasMagicasYTrampas() {
		return this.zonaCartasMagicasOTrampas.obtenerCartas();
	}

	public Collection<Carta> obtenerMonstruos() {
		return this.zonaMonstruos.obtenerCartas();
	}

	public Collection<Carta> obtenerCartasEnCementerio() {
		return this.cementerio.obtenerCartas();
	}
	
	public Collection<Carta> obtenerCartasEnMano() {
		return this.mano.obtenerCartas();
	}
	
	public Collection<Carta> obtenerCartaCampo() {
		return this.zonaCartasDeCampo.obtenerCartas();
	}
	
	public CartaTrampa obtenerProximaCartaTrampa() {
		return this.zonaCartasMagicasOTrampas.obtenerProximaCartaTrampa();
	}
	
	public Mazo obtenerMazo(){
		return this.mazo;
	}
	
	public ZonaDeCartasMonstruos obtenerZonaMonstruos(){
		return this.zonaMonstruos;
	}
	public ZonaDeCartasMagicasOTrampas obtenerZonaCartaMagicasOTrampas(){
		return this.zonaCartasMagicasOTrampas;
	}
	public  ZonaDeCartasDeCampo obtenerZonaCartasDeCampo(){
		return this.zonaCartasDeCampo;
	}
	public  ZonaMano obtenerMano(){
		return this.mano;
	}
	public Cementerio obtenerCementerio(){
		return this.cementerio;
	}
}