package fiuba.algo3.tp2;

public class PosicionDefenza implements PosicionMonstruo {

	public void atacarMonstruo(int puntosDeAtaque, CartaMonstruo cartaAtacada) {
		throw new CartaEnPosicionDefenzaException();
	}

	public void recibirAtaque() {
		// TODO Auto-generated method stub

	}

	public boolean estaEnPosicionAtaque() {
		// TODO Auto-generated method stub
		return false;
	}

}
