package vista.eventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class BotonApagarMusicaEventHandler implements EventHandler<ActionEvent>{

	private MediaPlayer mediaPlayer;
	
	public BotonApagarMusicaEventHandler(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.mediaPlayer.stop();
	}

}

