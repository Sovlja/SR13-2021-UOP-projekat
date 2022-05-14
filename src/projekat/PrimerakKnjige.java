package projekat;

public class PrimerakKnjige {

   
    protected int brojStrana;

    /**
     * 
     */
    protected int godinaŠtampe;

    /**
     * 
     */
    protected boolean iznajmljenost;

    /**
     * 
     */
    protected String nazivKnjige;

    /**
     * 
     */
    protected String id;


	public PrimerakKnjige(int brojStrana, int godinaŠtampe, boolean iznajmljenost, String nazivKnjige, String id) {
		super();
		this.brojStrana = brojStrana;
		this.godinaŠtampe = godinaŠtampe;
		this.iznajmljenost = iznajmljenost;
		this.nazivKnjige = nazivKnjige;
		this.id = id;
	}
	
	public PrimerakKnjige() {
		super();
		this.brojStrana = 0;
		this.godinaŠtampe = 0;
		this.iznajmljenost = false;
		this.nazivKnjige = "";
		this.id = "";
	
	
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getGodinaŠtampe() {
		return godinaŠtampe;
	}

	public void setGodinaŠtampe(int godinaŠtampe) {
		this.godinaŠtampe = godinaŠtampe;
	}

	public boolean isIznajmljenost() {
		return iznajmljenost;
	}

	public void setIznajmljenost(boolean iznajmljenost) {
		this.iznajmljenost = iznajmljenost;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

	public void setNazivKnjige(String nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Primerak_Knjige [brojStrana=" + brojStrana + ", godinaŠtampe=" + godinaŠtampe + ", iznajmljenost="
				+ iznajmljenost + ", nazivKnjige=" + nazivKnjige + ", id=" + id + "]";
	}
	
	
    
    
}