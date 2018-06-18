package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Estados.AccionAtaque;
import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.Estados.Accionable;
import fiuba.algo3.Estados.MonstruoPosicionAbajo;
import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Excepciones.CartaEnAccionDefensaException;
import fiuba.algo3.tp2.Excepciones.CartaNoSeEncuentraEnZona;

public class CartaMonstruo extends Carta{
	
	private int puntosDeAtaque;
    private int puntosDeDefensa;
    private int estrellas;
	private Jugador jugador;
	private MonstruoPosicionable posicion;
	private Accionable accion;
	private TieneUnEfecto efecto;
	
    public CartaMonstruo(int estrella, int ataque, int defenza, Jugador jugador) {
		this.puntosDeAtaque = ataque;
		this.estrellas = estrella;
		this.puntosDeDefensa = defenza;
		this.posicion = new MonstruoPosicionArriba(); 
		this.accion = null;
		this.jugador = jugador;
//		this.efecto = efecto;
	}
    
	public void atacar(CartaMonstruo otro) {
		if(!this.jugador.estaEnElCampo(this)) throw new CartaNoSeEncuentraEnZona();
		this.posicion.atacar(this, otro);
    }

	public void colocarEnAccionDeDefensa() {
		this.accion = new AccionDefensa(this.puntosDeDefensa);
	}

	public void colocarEnAccionDeAtaque() {
		this.accion = new AccionAtaque(this.puntosDeAtaque);
	}
	
	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
	public Accionable obtenerAccion() {
		return this.accion;
	}
	
	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
		this.posicion.defender(puntosDeAtaqueRecibidos, cartaAtacante, this.accion, this);
	}

	public void quitarVidaAJugador(int puntosPerdidos) {
		// TODO Auto-generated method stub
		this.jugador.quitarPuntosDeVida(puntosPerdidos);
	}

	public void aplicarEfecto() {
		// TODO Auto-generated method stub
		
	}

	public void colocarBocaAbajo() {
		this.posicion = new MonstruoPosicionAbajo();
		
	}

	public void colocarBocaArriba() {
		this.posicion = new MonstruoPosicionArriba();
		
	}

	public boolean estaEnElCampo() {
		return this.jugador.estaEnElCampo(this);
	}

	public int numeroDeSacrificios() {
		if (4 < this.estrellas && this.estrellas < 7) {
			return 1;
		}
		if (6 < this.estrellas) {
			return 2;
		}
		else {
			return 0;
		}
	}

	@Override
	public void activarEfecto() {
		// TODO Auto-generated method stub
		this.posicion.activarEfecto(efecto);
	}
}
