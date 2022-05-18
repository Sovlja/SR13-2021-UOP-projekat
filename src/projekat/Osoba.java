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
    
    

	protected boolean jeMuško;

    
	protected boolean jeObrisan;

     
	public Osoba(String ime, String prezime, String jMBG, String adresa, String id, boolean jeMuško, boolean jeObrisan) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = jMBG;
		this.adresa = adresa;
		this.jeMuško = jeMuško;
		this.id = id;
		this.jeObrisan = jeObrisan;
	}
    
    public Osoba() {
    	this.ime = "";
    	this.prezime = "";
    	this.JMBG = "";
    	this.jeMuško = true;
    	this.adresa = "";
    	this.id = "";
    	this.jeObrisan = false;
    }

	

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getId() {
		return id;
	}

	public boolean isJeMuško() {
		return jeMuško;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJeMuško(boolean jeMuško) {
		this.jeMuško = jeMuško;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}

	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id
				+ ", jeMuško=" + jeMuško + ", jeObrisan=" + jeObrisan + "]";
	}

	

	
	
	
}