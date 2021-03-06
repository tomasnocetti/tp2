package fiuba.algo3.Estados;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public interface Accionable {

	public void atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaActual);
	public int calcularDanio(CartaMonstruo atacante, CartaMonstruo atacada);
	public void atacarJugador(CartaMonstruo cartaAtacante, Jugador otro);
}
