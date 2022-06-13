package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    protected ArrayList<TipČlanarine> tipČlanarine; 
    protected ArrayList<PrimerakKnjige> primerakKnjige;
    protected ArrayList<Žanr> žanrKnjige;

  //--------------TO STRING METODA--------------
	
    @Override
    public String toString() {
    	return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", brTelefona=" + brTelefona + ", radnoVreme="
    			+ radnoVreme + ", admini=" + admini + ", bibliotekari=" + bibliotekari + ", knjige=" + knjige
    			+ ", iznajmljivanje=" + iznajmljivanje + ", članovi=" + članovi + ", tipČlanarine=" + tipČlanarine
    			+ ", primerakKnjige=" + primerakKnjige + ", žanrKnjige=" + žanrKnjige + "]";
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
	
	public ArrayList<TipČlanarine> getTipČlanarine() {
		return tipČlanarine;
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
			ArrayList<Iznajmljivanje> iznajmljivanje, ArrayList<Član> članovi, ArrayList<TipČlanarine> tipČlanarine, ArrayList<PrimerakKnjige> primerakKnjige,
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
		this.tipČlanarine = tipČlanarine;
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
		this.tipČlanarine = new ArrayList<TipČlanarine>();
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
				boolean pol = Boolean.parseBoolean(splitovanRed[8]);
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[9]);
				
				
				
				Administrator administrator = new Administrator(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, pol, jeObrisan);
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
				boolean pol = Boolean.parseBoolean(splitovanRed[8]);
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[9]);
				
