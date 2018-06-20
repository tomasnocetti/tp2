package fiuba.algo3.tp2.Cartas;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.Efectos.EfectoFisura;
import fiuba.algo3.Efectos.EfectoJinzo7;
import fiuba.algo3.Efectos.EfectoVacio;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.Efectos.EfectoMejoraAtaqueDefensa;
import fiuba.algo3.Efectos.EfectoOllaDeLaCodicia;

public class CartaFactory {
	
	private Jugador jugador;

	public CartaFactory(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 4, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica1Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 5, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica2Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 7, puntosAtaque, puntosDefensa);
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
	
	public CartaMonstruo crearCartaJinzo7(Jugador atacado) {
		Efecto efecto = new EfectoJinzo7();
		CartaMonstruo jinzo7 = new CartaMonstruo("Jinzo#7", this.jugador, efecto, 2, 500, 400);
		return jinzo7;
	}
	
	public CartaMonstruo crearCartaDragonBlancoDeOjosAzules() {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Dragon Blanco De Ojos Azules", jugador, efecto, 7, 3000, 2500);
		return carta;
	}
	
	public CartaMonstruo crearCartaDragonDefinitivo() {
		Efecto efecto = new EfectoVacio();
		CartaMonstruo carta = new CartaMonstruo("Dragon Definitivo De Ojos Azules", jugador, efecto, 8, 4500, 3800);
		return carta;
	}
	
	public static ArrayList<Carta> inicializarMazoGenerico(Jugador jugador) {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		Efecto efectoVacio = new EfectoVacio();
		//Efecto efectoWasteland = new EfectoMejoraAtaqueDefensa(200, 0, 0, 300);
		//Efecto efectoSogen = new EfectoMejoraAtaqueDefensa(0, 500, 200, 0);
		
		//CartaCampo cartaSogen = new CartaCampo(jugador, efectoSogen);
		//cartas.add(cartaSogen);
		
		//CartaCampo cartaWasteland = new CartaCampo(jugador, efectoWasteland);
		//cartas.add(cartaWasteland);
		
		cartas.add(CartaFactory.crearCartaAgujeroNegro(jugador));
		
		for (int i=0; i<13 ; i++) {
			int puntosDeAtaque = ThreadLocalRandom.current().nextInt(500, 3001);
			int puntosDeDefensa = ThreadLocalRandom.current().nextInt(500, 3001);
			int estrellas = ThreadLocalRandom.current().nextInt(1, 5);
			
			CartaMonstruo nuevaCarta = new CartaMonstruo("Monstruo Generico", jugador, efectoVacio, estrellas, puntosDeAtaque, puntosDeDefensa);
			cartas.add(nuevaCarta);
		} // agregamos 13 monstruos genericos
		
		for (int i=0; i<6 ; i++) {
			int puntosDeAtaque = ThreadLocalRandom.current().nextInt(500, 3001);
			int puntosDeDefensa = ThreadLocalRandom.current().nextInt(500, 3001);
			int estrellas = ThreadLocalRandom.current().nextInt(5, 7);
			CartaMonstruo nuevaCarta = new CartaMonstruo("Monstruo Generico", jugador, efectoVacio, estrellas, puntosDeAtaque, puntosDeDefensa);
			cartas.add(nuevaCarta);
		} //agregamos 6 monstruos de 1 sacrificio
		
		for (int i=0; i<4 ; i++) {
			int puntosDeAtaque = ThreadLocalRandom.current().nextInt(500, 3001);
			int puntosDeDefensa = ThreadLocalRandom.current().nextInt(500, 3001);
			int estrellas = ThreadLocalRandom.current().nextInt(7, 11);
			
			CartaMonstruo nuevaCarta = new CartaMonstruo("Monstruo Generico", jugador, efectoVacio, estrellas, puntosDeAtaque, puntosDeDefensa);
			cartas.add(nuevaCarta);
		} //agregamos 4 monstruos de 2 sacrificios
		
		for (int i=0; i<5 ; i++) {
			CartaCampo nuevaCarta = new CartaCampo(jugador, efectoVacio);
			cartas.add(nuevaCarta);
		}
		
		for (int i=0; i<6 ; i++) {
			CartaMagica nuevaCarta = new CartaMagica(jugador, efectoVacio);
			cartas.add(nuevaCarta);
		}
		
		for (int i=0; i<5 ; i++) {
			CartaTrampa nuevaCarta = new CartaTrampa(jugador, efectoVacio);
			cartas.add(nuevaCarta);
		}
		//total 40 cartas
	
		return(cartas);
		
	}

}
