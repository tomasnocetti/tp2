package vista;

import fiuba.algo3.tp2.Jugador;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTableroJugador extends HBox {
	
	private VistaMonstruos vistaMonstruos;
	private VistaTrampasOMagicas vistaTrampasOMagicas;
	private Jugador jugador;
	private VistaCampo vistaCampo;
	private VistaCementerio vistaCementerio;
	private VistaMazo vistaMazo;
	
	public VistaTableroJugador(boolean frente) {
		super();
		
		ContenedorCartaVacia cartaVacia = new ContenedorCartaVacia();
				

		vistaMonstruos = new VistaMonstruos();
		vistaTrampasOMagicas = new VistaTrampasOMagicas();
		vistaCampo = new VistaCampo();
		vistaCementerio = new VistaCementerio();
		vistaMazo = new VistaMazo();
		
		if(frente) {
			VBox tableroPrincipal = new VBox(vistaTrampasOMagicas, vistaMonstruos);
			HBox tableroSecundario = new HBox(vistaMazo, vistaCementerio, vistaCampo);
			tableroPrincipal.setSpacing(10);
			tableroSecundario.setSpacing(10);
			this.getChildren().addAll(tableroPrincipal,tableroSecundario);
		}else {
			VBox tableroPrincipal = new VBox(vistaMonstruos,vistaTrampasOMagicas);
			HBox tableroSecundario = new HBox(vistaMazo, vistaCementerio, vistaCampo);
			tableroPrincipal.setSpacing(10);
			tableroSecundario.setSpacing(10);
			this.getChildren().addAll(tableroPrincipal,tableroSecundario);
		}
		this.setSpacing(10);
	}
}
