package fiuba.algo3.tp2;

public class EfectoAgujeroNegro implements Efecto {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public EfectoAgujeroNegro(Jugador _jugador1, Jugador _jugador2) {
		this.jugador1 = _jugador1;
		this.jugador2 = _jugador2;
	}

	public void activar() {
		this.jugador1.destruirMonstruos();
		this.jugador2.destruirMonstruos();

	}

}
