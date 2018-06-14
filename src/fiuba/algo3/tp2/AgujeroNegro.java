package fiuba.algo3.tp2;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro(Jugador jugador1, Jugador jugador2) {
		this.efecto = new EfectoAgujeroNegro(jugador1, jugador2);
	}
}
