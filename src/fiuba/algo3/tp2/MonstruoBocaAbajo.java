package fiuba.algo3.tp2;

public class MonstruoBocaAbajo implements EstadoMonstruo {
	
	public MonstruoBocaAbajo() {
	}
	
	public void atacarMonstruo(PosicionMonstruo posicion, int puntosDeAtaque, CartaMonstruo cartaAtacada){
		throw new MonstruoBocaAbajoException();
	}
	
	public void recibirAtaque() {
		//should be implemented
	}
	
	public void colocarPosicionAtaque() {
		//should be implemented and raise error
	}
	
	public boolean estaEnPosicionAtaque() {
		return false;
	}

}
