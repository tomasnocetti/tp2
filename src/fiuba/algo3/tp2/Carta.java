package fiuba.algo3.tp2;

public interface Carta {
	public void aplicarEfecto();
	public void colocarBocaAbajo();
	public void colocarBocaArriba();
	public boolean estaBocaAbajo() ;
	public boolean estaBocaArriba();
	public boolean estaEnElCampo();
	public void destruirCarta();
	public boolean estaDestruida();
}
