package fiuba.algo3.tp2;

public interface EstadoMonstruo extends Volteable{
	
//	public void atacarMonstruo();
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, PosicionMonstruo posicion, CartaMonstruo cartaActual);
//	public void colocarPosicionAtaque();
//	public boolean estaEnPosicionAtaque();
	public void atacarMonstruo(PosicionMonstruo posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
}
