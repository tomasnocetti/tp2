package fiuba.algo3.tp2.Cartas ;

public abstract class Carta {
	
	protected TieneUnEfecto efecto;
	protected Volteable estado;
	
	public abstract void activarEfecto();
	public abstract void colocarBocaAbajo();
	public abstract void colocarBocaArriba();
	public abstract boolean estaBocaAbajo() ;
	public abstract boolean estaBocaArriba();
	public abstract boolean estaEnElCampo();
	public abstract void destruirCarta();
	public abstract boolean estaDestruida();
}
