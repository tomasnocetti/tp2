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
		this.setPrefHeight(200);
		this.setPrefWidth(150);
		this.setMaxHeight(200);
		this.setMaxWidth(150);
		this.setMinHeight(200);
		this.setMinWidth(150);
		
		if(carta instanceof CartaMonstruo) {
			Text nombre = new Text(carta.nombre());
			Text ataque = new Text("ATK: " + ((CartaMonstruo) carta).obtenerPuntosAtaque());
			Text defensa = new Text("DEN: " + ((CartaMonstruo) carta).obtenerPuntosDefensa());
			Text estrellas = new Text("EST: " + ((CartaMonstruo) carta).obtenerEstrellas());
			Text tipo = new Text(carta.getClass().getSimpleName());
			this.getChildren().addAll(nombre,tipo,ataque,defensa, estrellas);
			this.setMargin(this.getChildren().get(0),new Insets(10));
	        this.setMargin(this.getChildren().get(1),new Insets(10));
	        this.setMargin(this.getChildren().get(2),new Insets(10));
	        this.setMargin(this.getChildren().get(3),new Insets(10));
	        this.setMargin(this.getChildren().get(4),new Insets(10));
		}else {
			Text nombre = new Text(carta.nombre());
			Text tipo = new Text(carta.getClass().getSimpleName());
			this.getChildren().addAll(nombre,tipo);
			this.setMargin(this.getChildren().get(0),new Insets(10));
			this.setMargin(this.getChildren().get(1),new Insets(10));
		}
		
	}
}
