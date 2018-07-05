package vista.eventHandlers;

import fiuba.algo3.tp2.Juego;
import vista.AlGoHo;
import vista.SceneJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent> {
	
	private Stage stageJuego;
	private Stage stageFinDeJuego;
	
	public BotonReiniciarEventHandler(Stage stageJuego,Stage stageFinDeJuego) {
		this.stageJuego = stageJuego;
    }
	
	public void handle(ActionEvent arg0) {
        Juego juego = Juego.ObtenerJuego();
        String nombre1 = juego.obtenerJugador(0).obtenerNombre();
        String nombre2 = juego.obtenerJugador(1).obtenerNombre();
        juego.resetearJuego();
        juego.obtenerJugador(0).asignarnombre(nombre1);
        juego.obtenerJugador(1).asignarnombre(nombre2); 
		
		SceneJuego sceneJuego = new SceneJuego(stageJuego);
		stageJuego.setScene(sceneJuego);
		stageJuego.setFullScreen(true);
	}
}
