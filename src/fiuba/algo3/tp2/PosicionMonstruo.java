package fiuba.algo3.tp2;

public interface PosicionMonstruo {

//	public void atacarMonstruo();
	public void recibirAtaque();
	public boolean estaEnPosicionAtaque();
	public void atacarMonstruo(int puntosDeAtaque, CartaMonstruo cartaAtacada);
}
