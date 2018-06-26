package vista;

import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Cartas.Carta;
import javafx.scene.layout.HBox;

public class VistaCampo extends HBox{

	public VistaCampo(int num_jugador) {
		super(new ContenedorCartaVacia(new Jugador()));
	}
	
}
