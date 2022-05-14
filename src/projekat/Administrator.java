package projekat;


public class Administrator extends Zaposleni {

    
    protected void RegistrujZaposlenog() {
    }

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(String ime, String prezime, String jMBG, String adresa, String id, double plata,
			String korisničkoIme, String lozinka) {
		super(ime, prezime, jMBG, adresa, id, plata, korisničkoIme, lozinka);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administratori [plata=" + plata + ", korisničkoIme=" + korisničkoIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + "]";
	}
	
    
}