package vista;

import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCarta extends VBox {
	
	public static final String DOBLE_BARRA = "//";
	
	public ContenedorCarta(Carta carta) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("contenedorCarta");
		this.setMaxHeight(250);
		this.setMaxWidth(200);
		
		if(carta instanceof CartaMonstruo) {
			Text nombre = new Text(carta.nombre());
			Text ataque = new Text("" + ((CartaMonstruo) carta).obtenerPuntosAtaque());
			Text defensa = new Text("" + ((CartaMonstruo) carta).obtenerPuntosDefensa());
			Text tipo = new Text(carta.getClass().getSimpleName());
			this.getChildren().addAll(tipo,nombre,ataque,defensa);
			this.setMargin(this.getChildren().get(0),new Insets(10));
	        this.setMargin(this.getChildren().get(1),new Insets(10));
	        this.setMargin(this.getChildren().get(2),new Insets(10));
	        this.setMargin(this.getChildren().get(3),new Insets(10));
		}else {
			Text nombre = new Text(carta.nombre());
			Text tipo = new Text(carta.getClass().getSimpleName());
			this.getChildren().addAll(nombre,tipo);
			this.setMargin(this.getChildren().get(0),new Insets(10));
			this.setMargin(this.getChildren().get(1),new Insets(10));
		}
		
	}
}