//				MALE = TRUE 
//				FEMALE = FALSE
				
				Bibliotekar bibliotekar = new Bibliotekar(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, pol, jeObrisan);
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
				
				LocalDate datumPoslednjeUplate = LocalDate.parse(splitovanRed[6]);
				

				int važenjeUplate = Integer.parseInt(splitovanRed[7]);
				boolean aktivan = Boolean.parseBoolean(splitovanRed[8]);
				Boolean pol = Boolean.parseBoolean(splitovanRed[9]);
				
				
				TipČlanarine tipČlanarine = null;
				String tipČlanarineID = splitovanRed[10];
				for (TipČlanarine t : this.tipČlanarine) {
					if (t.getId().equals(tipČlanarineID)) {
						tipČlanarine = t;
					}
				}
				
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[11]);
				
				Član član = new Član(ime, prezime, JMBG, adresa, id, brojČlanskeKarte, datumPoslednjeUplate, važenjeUplate, aktivan, pol, tipČlanarine, jeObrisan);
				this.članovi.add(član);
		
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ŽANRA IZ FAJLA žanrovi.txt --------------
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
				
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[8]);
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, godinaObjavljivanja, opis, jezikOriginala, autor, žanr, jeObrisan);
				this.knjige.add(knjiga);
			}
			
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE TIPA ČLANARINE IZ FAJLA članarina.txt --------------
	protected void učitajTipČlanarine() {
		try {
			File tipČlanarineFile = new File("src/txt/članarina.txt");
			BufferedReader reader = new BufferedReader(new FileReader(tipČlanarineFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				String id = splitovanRed[0];
				String naziv = splitovanRed[1];
				int cena = Integer.parseInt(splitovanRed[2]);
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[3]);
				
				TipČlanarine tipČlanarine = new TipČlanarine(id, naziv, cena, jeObrisan);
				this.tipČlanarine.add(tipČlanarine);
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE PRIMERAKA KNJIGA IZ FAJLA primerciKnjiga.txt --------------
	protected void učitajPrimerkeKnjiga() {
		try {
			File primerakKnjigeFile = new File("src/txt/primerciKnjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(primerakKnjigeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");	
				int brojStrana = Integer.parseInt(splitovanRed[0]);
				int godinaObjavljivanja = Integer.parseInt(splitovanRed[1]);
				boolean jeIznajmljen = Boolean.parseBoolean(splitovanRed[2]);
				String naslov = splitovanRed[3];
				String id = splitovanRed[4];
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[5]);			
				Jezik jezik = Jezik.valueOf(splitovanRed[6]);
				TipPoveza tipPoveza = TipPoveza.valueOf(splitovanRed[8]);
				
				Knjiga knjiga = null;
				String knjigaID = splitovanRed[7];
				
				for (Knjiga k : this.knjige) {
					if (k.getId().equals(knjigaID)) {
						knjiga = k;
					}
				}
				
				PrimerakKnjige primerakKnjige = new PrimerakKnjige(brojStrana, godinaObjavljivanja, jeIznajmljen, naslov, id, jeObrisan, jezik, knjiga, tipPoveza);
				this.primerakKnjige.add(primerakKnjige);
			}
			
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE EVIDENCIJE O IZNAJMLJIVANJU IZ FAJLA iznajmljivanje.txt --------------
	protected void učitajIznajmljivanje() {
		try {
			File iznajmljivanjeFile = new File("src/txt/iznajmljivanje.txt");
			BufferedReader reader = new BufferedReader(new FileReader(iznajmljivanjeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String id = splitovanRed[0];
				LocalDate datumIznajmljivanja = LocalDate.parse(splitovanRed[1]);
				LocalDate datumVraćanja = LocalDate.parse(splitovanRed[2]);;
				
				
				Zaposleni zaposleni = null;
				String imeZaposlenogID = splitovanRed[3];
					
				for (Zaposleni z : this.bibliotekari) {
					if(z.getId().equals(imeZaposlenogID)){
						zaposleni = z;	
					}	
				}
				if (zaposleni == null) {
					for(Zaposleni z : this.admini) {
						if(z.getId().equals(imeZaposlenogID)) {
							zaposleni = z;
						}
					}
				}
				
				Član članovi = null;
				String strČlanovi = splitovanRed[4];
				
				for(Član a : this.članovi) {
					if(a.getId().equals(strČlanovi)) {
						članovi = a;
					}
				}
				
				PrimerakKnjige primerak = null;
				String strKnjige = splitovanRed[5];
				
				for(PrimerakKnjige a : this.primerakKnjige) {
					if(a.getId().equals(strKnjige)) {
						primerak = a;
					}
				}
				
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[6]);
				
						
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVraćanja, zaposleni, članovi, primerak, jeObrisan);
				this.iznajmljivanje.add(iznajmljivanje);
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
					administrator.getId() + "|" + administrator.getPlata() + "|" + administrator.getKorisničkoIme() + "|" + administrator.getLozinka() + "|" + administrator.isJeMuško() + "|" + administrator.isJeObrisan() + "\n";
		}
		try {
			File adminFile = new File("src/txt/administratori.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(adminFile));
			writer.write(adminLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS BIBLIOTEKARA U FAJL bibliotekari.txt --------------
	protected void upisiBibliotekare() {
			
			String bibliotekarLinija = "";
			for (Bibliotekar bibliotekar : this.bibliotekari) {
				bibliotekarLinija += bibliotekar.getIme() + "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa() + "|" + 
						bibliotekar.getId() + "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisničkoIme() + "|" + bibliotekar.getLozinka() + "|" + bibliotekar.isJeMuško() + "|" + bibliotekar.isJeObrisan() + "\n";
			}
			try {
				File bibliotekarFile = new File("src/txt/bibliotekari.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(bibliotekarFile));
				writer.write(bibliotekarLinija);
				writer.close();
				
			}catch(IOException e){
				System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
		}
			
	
		}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS ČLANOVA U FAJL članovi.txt --------------
	protected void upišiČlanove() {
			
			String članLinija = "";
			for (Član član : this.članovi) {
				članLinija += član.getIme() + "|" + član.getPrezime() + "|" + član.getJMBG() + "|" + član.getAdresa() + "|" + 
						član.getId() + "|" + član.getBrojČlanskeKarte() + "|" + član.getDatumPoslednjeUplate() + "|" + član.getBrojMeseciVaženjaUplate() + "|" + član.isAktivan() + "|" + član.isJeMuško() + "|" + član.getTipČlanarine().getId() + "|" + član.isJeObrisan() + "\n";
			}
			try {
				File članoviFile = new File("src/txt/članovi.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(članoviFile));
				writer.write(članLinija);
				writer.close();
				
			}catch(IOException e){
				System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
		}
			
	
		}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS ŽANROVA U FAJL žanrovi.txt --------------
	protected void upišiŽanrove() {
		
		String žanrLinija = "";
		for (Žanr žanr : this.žanrKnjige) {
			žanrLinija += žanr.getOznaka() + "|" + žanr.getOpis() + "|" + žanr.isJeObrisan() + "\n";
		}
		try {
			File žanrFile = new File("src/txt/žanrovi.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(žanrFile));
			writer.write(žanrLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS TIPOVA ČLANARINE U FAJL članarina.txt --------------
	protected void upišiČlanarinu() {
		
		String članarinaLinija = "";
		for (TipČlanarine tipČlanarine : this.tipČlanarine) {
			članarinaLinija += tipČlanarine.getId() + "|" + tipČlanarine.getNaziv() + "|" + tipČlanarine.getCena() + "|" + tipČlanarine.isjeObrisan() + "\n";
		}
		try {
			File članarinaFile = new File("src/txt/članarina.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(članarinaFile));
			writer.write(članarinaLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS KNJIGA U FAJL knjige.txt --------------
	protected void upišiKnjigu() {
		
		String knjigaLinija = "";
		for (Knjiga knjiga : this.knjige) {
			knjigaLinija += knjiga.getId() + "|" + knjiga.getNaslov() + "|" + knjiga.getOriginalniNaslov() + "|" + knjiga.getGodinaObjavljivanja() + "|" + knjiga.getOpis() + "|" + knjiga.getJezikOriginala() + "|" + knjiga.getAutor() + "|" + knjiga.getŽanr().getId() + "|" + knjiga.isJeObrisan() + "\n";
		}
		try {
			File knjigaFile = new File("src/txt/knjige.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(knjigaFile));
			writer.write(knjigaLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS PRIMERAKA KNJIGE U FAJL primerciKnjige.txt --------------
	protected void upišiPrimerakKnjige() {
		
		String primerakLinija = "";
		for (PrimerakKnjige primerak : this.primerakKnjige) {
			primerakLinija += primerak.getBrojStrana() + "|" + primerak.getGodinaŠtampe() + "|" + primerak.isIznajmljenost() + "|" + primerak.getNazivKnjige() + "|" + primerak.getId() + "|" + primerak.isJeObrisan() + "|" + primerak.getJezikŠtampe() + "|" + primerak.getKnjiga().getId() + "|" + primerak.getTipPoveza() + "\n";
		}
		try {
			File primerciFile = new File("src/txt/primerciKnjige.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(primerciFile));
			writer.write(primerakLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS IZNAJMLJIVANJA U FAJL iznajmljivanje.txt --------------
	protected void upisiIznajmljivanje() {
		
		String iznajmljivanjeLinija = "";
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			iznajmljivanjeLinija += iznajmljivanje.getId() + "|" + iznajmljivanje.getDatumIznajmljivanja() + "|" + iznajmljivanje.getDatumVraćanja() + "|" + iznajmljivanje.getZaposleni().getId() + "|" + 
					iznajmljivanje.getČlan().getId() + "|" + iznajmljivanje.getPrimerak().getId() + "|" + iznajmljivanje.isJeObrisan() + "\n";
		}
		try {
			File iznajmljivanjeFile = new File("src/txt/iznajmljivanje.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(iznajmljivanjeFile));
			writer.write(iznajmljivanjeLinija);
			writer.close();
			
		}catch(IOException e){
			System.out.println("Greska prilikom upisa u datoteku: " + e.getMessage());
	}
		

	}
//--------------CRUD-abilnost ŽANR--------------
//--------------CRUD-abilnost ŽANR--------------
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
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[3]);
				
				Žanr žanr = new Žanr(oznaka, opis, id, jeObrisan);
				this.žanrKnjige.add(žanr);
				
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
	
	public void ažurirajŽanr(String id, String [] izmene) {
		this.učitajŽanrove();
		for (Žanr žanr : this.žanrKnjige) {
			if (žanr.getId().equals(id)) {
				žanr.setOpis(izmene[1]);
				žanr.setOznaka(izmene[2]);
			}
		}
		this.upišiŽanrove();
	}


	public void brisanjeŽanr(String id) {
		this.učitajŽanrove();
		for (Žanr žanr : this.žanrKnjige) {
			if (žanr.getId().equals(id)) {
				žanr.setJeObrisan(true);
			}
		}
		this.upišiŽanrove();
	}
	
	
	public void noviŽanr(String [] izmene) {
		this.učitajŽanrove();
		for (Žanr ž : this.žanrKnjige) {
			if(ž.getId().equals(izmene[0])) {
				System.out.println("Žanr već postoji!");
				return;
			}
		}
		
		Žanr žanr = new Žanr();
		
		žanr.setId(izmene[0]);
		žanr.setOpis(izmene[1]);
		žanr.setOznaka(izmene[2]);
		žanr.setJeObrisan(false);
		
		this.žanrKnjige.add(žanr);
		this.upišiŽanrove();
	}
}
	