package fiuba.algo3.tp2;

public class Jugador {
	
	private int puntosDeVida;
	
	public Jugador() {
		this.puntosDeVida = 8000;
	}

	public void quitarPuntosDeVida(int puntosPerdidos) {
		this.puntosDeVida = this.puntosDeVida - puntosPerdidos;
	}
	
}
