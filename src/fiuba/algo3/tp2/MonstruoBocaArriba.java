package fiuba.algo3.tp2;

public class MonstruoBocaArriba implements EstadoMonstruo {
	
	private PosicionMonstruo posicion;
	
	public MonstruoBocaArriba() {
		
	}
	
	public void atacarMonstruo(PosicionMonstruo posicion, int puntosDeAtaque, CartaMonstruo cartaAtacada){
		posicion.atacarMonstruo(puntosDeAtaque, cartaAtacada);
	}
	
	public void recibirAtaque() {
		//should be implemented
	}
	
	public void colocarPosicionAtaque() {
		this.posicion = new PosicionAtaque();
	}
	
	public boolean estaEnPosicionAtaque() {
		return this.posicion.estaEnPosicionAtaque() ;
	}

}
