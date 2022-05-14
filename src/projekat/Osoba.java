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
    protected String id;

    /**
     * 
     */
   
	public Osoba(String ime, String prezime, String jMBG, String adresa, String id) {
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
    	this.id = "";
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id
				+ "]";
	}
	
	
    
    
}