package fiuba.algo3.tp2.Cartas;

public class CartaCampo extends Carta{
	
	public void activarEfecto() {
		// TODO Auto-generated method stub
		this.posicion.activarEfecto(this.efecto);
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method stub
		
	}

	public void colocarBocaArriba() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}

	public void enviarAlCementerio() {
		this.jugador.enviarAlCementerio(this);
	}
	
}
