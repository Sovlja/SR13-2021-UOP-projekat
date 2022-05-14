package projekat;

/**
 * 
 */
public class Bibliotekar extends Zaposleni {

    public Bibliotekar() {
    	super();
    }

	public Bibliotekar(String ime, String prezime, String jMBG, String adresa, String id, double plata,
			String korisničkoIme, String lozinka) {
		super(ime, prezime, jMBG, adresa, id, plata, korisničkoIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bibliotekari [plata=" + plata + ", korisničkoIme=" + korisničkoIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + "]";
	}

	
	

}