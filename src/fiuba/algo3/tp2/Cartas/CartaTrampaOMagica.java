package fiuba.algo3.tp2.Cartas;

public abstract class CartaTrampaOMagica extends Carta{
	
	private boolean destruida;

	public CartaTrampaOMagica() {
		this.estado = new BocaAbajo();
		this.destruida = false;
	}

	public void activarEfecto() {
		this.estado.activarEfecto(this.efecto);
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method sub
		this.estado = new BocaAbajo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}

	public void colocarBocaArriba() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaBocaArriba() {
		return this.estado.estaBocaArriba();
	}

	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}

	public void destruirCarta() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaDestruida() {
		// TODO Auto-generated method stub
		return false;
	}

}
