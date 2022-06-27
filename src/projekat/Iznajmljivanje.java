package projekat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class Iznajmljivanje {
	protected String id;
	protected LocalDate datumIznajmljivanja;
	protected LocalDate datumVraćanja;
	protected Zaposleni zaposleni;
	protected Član član;
	protected ArrayList<PrimerakKnjige> primerci;
	protected boolean jeObrisan;


	public Iznajmljivanje() {
		this.primerci = new ArrayList<PrimerakKnjige>();
		this.id = "";
		this.datumIznajmljivanja = null;
		this.datumVraćanja = null;
		this.zaposleni = null;
		this.član = null;
		this.jeObrisan = false;
    }


	public Iznajmljivanje(String id, LocalDate datumIznajmljivanja, LocalDate datumVraćanja, Zaposleni zaposleni,
			Član član, ArrayList <PrimerakKnjige> primerci, boolean jeObrisan) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVraćanja = datumVraćanja;
		this.zaposleni = zaposleni;
		this.član = član;
		this.primerci = primerci;
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


	public ArrayList<PrimerakKnjige> getPrimerci() {
		return primerci;
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


	public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
		this.primerci = primerci;
	}


	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVraćanja="
				+ datumVraćanja + ", zaposleni=" + zaposleni + ", član=" + član + ", primerci=" + primerci
				+ ", jeObrisan=" + jeObrisan + "]";
	}




	

	

    	

}