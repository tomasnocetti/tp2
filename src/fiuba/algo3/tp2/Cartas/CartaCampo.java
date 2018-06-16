package fiuba.algo3.tp2.Cartas;

public class CartaCampo extends Carta{
	
	private boolean destruida;
//	private TieneUnEfecto efecto;
	
	public CartaCampo(TieneUnEfecto efecto) {
		this.destruida = false;
		this.efecto = efecto;
	}

	public void activarEfecto() {
		// TODO Auto-generated method stub
		this.estado.activarEfecto(efecto);
	}

	public void colocarBocaAbajo() {
		// TODO Auto-generated method stub
		
	}

	public void colocarBocaArriba() {
		// TODO Auto-generated method stub
		
	}

	public boolean estaBocaAbajo() {
		// TODO Auto-generated method stub
		return this.estado.estaBocaAbajo();
	}

	public boolean estaBocaArriba() {
		// TODO Auto-generated method stub
		return this.estado.estaBocaArriba();
	}

	public boolean estaEnElCampo() {
		// TODO Auto-generated method stub
		return false;
	}

	public void destruirCarta() {
		this.destruida = true;
	}
	
	public boolean estaDestruida() {
		return this.estaDestruida();
	}

}
