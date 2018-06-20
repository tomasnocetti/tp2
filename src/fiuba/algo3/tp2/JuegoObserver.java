package fiuba.algo3.tp2;

import java.awt.Frame;
import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class JuegoObserver extends Frame implements Observer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Juego juego;

    public JuegoObserver( Juego juego ) {
    	this.juego = juego;
    }

    public void update( Observable obs,Object obj ) {
        if( obs != juego) return;
        PrintStream out = System.out;
        out.println( juego.estadoDelJuego() );
    }
}
