package vista;

import javafx.scene.layout.BorderPane;

public class LayoutContenedorJuego extends BorderPane {
	
	private VistaInformacionDeCarta vistaInformacionDeCarta;
	private VistaTableroDeJuego vistaTableroDeJuego;
	private VistaMano vistaMano;

	public LayoutContenedorJuego () {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("layout");	
		
		vistaTableroDeJuego = new VistaTableroDeJuego();
		vistaInformacionDeCarta= new VistaInformacionDeCarta(this);
		vistaMano = new VistaMano();
		
        this.setCenter(vistaTableroDeJuego);
        this.setLeft(vistaInformacionDeCarta);
		this.setBottom(vistaMano);
	}
}
