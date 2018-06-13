package fiuba.algo3.tp2;

public class Tablero {
	
	private ZonaDeCartasMonstruos zonaMonstruos;
	private ZonaDeCartasDeCampo zonaCartasDeCampo;
	private ZonaDeCartasMagicasOTrampas zonaCartasMagicasOTrampas;
	private Cementerio cementerio;
	
	public Tablero() {
		this.zonaMonstruos = new ZonaDeCartasMonstruos();
		this.zonaCartasDeCampo = new ZonaDeCartasDeCampo();
		this.zonaCartasMagicasOTrampas = new ZonaDeCartasMagicasOTrampas();
		this.cementerio = new Cementerio();
	}
	
	public void destruirCarta(Carta carta) {
		cementerio.agarrarCarta(carta);
	}

}
