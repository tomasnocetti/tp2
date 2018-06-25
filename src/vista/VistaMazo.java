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
	
	public VistaMazo() {
		super();
		Juego juego = Juego.ObtenerJuego();
		Jugador jugador = juego.jugadorActual();
		Mazo mazo = jugador.obtenerMazo();
		this.getChildren().add(new ContenedorCartaVacia());
//		Background fondo = new Background(new BackgroundImage(new Image("cartaBocaAbajo.jpg",150,150,true,true), null, null, null, null));
//		this.setBackground(fondo);
	}
}
