package fiuba.algo3.tp2.Cartas;


import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.Efectos.EfectoFisura;
import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.Efectos.EfectoMejoraAtaqueDefensa;
import fiuba.algo3.Efectos.EfectoOllaDeLaCodicia;;

public class CartaFactory {
	
	private Jugador jugador;

	public CartaFactory(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo(jugador, efecto, 4, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica1Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo(jugador, efecto, 5, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica2Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo(jugador, efecto, 7, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMagica crearCartaMagicaGenerica() {
		Efecto efecto = new EfectoVacio();
		CartaMagica carta = new CartaMagica(jugador, efecto);
		return carta;
	}
	
	public CartaTrampa crearCartaTrampaGenerica() {
		Efecto efecto = new EfectoVacio();
		CartaTrampa carta = new CartaTrampa(jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaCampoGenerica() {
		Efecto efecto = new EfectoVacio();
		CartaCampo carta = new CartaCampo(jugador, efecto);
		return carta;
	}

	public static CartaMagica crearCartaAgujeroNegro(Jugador jugador) {
		Efecto efecto = new EfectoAgujeroNegro();
		CartaMagica carta = new CartaMagica(jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaWasteland() {
		Efecto efecto = new EfectoMejoraAtaqueDefensa(200, 0, 0, 300);
		CartaCampo carta = new CartaCampo(this.jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaSogen() {
		Efecto efecto = new EfectoMejoraAtaqueDefensa(0, 500, 200, 0);
		CartaCampo carta = new CartaCampo(this.jugador, efecto);
		return carta;
	}
	
	public CartaMagica crearCartaOllaDeLaCodicia() {
		Efecto efecto = new EfectoOllaDeLaCodicia();
		CartaMagica carta = new CartaMagica(this.jugador, efecto);
		return carta;
	}
	
	public CartaMagica crearCartaFisura() {
		Efecto efecto = new EfectoFisura();
		CartaMagica carta = new CartaMagica(this.jugador, efecto);
		return carta;
	}
	
}
