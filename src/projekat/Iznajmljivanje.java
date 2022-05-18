package projekat;
import java.time.LocalDate;

/**
 * 
 */
public class Iznajmljivanje {
	protected String id;
	protected LocalDate datumIznajmljivanja;
	protected LocalDate datumVraćanja;
	protected Zaposleni zaposleni;
	protected Član član;
	protected PrimerakKnjige primerak;
	protected boolean jeObrisan;


	public Iznajmljivanje() {
		this.primerak = null;
		this.id = "";
		this.datumIznajmljivanja = null;
		this.datumVraćanja = null;
		this.zaposleni = null;
		this.član = null;
		this.jeObrisan = false;
    }


	public Iznajmljivanje(String id, LocalDate datumIznajmljivanja, LocalDate datumVraćanja, Zaposleni zaposleni,
			Član član, PrimerakKnjige primerak, boolean jeObrisan) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVraćanja = datumVraćanja;
		this.zaposleni = zaposleni;
		this.član = član;
		this.primerak = primerak;
		this.jeObrisan = jeObrisan;
	}




	public String getId() {
		return id;
	}


	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}


	public LocalDate getDatumVraćanja() {
		return datumVraćanja;
	}


	public Zaposleni getZaposleni() {
		return zaposleni;
	}


	public Član getČlan() {
		return član;
	}


	public PrimerakKnjige getPrimerak() {
		return primerak;
	}


	public boolean isJeObrisan() {
		return jeObrisan;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}


	public void setDatumVraćanja(LocalDate datumVraćanja) {
		this.datumVraćanja = datumVraćanja;
	}


	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}


	public void setČlan(Član član) {
		this.član = član;
	}


	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}


	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVraćanja="
				+ datumVraćanja + ", zaposleni=" + zaposleni + ", član=" + član + ", primerak=" + primerak + "]";
	}

    	

}