package fiuba.algo3.tp2.Cartas;

public class CartaTrampaOMagica extends Carta{
	
	
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
