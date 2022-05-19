package projekat;

public class PrimerakKnjige {

    protected int brojStrana;
    protected int godinaŠtampe;
    protected boolean iznajmljenost;
    protected String nazivKnjige;
    protected String id;
    protected boolean jeObrisan;
    protected Knjiga knjiga;
    protected Jezik jezikŠtampe;
    protected TipPoveza tipPoveza;

	public PrimerakKnjige(int brojStrana, int godinaŠtampe, boolean iznajmljenost, String nazivKnjige, String id, boolean jeObrisan, Jezik jezikŠtampe, Knjiga knjiga, TipPoveza tipPoveza) {
		this.brojStrana = brojStrana;
		this.godinaŠtampe = godinaŠtampe;
		this.iznajmljenost = iznajmljenost;
		this.nazivKnjige = nazivKnjige;
		this.id = id;
		this.jeObrisan = jeObrisan;
		this.jezikŠtampe = jezikŠtampe;
		this.knjiga = knjiga;
		this.tipPoveza = tipPoveza;
	}
	
	public PrimerakKnjige() {
		this.brojStrana = 0;
		this.godinaŠtampe = 0;
		this.iznajmljenost = false;
		this.nazivKnjige = "";
		this.id = "";
		this.jeObrisan = false;
		this.jezikŠtampe = null;
		this.knjiga = null;
		this.tipPoveza = null;
	
	
	}

	
	public int getBrojStrana() {
		return brojStrana;
	}

	public int getGodinaŠtampe() {
		return godinaŠtampe;
	}

	public boolean isIznajmljenost() {
		return iznajmljenost;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

	public String getId() {
		return id;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public Jezik getJezikŠtampe() {
		return jezikŠtampe;
	}

	public TipPoveza getTipPoveza() {
		return tipPoveza;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public void setGodinaŠtampe(int godinaŠtampe) {
		this.godinaŠtampe = godinaŠtampe;
	}

	public void setIznajmljenost(boolean iznajmljenost) {
		this.iznajmljenost = iznajmljenost;
	}

	public void setNazivKnjige(String nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public void setJezikŠtampe(Jezik jezikŠtampe) {
		this.jezikŠtampe = jezikŠtampe;
	}

	public void setTipPoveza(TipPoveza tipPoveza) {
		this.tipPoveza = tipPoveza;
	}

	@Override
	public String toString() {
		return "PrimerakKnjige [brojStrana=" + brojStrana + ", godinaŠtampe=" + godinaŠtampe + ", iznajmljenost="
				+ iznajmljenost + ", nazivKnjige=" + nazivKnjige + ", id=" + id + ", jeObrisan=" + jeObrisan
				+ ", knjiga=" + knjiga + ", jezikŠtampe=" + jezikŠtampe + ", tipPoveza=" + tipPoveza + "]";
	}

	

	
	
    
    
}