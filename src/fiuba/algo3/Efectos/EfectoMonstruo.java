package fiuba.algo3.Efectos;

import fiuba.algo3.tp2.Cartas.CartaMonstruo;

public class EfectoMonstruo extends Efecto {
	public boolean activarAntesDeAtaque(CartaMonstruo atacante, CartaMonstruo atacada) {return true;}
	public boolean activarAntesDeDefensa(CartaMonstruo atacante, CartaMonstruo atacada) {return true;}
}
