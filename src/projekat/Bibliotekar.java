package projekat;

/**
 * 
 */
public class Bibliotekar extends Zaposleni {

    public Bibliotekar() {
    	super();
    }

	public Bibliotekar(String ime, String prezime, String jMBG, String adresa, String id, double plata,
			String korisničkoIme, String lozinka, boolean pol, boolean jeObrisan) {
		super(ime, prezime, jMBG, adresa, id, plata, korisničkoIme, lozinka, pol, jeObrisan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bibliotekar [plata=" + plata + ", korisničkoIme=" + korisničkoIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + ", jeMuško=" + jeMuško
				+ "]";
	}

	
	
	

}