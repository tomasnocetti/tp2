package fiuba.algo3.tp2;

public class Jugador {
	
	private int puntosDeVida;
//	private Mazo mazo;
	private Tablero tablero;
	
	public Jugador() {
		this.puntosDeVida = 8000;
//		this.mazo = new Mazo();
		this.tablero = new Tablero();
	}

	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}

	public int darPuntosDeVida() {
		return this.puntosDeVida;
	}

	public void colocarMonstruo(CartaMonstruo monstruo, int posicion) {
		this.tablero.colocarMonstruo(monstruo, posicion);
		
	}

	public void colocarBocaArriba(CartaTrampaOMagica carta) {
		this.tablero.colocarBocaArriba(carta);
	}
	
	public void colocarBocaArriba(CartaMonstruo carta) {
		this.tablero.colocarBocaArriba(carta);
	}
	
	public void colocarBocaArriba(CartaCampo carta) {
		this.tablero.colocarBocaArriba(carta);
	}
	

	public boolean noTieneMonstruosEnElCampo() {
		return this.tablero.noTieneMonstruos();
	}

	public void destruirMonstruos() {
		this.tablero.destruirMonstruos();
		
	}

	public void enviarAlCementerio(CartaMonstruo cartaMonstruo) {
		this.tablero.destruirCarta(cartaMonstruo);
		
	}

	public boolean estaEnElCampo(CartaTrampaOMagica carta) {
		return this.tablero.estaEnElCampo(carta);
		
	}
	
	public boolean estaEnElCampo(CartaMonstruo carta) {
		return this.tablero.estaEnElCampo(carta);
		
	}
	
	public boolean estaEnElCampo(CartaCampo carta) {
		return this.tablero.estaEnElCampo(carta);
		
	}
	
	
}
