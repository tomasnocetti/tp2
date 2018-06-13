package fiuba.algo3.tp2;

public interface PosicionMonstruo {

//	public void atacarMonstruo();
	public boolean estaEnPosicionAtaque();
	public void atacarMonstruo(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante);
}
