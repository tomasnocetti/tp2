package fiuba.algo3.tp2.Cartas;

public class BocaArriba implements Volteable {
	

//	private TieneUnEfecto efecto;
//	
//	public BocaArriba(TieneUnEfecto efecto) {
//		this.efecto = efecto;
//	}
//	
	public boolean estaBocaAbajo() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean estaBocaArriba() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void activarEfecto(TieneUnEfecto efecto) {
		efecto.activarEfecto();
	}

}
