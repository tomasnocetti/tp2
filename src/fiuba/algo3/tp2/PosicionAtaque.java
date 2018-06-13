package fiuba.algo3.tp2;

public class PosicionAtaque implements PosicionMonstruo {
	
	public void atacarMonstruo(int puntosDeAtaque, CartaMonstruo cartaAtacada) {
		// to be implemented
		cartaAtacada.recibirAtaque(puntosDeAtaque);
	}
	
	public void recibirAtaque() {
		//to be implemented
	}
	
	public boolean estaEnPosicionAtaque() {
		return true;
	}

}
