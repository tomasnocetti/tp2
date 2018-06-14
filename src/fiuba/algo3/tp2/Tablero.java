package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Tablero {
	
	private ZonaDeCartasMonstruos zonaMonstruos;
//	private ZonaDeCartasDeCampo zonaCartasDeCampo;
	private ZonaDeCartasMagicasOTrampas zonaCartasMagicasOTrampas;
	private Cementerio cementerio;
	
	public Tablero() {
		this.zonaMonstruos = new ZonaDeCartasMonstruos();
//		this.zonaCartasDeCampo = new ZonaDeCartasDeCampo();
		this.zonaCartasMagicasOTrampas = new ZonaDeCartasMagicasOTrampas();
		this.cementerio = new Cementerio();
	}
	
	public void destruirCarta(Carta carta) {
		cementerio.agarrarCarta(carta);
	}
	
	public void colocarMonstruo(CartaMonstruo monstruo, int posicion) {
		this.zonaMonstruos.agregarCarta(monstruo, posicion);
	}

	public boolean noTieneMonstruos() {
		return this.zonaMonstruos.estaVacia();
	}

	public void colocarBocaArriba(CartaTrampaOMagica carta) {
		this.zonaCartasMagicasOTrampas.agregarCarta(carta, 0);
		carta.colocarBocaArriba();
		
	}
	
	public void colocarBocaArriba(CartaMonstruo carta, int posicion) {
		ArrayList<CartaMonstruo> monstruosSacrificados = this.zonaMonstruos.sacrificarMonstruos(carta.numeroDeSacrificios());
		Iterator<CartaMonstruo> m = monstruosSacrificados.iterator();
		
		while (m.hasNext()) {
			CartaMonstruo monstruo = m.next();
			this.destruirCarta(monstruo);
		}
		
		this.zonaMonstruos.agregarCarta(carta, posicion);
		carta.colocarBocaArriba();
		
	}
	
	public void colocarBocaArriba(CartaCampo carta) {
		// TODO
		
	}

	public void destruirMonstruos() {
		this.zonaMonstruos.vaciar();
		Collection monstruos = this.zonaMonstruos.obtenerCartas();
		Iterator<CartaMonstruo> i = monstruos.iterator();
		
		while (i.hasNext()) {
			CartaMonstruo monstruo = i.next();
			this.destruirCarta(monstruo);
		}
		
	}

	public boolean estaEnElCampo(CartaMonstruo cartaMonstruo) {
		return this.zonaMonstruos.obtenerCartas().contains(cartaMonstruo);
		
	}
	
	public boolean estaEnElCampo(CartaTrampaOMagica cartaTrampaOMagica) {
		// TODO
		return false;
		
	}
	
	public boolean estaEnElCampo(CartaCampo cartaCampo) {
		//TODO
		return false;
		
	}



}
