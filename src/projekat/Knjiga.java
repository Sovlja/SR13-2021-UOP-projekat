package projekat;


/**
 * 
 */
public class Knjiga {

  
    protected String id;
    protected String naslov;
    protected String originalniNaslov;
    protected int godinaObjavljivanja;
    protected String opis;
    protected String jezikOriginala;
    protected String autor;
    protected Žanr žanr;
    protected boolean jeObrisan;

	public Knjiga(String id, String naslov, String originalniNaslov, int godinaObjavljivanja, String opis,
			String jezikOriginala, String autor, Žanr žanr, boolean jeObrisan) {
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.jezikOriginala = jezikOriginala;
		this.autor = autor;
		this.žanr = žanr;
		this.jeObrisan = jeObrisan;
	}

    public Knjiga() {
    	this.id = "";
		this.naslov = "";
		this.originalniNaslov = "";
		this.godinaObjavljivanja = 0;
		this.opis = "";
		this.jezikOriginala = "";
		this.autor = "";
		this.žanr = null;
		this.jeObrisan = false;
    }

	
	
	public String getId() {
		return id;
	}

	public String getNaslov() {
		return naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public String getOpis() {
		return opis;
	}

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public String getAutor() {
		return autor;
	}

	public Žanr getŽanr() {
		return žanr;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setŽanr(Žanr žanr) {
		this.žanr = žanr;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}

	@Override
	public String toString() {
		return "Knjige [id=" + id + ", naslov=" + naslov + ", originalniNaslov=" + originalniNaslov
				+ ", godinaObjavljivanja=" + godinaObjavljivanja + ", opis=" + opis + ", jezikOriginala="
				+ jezikOriginala + ", autor=" + autor + ", žanr=" + žanr + "]";
	}
	
}

    
