package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public interface MonstruoPosicionable extends Posicionable{
	
	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, Accionable posicion, CartaMonstruo cartaActual);
	public void atacar(Accionable posicion,CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);

}
