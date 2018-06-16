package fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class MonstruoBocaArriba implements EstadoMonstruo {
	
	public MonstruoBocaArriba() {
		
	}
	
	public void atacarMonstruo(PosicionMonstruo posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		posicion.atacarMonstruo(cartaAtacante, cartaAtacada);
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos,CartaMonstruo cartaAtacante, PosicionMonstruo posicion, CartaMonstruo cartaActual) {
		
		posicion.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante,cartaActual);
	}

	public boolean estaBocaAbajo() {
		return false;
	}
	
	public boolean estaBocaArriba() {
		return true;
	}
	
//	public void colocarPosicionAtaque() {
//		this.posicion = new PosicionAtaque();
//	}
//	
//	public boolean estaEnPosicionAtaque() {
//		return this.posicion.estaEnPosicionAtaque() ;
//	}

}
