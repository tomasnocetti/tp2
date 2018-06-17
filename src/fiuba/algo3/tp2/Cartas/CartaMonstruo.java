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
	private MonstruoPosicionable estado;
	private Accionable accion;
	private boolean destruida;
	private TieneUnEfecto efecto;
	
    public CartaMonstruo(int estrella, int ataque, int defenza, Jugador jugador) {
		this.puntosDeAtaque = ataque;
		this.estrellas = estrella;
		this.puntosDeDefensa = defenza;
		this.estado = new MonstruoPosicionArriba(); 
		this.accion = null;
		this.jugador = jugador;
		this.destruida = false;
//		this.efecto = efecto;
	}

	public void atacarMonstruo(CartaMonstruo otro) {
		this.estado.atacarMonstruo(this.accion,this,otro);
//		otro.recibirAtaque(this.PuntosDeAtaque,atacante, defensor);
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
		this.estado.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante, this.accion, this);
	}
	
	public void destruirCarta() {
		this.destruida = true;
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
		this.destruirCarta();
	}

	public boolean estaDestruida() {
		// TODO Auto-generated method stub
		return this.destruida;
	}

	public void aplicarEfecto() {
		// TODO Auto-generated method stub
		
	}

	public void colocarBocaAbajo() {
		this.estado = new MonstruoPosicionAbajo();
		
	}

	public boolean estaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}

	public void colocarBocaArriba() {
		this.estado = new MonstruoPosicionArriba();
		
	}

	public boolean estaBocaArriba() {
		return this.estado.estaBocaArriba();
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
		this.estado.activarEfecto(efecto);
	}
}
