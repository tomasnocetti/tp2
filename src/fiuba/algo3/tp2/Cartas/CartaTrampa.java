package fiuba.algo3.tp2.Cartas;

public class CartaTrampa extends CartaTrampaOMagica{
	
	public CartaTrampa(TieneUnEfecto efecto) {
		super(efecto);
	}

	public void activarEfecto() {
		this.efecto.activarEfecto();
	}
}
