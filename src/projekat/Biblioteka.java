package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalTime;

public class Biblioteka {

 
    protected String naziv;

    /**
     * 
     */
    protected String adresa;

    /**
     * 
     */
    protected String brTelefona;

    
    protected LocalTime radnoVreme;

   
    protected ArrayList<Administrator> admini;
    

    
    protected ArrayList<Bibliotekar> bibliotekari;
    

    
    protected ArrayList<Knjiga> knjige;
    
    
    protected ArrayList<Iznajmljivanje> iznajmljivanje;
    
    
    protected ArrayList<Član> članovi;
    
    
    protected ArrayList<PrimerakKnjige> primerakKnjige;
    
    
    protected ArrayList<Žanr> žanrKnjige;
    
    
//    protected Set<jezikŠtampe> jezikŠtampe;


	

	




//	public Set<jezikŠtampe> getJezikŠtampe() {
//		return jezikŠtampe;
//	}
//
//
//
//
//	public void setJezikŠtampe(Set<jezikŠtampe> jezikŠtampe) {
//		this.jezikŠtampe = jezikŠtampe;
//	}



  //--------------TO STRING METODA--------------
	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", brTelefona=" + brTelefona + ", radnoVreme="
				+ radnoVreme + ", admini=" + admini + ", bibliotekari=" + bibliotekari + ", knjige=" + knjige
				+ ", iznajmljivanje=" + iznajmljivanje + ", članovi=" + članovi + ", primerakKnjige=" + primerakKnjige
				+ "]";
	}

//--------------GETERI I SETERI--------------
	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getBrTelefona() {
		return brTelefona;
	}


	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}


	public LocalTime getRadnoVreme() {
		return radnoVreme;
	}


	public void setRadnoVreme(LocalTime radnoVreme) {
		this.radnoVreme = radnoVreme;
	}


	public ArrayList<Administrator> getAdmini() {
		return admini;
	}


	public void setAdmini(ArrayList<Administrator> admini) {
		this.admini = admini;
	}


	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}


	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}


	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}


	public ArrayList<Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanje;
	}


	public void setIznajmljivanje(ArrayList<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}


	public ArrayList<Član> getČlanovi() {
		return članovi;
	}


	public void setČlanovi(ArrayList<Član> članovi) {
		this.članovi = članovi;
	}


	public ArrayList<PrimerakKnjige> getPrimerakKnjige() {
		return primerakKnjige;
	}


	public void setPrimerakKnjige(ArrayList<PrimerakKnjige> primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}
//--------------PUN KONSTRUKTOR ZA BIBLIOTEKU--------------
	public Biblioteka(String naziv, String adresa, String brTelefona, LocalTime radnoVreme,
			ArrayList<Administrator> admini, ArrayList<Bibliotekar> bibliotekari, ArrayList<Knjiga> knjige,
			ArrayList<Iznajmljivanje> iznajmljivanje, ArrayList<Član> članovi, ArrayList<PrimerakKnjige> primerakKnjige,
			ArrayList<Žanr> žanrKnjige) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.brTelefona = brTelefona;
		this.radnoVreme = radnoVreme;
		this.admini = admini;
		this.bibliotekari = bibliotekari;
		this.knjige = knjige;
		this.iznajmljivanje = iznajmljivanje;
		this.članovi = članovi;
		this.primerakKnjige = primerakKnjige;
		this.žanrKnjige = žanrKnjige;
	}
//--------------PRAZAN KONSTRUKTOR ZA BIBLIOTEKU--------------
	public Biblioteka () {
		this.naziv = "";
		this.adresa = "";
		this.brTelefona = "";
		this.radnoVreme = null;
		this.admini = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.knjige = new ArrayList<Knjiga>();
		this.iznajmljivanje = new ArrayList<Iznajmljivanje>();
		this.članovi = new ArrayList<Član>();
		this.primerakKnjige = new ArrayList<PrimerakKnjige>();
		this.žanrKnjige = new ArrayList<Žanr>();
	}
	
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ADMINISTRATORA IZ FAJLA administratori.txt --------------
	protected void ucitajAdministratore() {
		try {
			File adminFile = new File("src/txt/administratori.txt");
			BufferedReader reader = new BufferedReader(new FileReader(adminFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				String ime = splitovanRed[0];
				String prezime = splitovanRed[1];
				String JMBG = splitovanRed[2];
				String adresa = splitovanRed[3];
				String id = splitovanRed[4];
				String plata = splitovanRed[5];
				double plataDouble = Double.parseDouble(plata);
				String korisničkoIme = splitovanRed[6];
				String lozinka = splitovanRed[7];
				String pol = splitovanRed[8];
				Boolean polBoolean = Boolean.parseBoolean(pol);	
				
		
				Administrator administrator = new Administrator(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, polBoolean);
				this.admini.add(administrator);
				
			}
			reader.close();
			} catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE BIBLIOTEKARA IZ FAJLA bibliotekari.txt --------------
	protected void ucitajBibliotekare() {
		try {
			File bibliotekarFile = new File("src/txt/bibliotekari.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekarFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				String ime = splitovanRed[0];
				String prezime = splitovanRed[1];
				String JMBG = splitovanRed[2];
				String adresa = splitovanRed[3];
				String id = splitovanRed[4];
				String plata = splitovanRed[5];
				double plataDouble = Double.parseDouble(plata);
				String korisničkoIme = splitovanRed[6];
				String lozinka = splitovanRed[7];
				String pol = splitovanRed[8];
				Boolean polBoolean = Boolean.parseBoolean(pol);	
				
		
				Bibliotekar bibliotekar = new Bibliotekar(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, polBoolean);
				this.bibliotekari.add(bibliotekar);
				
			}
			reader.close();
			} catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS ADMINISTRATORA U FAJL administratori.txt --------------
	protected void upisiAdministratore() {
		
		String adminLinija = "";
		for (Administrator administrator : this.admini) {
			adminLinija += administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJMBG() + "|" + administrator.getAdresa() + "|" + 
					administrator.getId() + "|" + administrator.getPlata() + "|" + administrator.getKorisničkoIme() + "|" + administrator.getLozinka() + "|" + administrator.isPol() + "\n";
		}
		try {
			File adminFile = new File("src/txt/administratori.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(adminFile));
			writer.write(adminLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS BIBLIOTEKARA U FAJL bibliotekari.txt --------------
protected void upisiBibliotekare() {
		
		String bibliotekarLinija = "";
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			bibliotekarLinija += bibliotekar.getIme() + "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa() + "|" + 
					bibliotekar.getId() + "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisničkoIme() + "|" + bibliotekar.getLozinka() + "|" + bibliotekar.isPol() + "\n";
		}
		try {
			File bibliotekarFile = new File("src/txt/bibliotekari.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(bibliotekarFile));
			writer.write(bibliotekarLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
	}
		

	}
}
	
    

