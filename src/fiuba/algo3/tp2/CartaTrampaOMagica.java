package fiuba.algo3.tp2;

public class CartaTrampaOMagica implements Carta{
	
	protected Estado estado;
	protected Efecto efecto;
	
	public CartaTrampaOMagica() {
		this.estado = new BocaAbajo();
	}

	public void aplicarEfecto() {
		this.efecto.activar();
		
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method sub
		
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

}
