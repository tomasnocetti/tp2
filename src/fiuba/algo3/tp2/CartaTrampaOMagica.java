package fiuba.algo3.tp2;

public class CartaTrampaOMagica implements Carta{
	
	public Estado estado;
	
	public CartaTrampaOMagica() {
		this.estado = new BocaAbajo();
	}

	public void aplicarEfecto() {
		// TODO Auto-generated method stub
		
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}

}
