package vista;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorCarta extends VBox {
	
	public ContenedorCarta(int ataque, int defensa, String nombre) {
		super();
		this.getStylesheets().addAll(AlGoHo.class.getResource("style.css").toExternalForm());
		this.getStyleClass().add("contenedorCarta");
		this.getChildren().addAll(new Text(nombre), new Text("" + ataque), new Text("" + defensa));
        this.setMargin(this.getChildren().get(0),new Insets(10));
        this.setMargin(this.getChildren().get(1),new Insets(10));
        this.setMargin(this.getChildren().get(2),new Insets(10));
	}
}
