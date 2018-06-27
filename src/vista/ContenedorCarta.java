package vista;

import fiuba.algo3.Estados.AccionDefensa;
import fiuba.algo3.Estados.MonstruoPosicionAbajo;
import fiuba.algo3.Estados.PosicionAbajo;
import fiuba.algo3.tp2.Cartas.Carta;
import fiuba.algo3.tp2.Cartas.CartaMonstruo;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
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
			Button button = new Button();

			button.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
			button.getStyleClass().add("button-cartas");
			button.setPrefHeight(250);
			button.setPrefWidth(200);
			box.getChildren().add(button);
			this.getChildren().add(box);
			System.out.println("Abajo");
			System.out.println(this.getChildren());
		}else {
			if(carta instanceof CartaMonstruo) {
				VBox box = new VBox();
				Text nombre = new Text(carta.nombre());
				nombre.setWrappingWidth(100);
				Text ataque = new Text("ATK: " + ((CartaMonstruo) carta).obtenerPuntosAtaque());
				Text defensa = new Text("DEN: " + ((CartaMonstruo) carta).obtenerPuntosDefensa());
				Text estrellas = new Text("EST: " + ((CartaMonstruo) carta).obtenerEstrellas());
				Text tipo = new Text(carta.getClass().getSimpleName());
				this.getChildren().addAll(nombre,tipo,ataque,defensa, estrellas);
				box.setMargin(this.getChildren().get(0),new Insets(5));
		        box.setMargin(this.getChildren().get(1),new Insets(5));
		        box.setMargin(this.getChildren().get(2),new Insets(5));
		        box.setMargin(this.getChildren().get(3),new Insets(5));
		        box.setMargin(this.getChildren().get(4),new Insets(5));
		        CartaMonstruo cartaMon = (CartaMonstruo) carta;
		        if(cartaMon.obtenerAccion() instanceof AccionDefensa) {
		        	this.setRotate(90);
		        }
			}else {
				Text nombre = new Text(carta.nombre());
				nombre.setWrappingWidth(150);
				Text tipo = new Text(carta.getClass().getSimpleName());
				this.getChildren().addAll(nombre,tipo);
				this.setMargin(this.getChildren().get(0),new Insets(5));
				this.setMargin(this.getChildren().get(1),new Insets(5));
			}
		}	
	}

}
