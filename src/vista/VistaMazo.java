package vista;

import com.sun.prism.paint.Color;

import fiuba.algo3.tp2.Juego;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tableros.Mazo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class VistaMazo extends HBox {
	private Jugador jugador;
	
	public VistaMazo(Jugador jugador) {
		super();
		this.jugador = jugador;	
	}
	
	public void dibujar() {
		this.getChildren().clear();
		Mazo mazo = jugador.obtenerMazo();
		this.getChildren().add(new ContenedorCartaMazo(String.valueOf(mazo.obtenerCantidadDeCartas()))); 
	}
}
