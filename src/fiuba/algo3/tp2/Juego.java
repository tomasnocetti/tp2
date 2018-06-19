package fiuba.algo3.tp2;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private static Juego instancia = null;

	public Juego() {
		this.jugador1 = new Jugador();
		this.jugador2 = new Jugador();
	}
	
	public static Juego ObtenerJuego() {
		if (instancia == null) {
			instancia = new Juego();
		}
		return instancia;
	}
	
	public static void setInstancia(Juego j){
		if (instancia == null)
			instancia = j;
	}
	
}

