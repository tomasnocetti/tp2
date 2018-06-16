package fiuba.algo3.tp2.Cartas;

public class CartaMagica extends CartaTrampaOMagica{
	
	public CartaMagica() {
		super();
	}

	public void colocarBocaArriba() {
		this.estado.activarEfecto(this.efecto);
	}
	
}
