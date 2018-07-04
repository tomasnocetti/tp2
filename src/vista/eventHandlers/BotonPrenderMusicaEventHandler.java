package vista.eventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class BotonPrenderMusicaEventHandler implements EventHandler<ActionEvent>{

	private MediaPlayer mediaPlayer;
	
	public BotonPrenderMusicaEventHandler(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.mediaPlayer.play();
	}

}
