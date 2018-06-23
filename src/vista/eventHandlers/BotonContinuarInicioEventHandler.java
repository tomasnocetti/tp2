package vista.eventHandlers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonContinuarInicioEventHandler implements EventHandler<ActionEvent>{
	
		private Stage stage;
		private Scene sceneCompletarNombres;

		public BotonContinuarInicioEventHandler (Stage stage, Scene sceneCompletarNombres) {
			this.stage = stage;
			this.sceneCompletarNombres = sceneCompletarNombres;
		}
		
		public void handle(ActionEvent arg0) {
			this.stage.setScene(this.sceneCompletarNombres);
			this.stage.setFullScreen(true);
		}

}

