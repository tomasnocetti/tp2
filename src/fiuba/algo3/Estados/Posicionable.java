package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.TieneUnEfecto;

public interface Posicionable {
	
	public boolean estaBocaAbajo();
	
	public boolean estaBocaArriba();

	public void activarEfecto(TieneUnEfecto efecto);

}
