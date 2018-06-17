package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public interface EstadoMonstruo extends Posicionable{
	
//	public void atacarMonstruo();
	public void recibirAtaque(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual);
//	public void colocarPosicionAtaque();
//	public boolean estaEnPosicionAtaque();
	public void atacarMonstruo(Accionable posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
}
