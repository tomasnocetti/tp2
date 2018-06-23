package vista;

import javafx.scene.layout.VBox;

public class VistaTableroJugador extends VBox {
	
	private VistaMonstruos vistaMonstruos;
	private VistaTrampasOMagicas vistaTrampasOMagicas;

	public VistaTableroJugador(boolean frente) {
		super();
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
