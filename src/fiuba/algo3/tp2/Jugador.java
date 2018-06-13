package fiuba.algo3.tp2;

public class Jugador {
	
	private int puntosDeVida;
//	private Mazo mazo;
//	private Tablero tablero;
	
	public Jugador() {
		this.puntosDeVida = 8000;
//		this.mazo = new Mazo();
//		this.tablero = new Tablero();
	}

	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}

	public int darPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	
}
