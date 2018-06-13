package fiuba.algo3.tp2;

public class MonstruoBocaAbajo implements EstadoMonstruo {
	
	public MonstruoBocaAbajo() {
	}
	
	public void atacarMonstruo(PosicionMonstruo posicion, CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		throw new MonstruoBocaAbajoException();
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, PosicionMonstruo posicion) {
		//should be implemented
		throw new MonstruoBocaAbajoException();
	}
	
	public void colocarPosicionAtaque() {
		//should be implemented and raise error
	}
	
	public boolean estaEnPosicionAtaque() {
		return false;
	}

}
