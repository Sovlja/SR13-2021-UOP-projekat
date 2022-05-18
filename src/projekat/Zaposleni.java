package projekat;

public class Zaposleni extends Osoba {


	
    protected double plata;
    	
    	
    protected String korisničkoIme;

    /**
     * 
     */
    protected String lozinka;

    /**
     * 
     */
    protected void DodajČlana() {
        // TODO implement here
    }

    public Zaposleni(String ime, String prezime, String jMBG, String adresa, String id, double plata, String korisničkoIme, String lozinka, boolean pol, boolean jeObrisan) {
    	super(ime, prezime, jMBG, adresa, id, pol, jeObrisan);
    	this.plata = plata;
    	this.korisničkoIme = korisničkoIme;
    	this.lozinka = lozinka;
    	
    }
    public Zaposleni() {
    	super();
    	this.plata = 0.0;
    	this.korisničkoIme = "";
    	this.lozinka = "";
    }

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorisničkoIme() {
		return korisničkoIme;
	}

	public void setKorisničkoIme(String korisničkoIme) {
		this.korisničkoIme = korisničkoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Zaposleni [plata=" + plata + ", korisničkoIme=" + korisničkoIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + "]";
	}
    
    
}