package fiuba.algo3.tp2;

public class PosicionDefensa implements PosicionMonstruo {

	private int puntosDefensa;
	
	public PosicionDefensa (int puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}
	
	public void atacarMonstruo(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		throw new CartaEnPosicionDefensaException();
	}

	public boolean estaEnPosicionAtaque() {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
//		Logica dl ataque recibido
	}


}
