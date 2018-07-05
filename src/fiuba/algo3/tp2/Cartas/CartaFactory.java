package fiuba.algo3.tp2.Cartas;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fiuba.algo3.Efectos.Efecto;
import fiuba.algo3.Efectos.EfectoAgujeroNegro;
import fiuba.algo3.Efectos.EfectoCilindroMagico;
import fiuba.algo3.Efectos.EfectoExodia;
import fiuba.algo3.Efectos.EfectoFisura;
import fiuba.algo3.Efectos.EfectoInsectoComeHombres;
import fiuba.algo3.Efectos.EfectoJinzo7;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.Efectos.EfectoMejoraAtaqueDefensa;
import fiuba.algo3.Efectos.EfectoOllaDeLaCodicia;
import fiuba.algo3.Efectos.EfectoReinforcements;




public class CartaFactory {
	
	private Jugador jugador;
	private static String archivoConCartasMonstruo = "cards.json";
	
	public CartaFactory(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new Efecto();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 4, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica1Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new Efecto();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 5, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMonstruo crearCartaMonstruoGenerica2Sacrificio(int puntosAtaque, int puntosDefensa) {
		Efecto efecto = new Efecto();
		CartaMonstruo carta = new CartaMonstruo("Monstruo Generico", jugador, efecto, 7, puntosAtaque, puntosDefensa);
		return carta;
	}
	
	public CartaMagica crearCartaMagicaGenerica() {
		Efecto efecto = new Efecto();
		CartaMagica carta = new CartaMagica("Carta Magica Generica",jugador, efecto);
		return carta;
	}
	
	public CartaTrampa crearCartaTrampaGenerica() {
		Efecto efecto = new Efecto();
		CartaTrampa carta = new CartaTrampa("Carta trampa Generica", jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaCampoGenerica() {
		Efecto efecto = new Efecto();
		CartaCampo carta = new CartaCampo("Carta Campo Generica", jugador, efecto);
		return carta;
	}

	public CartaMagica crearCartaAgujeroNegro() {
		Efecto efecto = new EfectoAgujeroNegro();
		CartaMagica carta = new CartaMagica("Agujero Negro", jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaWasteland() {
		Efecto efecto = new EfectoMejoraAtaqueDefensa(200, 0, 0, 300);
		CartaCampo carta = new CartaCampo("Wasteland", this.jugador, efecto);
		return carta;
	}
	
	public CartaCampo crearCartaSogen() {
		Efecto efecto = new EfectoMejoraAtaqueDefensa(0, 500, 200, 0);
		CartaCampo carta = new CartaCampo("Sogen", this.jugador, efecto);
		return carta;
	}
	
	public CartaMagica crearCartaOllaDeLaCodicia() {
		Efecto efecto = new EfectoOllaDeLaCodicia();
		CartaMagica carta = new CartaMagica("Olla de la codicia", this.jugador, efecto);
		return carta;
	}
	
	public CartaMagica crearCartaFisura() {
		Efecto efecto = new EfectoFisura();
		CartaMagica carta = new CartaMagica("Fisura", this.jugador, efecto);
		return carta;
	}
	
	public CartaMonstruo crearCartaJinzo7() {
		Efecto efecto = new EfectoJinzo7();
		CartaMonstruo jinzo7 = new CartaMonstruo("Jinzo#7", this.jugador, efecto, 2, 500, 400);
		return jinzo7;
	}
	
	public CartaMonstruo crearCartaDragonBlancoDeOjosAzules() {
		Efecto efecto = new Efecto();
		CartaMonstruo carta = new CartaMonstruo("Dragon Blanco De Ojos Azules", jugador, efecto, 7, 3000, 2500);
		return carta;
	}
	
	public CartaMonstruo crearCartaDragonDefinitivo() {
		Efecto efecto = new Efecto();
		CartaMonstruo carta = new CartaMonstruo("Dragon Definitivo De Ojos Azules", jugador, efecto, 8, 4500, 3800);
		return carta;
	}
	
	public CartaMonstruo crearInsectoComeHombres() {
		Efecto efecto = new EfectoInsectoComeHombres();
		CartaMonstruo carta = new CartaMonstruo("Insecto Come Hombres", jugador, efecto, 2, 450, 600);
		return carta;
	} 
	
	public CartaTrampa crearCartaCilindroMagico() {
		Efecto efecto = new EfectoCilindroMagico();
		CartaTrampa carta = new CartaTrampa("Cilindro Magico", this.jugador, efecto);
		return carta;
	}
	
	public CartaTrampa crearCartaReinforcements() {
		Efecto efecto = new EfectoReinforcements();
		CartaTrampa carta = new CartaTrampa("Reinforcements", this.jugador, efecto);
		return carta;
	}
	
	public ArrayList<CartaMonstruo> crear5PartesDeExodia() {
		String cartasNecesarias[] = {
			"Cabeza Exodia", 
			"Brazo Izquierdo Exodia", 
			"Brazo Derecho Exodia", 
			"Pierna Izquierda Exodia",
			"Pierna Derecha Exodia"};  
		
		ArrayList<CartaMonstruo> colleccion = new ArrayList<CartaMonstruo>();
		Efecto efecto = new EfectoExodia();
		List<String> list = Arrays.asList(cartasNecesarias);
		Iterator<String> i = list.iterator();
		
		while (i.hasNext()) {
			final String nombre = i.next();
			colleccion.add(new CartaMonstruo(nombre, jugador, efecto, 2, 450, 600));
		}
		
		return colleccion;
	}
	
	public ArrayList<Carta> obtenerCartasAleatorias(int cantidadDeCartas) {
		Path currentRelativePath = Paths.get(archivoConCartasMonstruo);
		String s = currentRelativePath.toAbsolutePath().toString();
	
		JSONParser parser = new JSONParser();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
        try {

            Object obj = parser.parse(new FileReader(s));

            JSONArray cartasArray = (JSONArray) obj;
            Random rand = new Random();
            Efecto efecto = new Efecto();
            
            for (int i = 0; i < cantidadDeCartas; ++i) {
                int  n = rand.nextInt(cartasArray.size());
                JSONObject json_obj = (JSONObject) cartasArray.get(n);
                
                CartaMonstruo nuevaCarta = new CartaMonstruo(
	        		(String) json_obj.get("Name"), 
	        		jugador, 
	        		efecto, 
	        		((Long) json_obj.get("Level")).intValue() , 
	        		((Long) json_obj.get("ATK")).intValue() ,
	        		((Long) json_obj.get("DEF")).intValue() 
    			);
                cartas.add(nuevaCarta);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cartas;
	}
	
	public static ArrayList<Carta> inicializarMazoGenerico(Jugador jugador) {
		
		CartaFactory factory  = new CartaFactory(jugador);
		
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		cartas.add(factory.crearCartaWasteland());
		cartas.add(factory.crearCartaReinforcements());
		cartas.add(factory.crearCartaCilindroMagico());
		cartas.add(factory.crearCartaDragonDefinitivo());
		cartas.add(factory.crearCartaJinzo7());
		cartas.add(factory.crearCartaFisura());
		cartas.add(factory.crearCartaOllaDeLaCodicia());
		cartas.add(factory.crearCartaSogen());
		cartas.add(factory.crearCartaAgujeroNegro());
		cartas.add(factory.crearInsectoComeHombres());
		cartas.addAll(factory.crear5PartesDeExodia());
		
		for (int i=0; i<3 ; i++) {
			cartas.add(factory.crearCartaDragonBlancoDeOjosAzules());
		}
		
		cartas.addAll(factory.obtenerCartasAleatorias(22));
		Collections.shuffle(cartas);
		return(cartas);
	}

}
