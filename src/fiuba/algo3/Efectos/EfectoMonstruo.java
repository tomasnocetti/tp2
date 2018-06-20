package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public abstract class EfectoMonstruo extends Efecto {
	public abstract boolean activarAntesDeAtaque(CartaMonstruo atacante, CartaMonstruo atacada) ;
	public abstract boolean activarAntesDeDefensa(CartaMonstruo atacante, CartaMonstruo atacada);
}
