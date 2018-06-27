package vista;

import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.Estados.MonstruoPosicionAbajo;
import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCarta extends VBox {
	
	public static final String DOBLE_BARRA = "//";
	private Carta carta;
	
	public ContenedorCarta(Carta carta) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("contenedorCarta");
		this.setPrefHeight(180);
		this.setPrefWidth(150);
		this.setMaxHeight(180);
		this.setMaxWidth(150);
		this.setMinHeight(180);
		this.setMinWidth(150);
		this.carta = carta;
		this.dibujar();
	}

	public Carta obtenerCarta() {
		return carta;
	}
	
	public void dibujar() {
		this.getChildren().clear();
		if(carta.obtenerPosicion() instanceof PosicionAbajo || carta.obtenerPosicion() instanceof MonstruoPosicionAbajo) {
			VBox box = new VBox();
			box.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
			box.getStyleClass().add("button-cartas");
			box.setPrefHeight(250);
			box.setPrefWidth(200);
			this.getChildren().add(box);
			if(carta instanceof CartaMonstruo) {
				CartaMonstruo cartaMon = (CartaMonstruo) carta;
		        if(cartaMon.obtenerAccion() instanceof AccionDefensa) {
		        	this.setRotate(90);
		        }
			}
		}else {
			if(carta instanceof CartaMonstruo) {
				VBox box = new VBox();
				Text nombre = new Text(carta.nombre());
				nombre.setWrappingWidth(100);
				Text ataque = new Text("ATK: " + ((CartaMonstruo) carta).obtenerPuntosAtaque());
				Text defensa = new Text("DEF: " + ((CartaMonstruo) carta).obtenerPuntosDefensa());
				Text estrellas = new Text("EST: " + ((CartaMonstruo) carta).obtenerEstrellas());
				Text tipo = new Text(carta.getClass().getSimpleName());
				box.getChildren().addAll(nombre,tipo,ataque,defensa, estrellas);
				this.getChildren().add(box);
				box.setMargin(box.getChildren().get(0),new Insets(2));
		        box.setMargin(box.getChildren().get(1),new Insets(2));
		        box.setMargin(box.getChildren().get(2),new Insets(2));
		        box.setMargin(box.getChildren().get(3),new Insets(2));
		        box.setMargin(box.getChildren().get(4),new Insets(2));
		        CartaMonstruo cartaMon = (CartaMonstruo) carta;
		        if(cartaMon.obtenerAccion() instanceof AccionDefensa) {
		        	this.setRotate(90);
		        }
			}else {
				VBox box = new VBox();
				Text nombre = new Text(carta.nombre());
				nombre.setWrappingWidth(150);
				Text tipo = new Text(carta.getClass().getSimpleName());
				box.getChildren().addAll(nombre,tipo);
				box.setMargin(box.getChildren().get(0),new Insets(2));
				box.setMargin(box.getChildren().get(1),new Insets(2));
				this.getChildren().add(box);
			}
		}	
	}

}
