package fiuba.algo3.tp2.Cartas;

import fiuba.algo3.Estados.AccionAtaque;
import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.Estados.Accionable;
import fiuba.algo3.Estados.MonstruoPosicionAbajo;
import fiuba.algo3.Estados.MonstruoPosicionArriba;
import fiuba.algo3.Estados.MonstruoPosicionable;
import fiuba.algo3.tp2.Jugador;

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
	}

	public void atacar(CartaMonstruo otro) {
		this.posicion.atacarMonstruo(this.accion,this,otro);
    }

	public void colocarEnPosicionDeDefensa() {
		this.accion = new AccionDefensa(this.puntosDeDefensa);
	}

	public void colocarEnPosicionDeAtaque() {
		this.accion = new AccionAtaque(this.puntosDeAtaque);
	}
	
	public boolean estaEnPosicionDeAtaque() {
		return this.accion.estaEnPosicionAtaque();
	}
	
	public boolean estaEnPosicionDeDefensa() {
		return !this.accion.estaEnPosicionAtaque();
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
		this.posicion.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante, this.accion, this);
	}

	public void quitarVidaAJugador(int puntosPerdidos) {
		// TODO Auto-generated method stub
		System.out.println(puntosPerdidos);
		this.jugador.quitarPuntosDeVida(puntosPerdidos);
		System.out.println(this.jugador.darPuntosDeVida());
	}

	public void recibirCoontraataque(int puntosPerdidos) {
		// TODO Auto-generated method stub
		this.jugador.quitarPuntosDeVida(puntosPerdidos);
	}


	public void aplicarEfecto() {
		// TODO Auto-generated method stub
	}

	public void colocarBocaAbajo() {
		this.posicion = new MonstruoPosicionAbajo();
		
	}

	public boolean estaBocaAbajo() {
		return this.posicion.estaBocaAbajo();
	}

	public void colocarBocaArriba() {
		this.posicion = new MonstruoPosicionArriba();
		
	}

	public boolean estaBocaArriba() {
		return this.posicion.estaBocaArriba();
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
