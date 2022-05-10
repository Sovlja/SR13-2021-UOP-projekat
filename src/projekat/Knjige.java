package projekat;


/**
 * 
 */
public class Knjige {

  
    protected int id;

    /**
     * 
     */
    protected String naslov;

    /**
     * 
     */
    protected String originalniNaslov;

    /**
     * 
     */
    protected int godinaObjavljivanja;

    /**
     * 
     */
    protected String opis;

    /**
     * 
     */
    protected String jezikOriginala;

    /**
     * 
     */
    protected Pisac autor;

    /**
     * 
     */
    protected Žanr žanr;

	public Knjige(int id, String naslov, String originalniNaslov, int godinaObjavljivanja, String opis,
			String jezikOriginala, Pisac autor, Žanr žanr) {
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.jezikOriginala = jezikOriginala;
		this.autor = autor;
		this.žanr = žanr;
	}

    public Knjige() {
    	this.id = 0;
		this.naslov = "";
		this.originalniNaslov = "";
		this.godinaObjavljivanja = 0;
		this.opis = "";
		this.jezikOriginala = "";
		this.autor = new Pisac();
		this.žanr = null;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	public Pisac getAutor() {
		return autor;
	}

	public void setAutor(Pisac autor) {
		this.autor = autor;
	}

	public Žanr getŽanr() {
		return žanr;
	}

	public void setŽanr(Žanr žanr) {
		this.žanr = žanr;
	}

	@Override
	public String toString() {
		return "Knjige [id=" + id + ", naslov=" + naslov + ", originalniNaslov=" + originalniNaslov
				+ ", godinaObjavljivanja=" + godinaObjavljivanja + ", opis=" + opis + ", jezikOriginala="
				+ jezikOriginala + ", autor=" + autor + ", žanr=" + žanr + "]";
	}
    
}

    
