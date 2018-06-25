package vista;

import fiuba.algo3.tp2.Jugador;
import javafx.scene.layout.VBox;

public class VistaTableroJugador extends VBox {
	
	private VistaMonstruos vistaMonstruos;
	private VistaTrampasOMagicas vistaTrampasOMagicas;
	private Jugador jugador;

	public VistaTableroJugador(boolean frente, Jugador jugador) {
		super();
		this.jugador = jugador;
		vistaMonstruos = new VistaMonstruos();
		vistaTrampasOMagicas = new VistaTrampasOMagicas();
		if(frente) {
			this.getChildren().addAll(vistaTrampasOMagicas, vistaMonstruos);
		}else {
			this.getChildren().addAll(vistaMonstruos,vistaTrampasOMagicas);
		}
		this.setSpacing(10);
	}
}
