package fiuba.algo3.tp2;

public interface EstadoMonstruo {
	
//	public void atacarMonstruo();
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, PosicionMonstruo posicion);
//	public void colocarPosicionAtaque();
//	public boolean estaEnPosicionAtaque();
	public void atacarMonstruo(PosicionMonstruo posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
}
