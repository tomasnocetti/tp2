package fiuba.algo3.tp2.Cartas;

public class CartaTrampa extends CartaTrampaOMagica{
	
	public CartaTrampa() {
		super();
	}

	public void activarEfecto() {
		this.efecto.activarEfecto();
	}

	@Override
	public void colocarBocaArriba() {
		// TODO Auto-generated method stub
		this.estado = new BocaArriba();
	}
}
