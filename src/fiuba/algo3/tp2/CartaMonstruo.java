package fiuba.algo3.tp2;

public class CartaMonstruo implements Carta{
	
	private int puntosDeAtaque;
    private int puntosDeDefensa;
//    private int estrellas;
	private EstadoMonstruo estado;
	private Jugador jugador;
	private PosicionMonstruo posicion;
	private boolean destruida;
	
    public CartaMonstruo(int estrella, int ataque, int defenza, Jugador jugador) {
		this.puntosDeAtaque = ataque;
//		this.estrellas = estrella;
		this.puntosDeDefensa = defenza;
		this.estado = new MonstruoBocaArriba(); 
		this.posicion = null;
		this.jugador = jugador;
		this.destruida = false;
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
}
