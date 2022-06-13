package projekat;



public class Administrator extends Zaposleni {
	
	protected void RegistrujZaposlenog() {
    }
	
	public Administrator() {
		super();
		
	}

	public Administrator(String ime, String prezime, String jMBG, String adresa, String id, double plata,
			String korisničkoIme, String lozinka, Pol pol, boolean jeObrisan) {
		super(ime, prezime, jMBG, adresa, id, plata, korisničkoIme, lozinka, pol, jeObrisan);
	}
	
	
	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", korisničkoIme=" + korisničkoIme + ", lozinka=" + lozinka + ", ime="
				+ ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + ", pol=" + pol
				+ ", jeObrisan=" + jeObrisan + "]";
	}

	
	
	
	
    
}
