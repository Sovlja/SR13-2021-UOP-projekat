package projekat;


/**
 * 
 */
public abstract class Osoba {
	
    protected String ime;

    /**
     * 
     */
    protected String prezime;

    /**
     * 
     */
    protected String JMBG;

    /**
     * 
     */
    protected String adresa;

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    public enum Pol {
        MUŠKI,
        ŽENSKI
    }

	public Osoba(String ime, String prezime, String jMBG, String adresa, int id) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		JMBG = jMBG;
		this.adresa = adresa;
		this.id = id;
	}
    
    public Osoba() {
    	this.ime = "";
    	this.prezime = "";
    	this.JMBG = "";
    	this.adresa = "";
    	this.id = 0;
    }

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id
				+ "]";
	}
	
	
    
    
}