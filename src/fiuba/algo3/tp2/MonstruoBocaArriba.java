package fiuba.algo3.tp2;

public class MonstruoBocaArriba implements EstadoMonstruo {
	
	public MonstruoBocaArriba() {
		
	}
	
	public void atacarMonstruo(PosicionMonstruo posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada){
		posicion.atacarMonstruo(cartaAtacante, cartaAtacada);
	}
	
	public void recibirAtaque(int puntosDeAtaqueRecibidos,CartaMonstruo cartaAtacante, PosicionMonstruo posicion, CartaMonstruo cartaActual) {
		//should be implemented
		posicion.recibirAtaque(puntosDeAtaqueRecibidos, cartaAtacante,cartaActual);
	}

	public boolean estaBocaAbajo() {
		return false;
	}
	
//	public void colocarPosicionAtaque() {
//		this.posicion = new PosicionAtaque();
//	}
//	
//	public boolean estaEnPosicionAtaque() {
//		return this.posicion.estaEnPosicionAtaque() ;
//	}

}
