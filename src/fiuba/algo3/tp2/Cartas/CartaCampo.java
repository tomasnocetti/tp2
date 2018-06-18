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

	public boolean estaBocaAbajo() {
		// TODO Auto-generated method stub
		return this.posicion.estaBocaAbajo();
	}

	public boolean estaBocaArriba() {
		// TODO Auto-generated method stub
		return this.posicion.estaBocaArriba();
	}

	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}


}
