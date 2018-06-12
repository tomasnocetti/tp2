package fiuba.algo3.tp2;

public class CartaMonstruo implements Carta{
	
	private int PuntosDeAtaque;
    private int PuntosDeDefenza;
    private int estrellas;
	
    public CartaMonstruo(int estrella, int ataque, int defenza) {
		this.PuntosDeAtaque = ataque;
		this.estrellas = estrella;
		this.PuntosDeDefenza = defenza;
	}

	public void atacarMonstruo(CartaMonstruo otro, Jugador atacante, Jugador defensor) {
    	otro._atacarMonstruo(this.PuntosDeAtaque,atacante, defensor);
    }

	private void _atacarMonstruo(int puntosDeAtaque2, Jugador atacante, Jugador defensor) {
		int diferencia = this.PuntosDeAtaque - puntosDeAtaque2; 
		if (diferencia < 0) {
			defensor.quitarPuntosDeVida(diferencia);
		}
		//este metodo no esta terminado posiblemente halla que agregar mas cosasS
	}
}
