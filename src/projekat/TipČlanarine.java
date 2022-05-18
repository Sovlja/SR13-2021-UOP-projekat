package projekat;

public class TipČlanarine {
	protected String id;
	protected String naziv;
	protected int cena;
	protected boolean jeObrisan;
	
	public TipČlanarine(String id, String naziv, int cena, boolean jeObrisan) {

		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.jeObrisan = jeObrisan;
	}
	
	public TipČlanarine() {
		this.id = "";
		this.naziv = "";
		this.cena = 0;
		this.jeObrisan = false;
	}

	@Override
	public String toString() {
		return "TipČlanarine [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", jeObrisan=" + jeObrisan + "]";
	}

	public String getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public int getCena() {
		return cena;
	}

	public boolean isjeObrisan() {
		return jeObrisan;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public void setjeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	
	
}

