package vista;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import javafx.scene.layout.HBox;

public class VistaCementerio extends HBox {

	public VistaCementerio() {
		super(new ContenedorCartaVacia(new Jugador()));
	}

}
