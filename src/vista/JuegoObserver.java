package vista;

import java.awt.Frame;
import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.Juego;

public class JuegoObserver extends Frame implements Observer {
	
	private static final long serialVersionUID = 1L;

    public void update( Observable obs,Object obj ) {
        if( obs != Juego.ObtenerJuego()) return;
        PrintStream out = System.out;
        out.println( Juego.ObtenerJuego().estadoDelJuegoTerminado() );
    }
}


//instancia de la vista (scene) para poder ejecutar el alert (juego va ser singleton y lo podemos acceder directamente)
