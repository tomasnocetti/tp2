package fiuba.algo3.tp2;

public class PosicionAtaque implements PosicionMonstruo {
	
	private int puntosDeAtaque;

	public PosicionAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}
	public void atacarMonstruo(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		// to be implemented
		cartaAtacada.recibirAtaque(this.puntosDeAtaque, cartaAtacante);
	}
	
	public boolean estaEnPosicionAtaque() {
		return true;
	}

	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante) {
		// TODO Auto-generated method stub
//		Logica del ataque recibido
	}

}
