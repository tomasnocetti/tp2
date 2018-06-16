package fiuba.algo3.tp2.Cartas;

public class CartaMagica extends CartaTrampaOMagica{
	
	public CartaMagica(TieneUnEfecto efecto) {
		super(efecto);
	}

	public void colocarBocaArriba() {
		this.efecto.activarEfecto();
	}
	
}
