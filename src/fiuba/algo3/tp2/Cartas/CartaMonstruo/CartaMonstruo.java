package fiuba.algo3.tp2.Cartas.CartaMonstruo;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.TieneUnEfecto;
import fiuba.algo3.tp2.Jugador;

public class CartaMonstruo extends Carta{
	
	private int puntosDeAtaque;
    private int puntosDeDefensa;
    private int estrellas;
	private Jugador jugador;
	private VolteableMonstruo estado;
	private PosicionMonstruo posicion;
	private boolean destruida;
	private TieneUnEfecto efecto;
	
    public CartaMonstruo(int estrella, int ataque, int defenza, Jugador jugador) {
		this.puntosDeAtaque = ataque;
		this.estrellas = estrella;
		this.puntosDeDefensa = defenza;
		this.estado = new MonstruoBocaArriba(); 
		this.posicion = null;
		this.jugador = jugador;
		this.destruida = false;
//		this.efecto = efecto;
	}

	public void atacarMonstruo(CartaMonstruo otro) {
		this.estado.atacarMonstruo(this.posicion,this,otro);
//		otro.recibirAtaque(this.PuntosDeAtaque,atacante, defensor);
    }

	public void colocarEnPosicionDeDefensa() {
		this.posicion = new PosicionDefensa(this.puntosDeDefensa);
	}

	public void colocarEnPosicionDeAtaque() {
		this.posicion = new PosicionAtaque(this.puntosDeAtaque);
	}
	
	public boolean estaEnPosicionDeAtaque() {
		return this.posicion.estaEnPosicionAtaque();
	}
	
	public boolean estaEnPosicionDeDefensa() {
		return !this.posicion.estaEnPosicionAtaque();
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
		this.estado.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante, this.posicion, this);
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
		this.estado = new MonstruoBocaAbajo();
		
	}

	public boolean estaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}

	public void colocarBocaArriba() {
		this.estado = new MonstruoBocaArriba();
		
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
