package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Biblioteka {
    protected String naziv;
    protected String adresa;
    protected String brTelefona;
    protected LocalTime radnoVreme;
    protected ArrayList<Administrator> admini; 
    protected ArrayList<Bibliotekar> bibliotekari;
    protected ArrayList<Knjiga> knjige;
    protected ArrayList<Iznajmljivanje> iznajmljivanje;
    protected ArrayList<Član> članovi;   
    protected ArrayList<PrimerakKnjige> primerakKnjige;
    protected ArrayList<Žanr> žanrKnjige;

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
	
	public ArrayList<Žanr> getŽanrKnjige() {
		return žanrKnjige;
	}


	public void setŽanrKnjige(ArrayList<Žanr> žanrKnjige) {
		this.žanrKnjige = žanrKnjige;
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
				double plataDouble = Double.parseDouble(splitovanRed[5]);
				String korisničkoIme = splitovanRed[6];
				String lozinka = splitovanRed[7];
				Boolean pol = Boolean.parseBoolean(splitovanRed[8]);
							
				Bibliotekar bibliotekar = new Bibliotekar(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, pol);
				this.bibliotekari.add(bibliotekar);
				
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ČLANOVA IZ FAJLA članovi.txt --------------
	protected void učitajČlanove() {
		try {
			File članFile = new File("src/txt/članovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(članFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String ime = splitovanRed[0];
				String prezime = splitovanRed[1];
				String JMBG = splitovanRed[2];
				String adresa = splitovanRed[3];
				String id = splitovanRed[4];
				String brojČlanskeKarte = splitovanRed[5];
				
				LocalDate datumPoslednjeUplate = LocalDate.now();
				datumPoslednjeUplate.toString();
				String poslednjaUplata = splitovanRed[6];

				int važenjeUplate = Integer.parseInt(splitovanRed[7]);
				boolean aktivan = Boolean.parseBoolean(splitovanRed[8]);
				Boolean pol = Boolean.parseBoolean(splitovanRed[9]);
				
				String strTipČlanarine = splitovanRed[10];
				TipČlanarine tipČlanarine = TipČlanarine.OSTALI;
								
				for (TipČlanarine tip : TipČlanarine.values()) {
					if (tip.name().equalsIgnoreCase(strTipČlanarine)) {
						tipČlanarine = tip;
					}
				}
				Član član = new Član(ime, prezime, JMBG, adresa, id, brojČlanskeKarte, datumPoslednjeUplate, važenjeUplate, aktivan, pol, tipČlanarine);
				this.članovi.add(član);
		
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ŽANRA IZ FAJLA žanrovi.txt --------------
	protected void učitajŽanrove() {
		try {
			File žanrFile = new File("src/txt/žanrovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(žanrFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				String oznaka = splitovanRed[0];
				String opis = splitovanRed[1];
				String id = splitovanRed[2];
				Žanr žanr = new Žanr(oznaka, opis, id);
				this.žanrKnjige.add(žanr);
				
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE KNJIGA IZ FAJLA knjige.txt --------------
	protected void učitajKnjige() {
		try {
			File knjigaFile = new File("src/txt/knjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(knjigaFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String id = splitovanRed[0];
				String naslov = splitovanRed[1];
				String originalniNaslov = splitovanRed[2];
				int godinaObjavljivanja = Integer.parseInt(splitovanRed[3]);
				String opis = splitovanRed[4];
				String jezikOriginala = splitovanRed[5];
				String autor = splitovanRed[6];
				
				Žanr žanr = null;
				String žanrID = splitovanRed[7];
				
				for (Žanr ž : this.žanrKnjige) {
					if (ž.getId().equals(žanrID)) {
						žanr = ž;
					}
				}
				
				
				
				
				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, godinaObjavljivanja, opis, jezikOriginala, autor, žanr);
			}
			
			reader.close();
			} 
		catch (IOException e) {
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
				writer.newLine();
				writer.close();
				
			}catch(IOException e){
				System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
			
	
		}
}
	
    

