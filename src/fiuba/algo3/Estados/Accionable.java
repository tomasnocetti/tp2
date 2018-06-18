package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public interface Accionable {

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
	public void defender(int puntosDeAtaqueRecibidos, CartaMonstruo cartaAtacante, CartaMonstruo cartaActual);
}
