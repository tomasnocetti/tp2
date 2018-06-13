package fiuba.algo3.tp2;

public class CartaMonstruo implements Carta{
	
	private int puntosDeAtaque;
    private int puntosDeDefensa;
    private int estrellas;
	private EstadoMonstruo estado;
	private Jugador jugador;
	private PosicionMonstruo posicion;
	
    public CartaMonstruo(int estrella, int ataque, int defenza, Jugador jugador) {
		this.puntosDeAtaque = ataque;
		this.estrellas = estrella;
		this.puntosDeDefensa = defenza;
		this.estado = null; 
		this.posicion = null;
		this.jugador = jugador;
	}

	public void atacarMonstruo(CartaMonstruo otro) {
		this.estado.atacarMonstruo(this.posicion,this,otro);
//		otro.recibirAtaque(this.PuntosDeAtaque,atacante, defensor);
    }

//	private void recibirAtaque(int puntosDeAtaqueRecibidos, Jugador atacante, Jugador defensor) {
//		int diferencia = this.PuntosDeAtaque - puntosDeAtaqueRecibidos; 
//		if (diferencia < 0) {
//			defensor.quitarPuntosDeVida(diferencia);
//		}
//		//este metodo no esta terminado posiblemente halla que agregar mas cosasS
//	}
	
	public void colocarEnPosicionDefenza() {
		this.posicion = new PosicionDefensa(this.puntosDeDefensa);
	}

	public void colocarEnPosicionAtaque() {
		this.posicion = new PosicionAtaque(this.puntosDeAtaque);
	}

	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
		this.estado.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante, this.posicion);
	}
}
