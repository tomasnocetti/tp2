package fiuba.algo3.Estados;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public interface MonstruoPosicionable {
	
	public void defender(CartaMonstruo cartaAtacante, Accionable accion, Efecto efecto, CartaMonstruo cartaActual);
	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
	public void atacarJugador(CartaMonstruo cartaMonstruo, Jugador otro);

}
