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
    public String naziv;
    public String adresa;
    public String brTelefona;
    public LocalTime radniDanOd;
    public LocalTime radniDanDo;
    public LocalTime subotaOd;
    public LocalTime subotaDo;
    public ArrayList<Administrator> admini; 
    public ArrayList<Bibliotekar> bibliotekari;
    public ArrayList<Knjiga> knjige;
    public ArrayList<Iznajmljivanje> iznajmljivanje;
    public ArrayList<Član> članovi;
    public ArrayList<TipČlanarine> tipČlanarine; 
    public ArrayList<PrimerakKnjige> primerakKnjige;
    public ArrayList<Žanr> žanrKnjige;
    public ArrayList<Biblioteka> biblioteka;
  
//--------------PUN KONSTRUKTOR ZA BIBLIOTEKU--------------
	public Biblioteka(String naziv, String adresa, String brTelefona, LocalTime radniDanOd, LocalTime radniDanDo, LocalTime subotaOd, LocalTime subotaDo,
			ArrayList<Administrator> admini, ArrayList<Bibliotekar> bibliotekari, ArrayList<Knjiga> knjige,
			ArrayList<Iznajmljivanje> iznajmljivanje, ArrayList<Član> članovi, ArrayList<TipČlanarine> tipČlanarine, ArrayList<PrimerakKnjige> primerakKnjige,
			ArrayList<Žanr> žanrKnjige) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.brTelefona = brTelefona;
		this.radniDanOd = radniDanOd;
		this.radniDanDo = radniDanDo;
		this.subotaOd = subotaOd;
		this.subotaDo = subotaDo;
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
		this.radniDanOd = null;
		this.radniDanDo = null;
		this.subotaOd = null;
		this.subotaDo = null;
		this.admini = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.knjige = new ArrayList<Knjiga>();
		this.iznajmljivanje = new ArrayList<Iznajmljivanje>();
		this.članovi = new ArrayList<Član>();
		this.primerakKnjige = new ArrayList<PrimerakKnjige>();
		this.žanrKnjige = new ArrayList<Žanr>();
		this.tipČlanarine = new ArrayList<TipČlanarine>();
	}
	
	
	
	
	
	public String getNaziv() {
		return naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public String getBrTelefona() {
		return brTelefona;
	}
	public LocalTime getRadniDanOd() {
		return radniDanOd;
	}
	public LocalTime getRadniDanDo() {
		return radniDanDo;
	}
	public LocalTime getSubotaOd() {
		return subotaOd;
	}
	public LocalTime getSubotaDo() {
		return subotaDo;
	}
	public ArrayList<Administrator> getAdmini() {
		return admini;
	}
	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	public ArrayList<Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanje;
	}
	public ArrayList<Član> getČlanovi() {
		return članovi;
	}
	public ArrayList<TipČlanarine> getTipČlanarine() {
		return tipČlanarine;
	}
	public ArrayList<PrimerakKnjige> getPrimerakKnjige() {
		return primerakKnjige;
	}
	public ArrayList<Žanr> getŽanrKnjige() {
		return žanrKnjige;
	}
	public ArrayList<Biblioteka> getBiblioteka() {
		return biblioteka;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}
	public void setRadniDanOd(LocalTime radniDanOd) {
		this.radniDanOd = radniDanOd;
	}
	public void setRadniDanDo(LocalTime radniDanDo) {
		this.radniDanDo = radniDanDo;
	}
	public void setSubotaOd(LocalTime subotaOd) {
		this.subotaOd = subotaOd;
	}
	public void setSubotaDo(LocalTime subotaDo) {
		this.subotaDo = subotaDo;
	}
	public void setAdmini(ArrayList<Administrator> admini) {
		this.admini = admini;
	}
	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}
	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}
	public void setIznajmljivanje(ArrayList<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}
	public void setČlanovi(ArrayList<Član> članovi) {
		this.članovi = članovi;
	}
	public void setTipČlanarine(ArrayList<TipČlanarine> tipČlanarine) {
		this.tipČlanarine = tipČlanarine;
	}
	public void setPrimerakKnjige(ArrayList<PrimerakKnjige> primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}
	public void setŽanrKnjige(ArrayList<Žanr> žanrKnjige) {
		this.žanrKnjige = žanrKnjige;
	}
	public void setBiblioteka(ArrayList<Biblioteka> biblioteka) {
		this.biblioteka = biblioteka;
	}
	
	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", brTelefona=" + brTelefona + ", radniDanOd="
				+ radniDanOd + ", radniDanDo=" + radniDanDo + ", subotaOd=" + subotaOd + ", subotaDo=" + subotaDo
				+ ", admini=" + admini + ", bibliotekari=" + bibliotekari + ", knjige=" + knjige + ", iznajmljivanje="
				+ iznajmljivanje + ", članovi=" + članovi + ", tipČlanarine=" + tipČlanarine + ", primerakKnjige="
				+ primerakKnjige + ", žanrKnjige=" + žanrKnjige + "]";
	}
	//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ADMINISTRATORA IZ FAJLA administratori.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE BIBLIOTEKARA IZ FAJLA bibliotekari.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ČLANOVA IZ FAJLA članovi.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE ŽANRA IZ FAJLA žanrovi.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE KNJIGA IZ FAJLA knjige.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE TIPA ČLANARINE IZ FAJLA članarina.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE PRIMERAKA KNJIGA IZ FAJLA primerciKnjiga.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UČITAVANJE EVIDENCIJE O IZNAJMLJIVANJU IZ FAJLA iznajmljivanje.txt --------------
//--------------SLEDEĆA METODA SLUŽI ZA UPIS ADMINISTRATORA U FAJL administratori.txt --------------
	public void upisiAdministratore() {
		
		String adminLinija = "";
		for (Administrator administrator : this.admini) {
			adminLinija += administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJMBG() + "|" + administrator.getAdresa() + "|" + 
					administrator.getId() + "|" + administrator.getPlata() + "|" + administrator.getKorisničkoIme() + "|" + administrator.getLozinka() + "|" + administrator.getPol() + "|" + administrator.isJeObrisan() + "\n";
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
	
	public ArrayList<Administrator> dobaviNeobrisaneAdmine(){
		this.ucitajAdministratore();
		ArrayList<Administrator> neobrisaniAdmini = new ArrayList<Administrator>();
		for (Administrator admin : this.admini) {
			if(!admin.isJeObrisan()) {
				neobrisaniAdmini.add(admin);
			}
		}
		return neobrisaniAdmini;
	}
	
	
	
	public ArrayList<Član> dobaviNeobrisaneČlanove(){
		this.učitajČlanove();
		ArrayList<Član> neobrisaniČlanovi = new ArrayList<Član>();
		for (Član član : this.članovi) {
			if(!član.isJeObrisan()) {
				neobrisaniČlanovi.add(član);
			}
		}
		return neobrisaniČlanovi;
	}
	
	public ArrayList<TipČlanarine> dobaviNeobrisaneČlanarine(){
		this.učitajTipČlanarine();
		ArrayList<TipČlanarine> neobrisaneČlanarine = new ArrayList<TipČlanarine>();
		for (TipČlanarine članarina : this.tipČlanarine) {
			if(!članarina.isjeObrisan()) {
				neobrisaneČlanarine.add(članarina);
			}
		}
		return neobrisaneČlanarine;
	}
	
	public ArrayList<Knjiga> dobaviNeobrisaneKnjige(){
		this.učitajKnjige();
		ArrayList<Knjiga> neobrisaneKnjige = new ArrayList<Knjiga>();
		for (Knjiga knjiga : this.knjige) {
			if(!knjiga.isJeObrisan()) {
				neobrisaneKnjige.add(knjiga);
			}
		}
		return neobrisaneKnjige;
	}
	
	public ArrayList<PrimerakKnjige> dobaviNeobrisanePrimerke(){
		this.učitajPrimerkeKnjiga();
		ArrayList<PrimerakKnjige> neobrisaniPrimerci = new ArrayList<PrimerakKnjige>();
		for (PrimerakKnjige primerak : this.primerakKnjige) {
			if(!primerak.isJeObrisan()) {
				neobrisaniPrimerci.add(primerak);
			}
		}
		return neobrisaniPrimerci;
	}
	
	public ArrayList<PrimerakKnjige> dobaviNeiznajmljenePrimerke(){
		ArrayList<PrimerakKnjige> neiznajmljeniPrimerci = new ArrayList<PrimerakKnjige>();
		for(PrimerakKnjige primerak : this.dobaviNeobrisanePrimerke()) {
			if(!primerak.isIznajmljenost()) {
				neiznajmljeniPrimerci.add(primerak);
			}
		}
		return neiznajmljeniPrimerci;
	}
	
	public ArrayList<Žanr> dobaviNeobrisaneŽanrove(){
		this.učitajŽanrove();
		ArrayList<Žanr> neobrisaniŽanrovi = new ArrayList<Žanr>();
		for (Žanr žanr : this.žanrKnjige) {
			if(!žanr.isJeObrisan()) {
				neobrisaniŽanrovi.add(žanr);
			}
		}
		return neobrisaniŽanrovi;
	}
	
	public ArrayList<Iznajmljivanje> dobaviNeobrisanaIznajmljivanja(){
		this.učitajIznajmljivanje();
		ArrayList<Iznajmljivanje> neobrisanaIznajmljivanja = new ArrayList<Iznajmljivanje>();
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			if(!iznajmljivanje.isJeObrisan()) {
				neobrisanaIznajmljivanja.add(iznajmljivanje);
			}
		}
		return neobrisanaIznajmljivanja;
	}
	
//--------------SLEDEĆA METODA SLUŽI ZA UPIS BIBLIOTEKARA U FAJL bibliotekari.txt --------------
	public void upisiBibliotekare() {
			
			String bibliotekarLinija = "";
			for (Bibliotekar bibliotekar : this.bibliotekari) {
				bibliotekarLinija += bibliotekar.getIme() + "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa() + "|" + 
						bibliotekar.getId() + "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisničkoIme() + "|" + bibliotekar.getLozinka() + "|" + bibliotekar.getPol() + "|" + bibliotekar.isJeObrisan() + "\n";
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
	
	public ArrayList<Bibliotekar> dobaviNeobrisaneBibliotekare(){
		this.ucitajBibliotekare();
		ArrayList<Bibliotekar> neobrisaniBibliotekari = new ArrayList<Bibliotekar>();
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			if(!bibliotekar.isJeObrisan()) {
				neobrisaniBibliotekari.add(bibliotekar);
			}
		}
		return neobrisaniBibliotekari;
	}
//--------------SLEDEĆA METODA SLUŽI ZA UPIS ČLANOVA U FAJL članovi.txt --------------
	public void upišiČlanove() {
			
			String članLinija = "";
			for (Član član : this.članovi) {
				članLinija += član.getIme() + "|" + član.getPrezime() + "|" + član.getJMBG() + "|" + član.getAdresa() + "|" + 
						član.getId() + "|" + član.getBrojČlanskeKarte() + "|" + član.getDatumPoslednjeUplate() + "|" + član.getBrojMeseciVaženjaUplate() + "|" + član.isAktivan() + "|" + član.getPol() + "|" + član.getTipČlanarine().getId() + "|" + član.isJeObrisan() + "\n";
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
	public void upišiŽanrove() {
		
		String žanrLinija = "";
		for (Žanr žanr : this.žanrKnjige) {
			žanrLinija += žanr.getOznaka() + "|" + žanr.getOpis() + "|" + žanr.getId() + "|" + žanr.isJeObrisan() + "\n";
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
	public void upišiČlanarinu() {
		
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
	public void upišiKnjigu() {
		
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
	public void upišiPrimerakKnjige() {
		
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
	public void upisiIznajmljivanje() {
		
		String iznajmljivanjeLinija = "";
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			String sveKnjige = "";
			for(PrimerakKnjige pk : iznajmljivanje.getPrimerci()) {
				sveKnjige += pk.getId() + ";";
			}
			
			
			iznajmljivanjeLinija += iznajmljivanje.getId() + "|" + iznajmljivanje.getDatumIznajmljivanja() + "|" + iznajmljivanje.getDatumVraćanja() + "|" + iznajmljivanje.getZaposleni().getId() + "|" + 
					iznajmljivanje.getČlan().getId() + "|" + sveKnjige + "|" + iznajmljivanje.isJeObrisan() + "\n";
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
//--------------CRUD-abilnost BIBLIOTEKA--------------
	public void ucitajBiblioteku() {
		try  {
			File bibliotekaFile = new File("src/txt/biblioteka.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekaFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");

				naziv = splitovanRed[0];
				adresa = splitovanRed[1];
				brTelefona = splitovanRed[2];
				radniDanOd = LocalTime.parse(splitovanRed[3]);
				subotaOd = LocalTime.parse(splitovanRed[4]);
				radniDanDo = LocalTime.parse(splitovanRed[5]);
				subotaDo = LocalTime.parse(splitovanRed[6]);
							
				Biblioteka biblioteka = new Biblioteka(naziv, adresa, brTelefona, radniDanOd, radniDanDo, subotaOd, subotaDo, admini, bibliotekari, knjige, iznajmljivanje, članovi, tipČlanarine, primerakKnjige, žanrKnjige);
				this.biblioteka.add(biblioteka);
				
			}
			reader.close();
			} catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//--------------CRUD-abilnost ADMIN--------------
	public void ucitajAdministratore() {
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
				Pol pol = Pol.valueOf(splitovanRed[8]);
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[9]);
				
				
				
				Administrator administrator = new Administrator(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, pol, jeObrisan);
				boolean check = true;
				for (Administrator admin : this.admini) {
					if(admin.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {
					this.admini.add(administrator);					
				}
				
				
			}
			reader.close();
			} catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//---------------------------------------------------
	public void noviAdmin(String id, String jmbg, String korisnickoIme, String [] izmene, Boolean[] logIzmene, Double[] doubleIzmene, Pol[] polIzmene) {
		this.ucitajAdministratore();
		for (Administrator admin : this.admini) {
			if (admin.getId().equals(id)) {
				if(admin.getJMBG().equals(jmbg)){
					if(admin.getKorisničkoIme().equals(korisnickoIme)) {
						System.out.println("Admin sa tim podacima već postoji!");
					}
				}
			}
		}
		Administrator administrator = new Administrator();
		
		administrator.setIme(izmene[0]);
		administrator.setPrezime(izmene[1]);
		administrator.setJMBG(izmene[2]);
		administrator.setAdresa(izmene[3]);
		administrator.setId(izmene[4]);
		administrator.setPlata(doubleIzmene[5]);
		administrator.setKorisničkoIme(izmene[6]);
		administrator.setLozinka(izmene[7]);
		administrator.setPol(polIzmene[8]);
		administrator.setJeObrisan(false);
		
		this.admini.add(administrator);
		this.upisiAdministratore();
	}

//---------------------------------------------------
	public void brisanjeAdmina(String id) {
		this.ucitajAdministratore();
		for (Administrator admin : this.admini) {
			if (admin.getId().equals(id)) {
				admin.setJeObrisan(true);
			}
		}
		this.upisiAdministratore();
	}
//---------------------------------------------------
	public void ažurirajAdmina(String id, String [] izmene, Double [] doubleIzmene, Pol [] polIzmene) {
		this.ucitajAdministratore();
		for (Administrator admin : this.admini) {
			if (admin.getId().equals(id)) {
				admin.setIme(izmene[0]);
				admin.setPrezime(izmene[1]);
				admin.setAdresa(izmene[3]);
				admin.setPlata(doubleIzmene[5]);
				admin.setKorisničkoIme(izmene[6]);
				admin.setLozinka(izmene[7]);
				admin.setPol(polIzmene[8]);
			}
		}
		this.upisiAdministratore();
	}
//--------------CRUD-abilnost BIBLIOTEKAR--------------
	public void ucitajBibliotekare() {
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
				Pol pol = Pol.valueOf(splitovanRed[8]);
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[9]);
				
				Bibliotekar bibliotekar = new Bibliotekar(ime, prezime, JMBG, adresa, id, plataDouble, korisničkoIme, lozinka, pol, jeObrisan);
				boolean check = true;
				for (Bibliotekar bibl : this.bibliotekari) {
					if(bibl.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {
					this.bibliotekari.add(bibliotekar);									
				}
				
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//---------------------------------------------------
	public void noviBibliotekar(String id, String jmbg, String korisnickoIme, String [] izmene, Boolean[] logIzmene, Double[] doubleIzmene, Pol[] polIzmene) {
		this.ucitajBibliotekare();
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			if (bibliotekar.getId().equals(id)) {
				if(bibliotekar.getJMBG().equals(jmbg)){
					if(bibliotekar.getKorisničkoIme().equals(korisnickoIme)) {
						System.out.println("Bibliotekar sa tim podacima već postoji!");
					}
				}
			}
		}
		Bibliotekar bibliotekar = new Bibliotekar();
		
		bibliotekar.setIme(izmene[0]);
		bibliotekar.setPrezime(izmene[1]);
		bibliotekar.setJMBG(izmene[2]);
		bibliotekar.setAdresa(izmene[3]);
		bibliotekar.setId(izmene[4]);
		bibliotekar.setPlata(doubleIzmene[5]);
		bibliotekar.setKorisničkoIme(izmene[6]);
		bibliotekar.setLozinka(izmene[7]);
		bibliotekar.setPol(polIzmene[8]);
		bibliotekar.setJeObrisan(false);
		
		this.bibliotekari.add(bibliotekar);
		this.upisiBibliotekare();
	}

//---------------------------------------------------
	public void brisanjeBibliotekara(String id) {
		this.ucitajBibliotekare();
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			if (bibliotekar.getId().equals(id)) {
				bibliotekar.setJeObrisan(true);
			}
		}
		this.upisiBibliotekare();
	}
//---------------------------------------------------
	public void ažurirajBibliotekara(String id, String [] izmene, Double [] doubleIzmene, Pol [] polIzmene) {
		this.ucitajBibliotekare();
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			if (bibliotekar.getId().equals(id)) {
				bibliotekar.setIme(izmene[0]);
				bibliotekar.setPrezime(izmene[1]);
				bibliotekar.setAdresa(izmene[3]);
				bibliotekar.setPlata(doubleIzmene[5]);
				bibliotekar.setKorisničkoIme(izmene[6]);
				bibliotekar.setLozinka(izmene[7]);
				bibliotekar.setPol(polIzmene[8]);
			}
		}
		this.upisiBibliotekare();
	}
//--------------CRUD-abilnost ŽANR--------------
	public void učitajŽanrove() {
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
				boolean check = true;
				for (Žanr ž : this.žanrKnjige) {
					if(ž.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {
					this.žanrKnjige.add(žanr);									
				}
				
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//---------------------------------------------------
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
//---------------------------------------------------
	public void brisanjeŽanr(String id) {
		this.učitajŽanrove();
		for (Žanr žanr : this.žanrKnjige) {
			if (žanr.getId().equals(id)) {
				žanr.setJeObrisan(true);
				this.upišiŽanrove();
			}
		}
	}
//---------------------------------------------------
	public void ažurirajŽanr(String id, String [] izmene) {
		this.učitajŽanrove();
		for (Žanr žanr : this.žanrKnjige) {
			if (žanr.getId().equals(id)) {
				žanr.setOpis(izmene[0]);
				žanr.setOznaka(izmene[1]);
			}
		}
		this.upišiŽanrove();
	}
	
//--------------CRUD-abilnost TIP ČLANARINE--------------
	public void učitajTipČlanarine() {
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
				
				boolean check = true;
				for (TipČlanarine tc : this.tipČlanarine) {
					if(tc.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {								
					this.tipČlanarine.add(tipČlanarine);
				}
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
	}
//---------------------------------------------------
	public void noviTipČlanarine(String [] izmene, Integer [] izmeneCene) {
		this.učitajTipČlanarine();
		for (TipČlanarine članarina : this.tipČlanarine) {
			if(članarina.getId().equals(izmene[0])) {
				if(članarina.getNaziv().equals(izmene[1])) {
					System.out.println("Tip članarine već postoji!");
					return;
				}
			}
		}
		
		TipČlanarine članarina = new TipČlanarine();
		
		članarina.setId(izmene[0]);
		članarina.setNaziv(izmene[1]);
		članarina.setCena(izmeneCene[2]);
		članarina.setjeObrisan(false);
		
		this.tipČlanarine.add(članarina);
		this.upišiČlanarinu();
	}
//---------------------------------------------------
	public void brisanjeČlanarine(String id) {
		this.učitajTipČlanarine();
		for (TipČlanarine članarina : this.tipČlanarine) {
			if (članarina.getId().equals(id)) {
				
				članarina.setjeObrisan(true);
			}
		}
	}
//---------------------------------------------------
	public void ažurirajČlanarinu(String id, String [] izmene, Integer [] izmeneCena) {
		this.učitajTipČlanarine();
		for (TipČlanarine članarina : this.tipČlanarine) {
			if (članarina.getId().equals(id)) {
				članarina.setNaziv(izmene[1]);
				članarina.setCena(izmeneCena[2]);
			}
		}
		this.upišiČlanarinu();
	}
//--------------CRUD-abilnost KNJIGA--------------	
	public void učitajKnjige() {
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
				boolean check = true;
				for (Knjiga k : this.knjige) {
					if(k.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {								
					this.knjige.add(knjiga);					
				}
			}
			
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//---------------------------------------------------
	public void novaKnjiga(String [] izmene, Integer [] intIzmene, Žanr [] zanrIzmene) {
		this.učitajKnjige();
		for (Knjiga knjiga : this.knjige) {
			if(knjiga.getId().equals(izmene[0])) {
				if(knjiga.getOriginalniNaslov().equals(izmene[2])) {
					System.out.println("Knjiga već postoji!");
					return;	
				}
			}
		}
		
		Knjiga knjiga = new Knjiga();
		

		knjiga.setId(izmene[0]);
		knjiga.setNaslov(izmene[1]);
		knjiga.setOriginalniNaslov(izmene[2]);
		knjiga.setGodinaObjavljivanja(intIzmene[3]);
		knjiga.setOpis(izmene[4]);
		knjiga.setJezikOriginala(izmene[5]);
		knjiga.setAutor(izmene[6]);
		knjiga.setŽanr(zanrIzmene[7]);
		knjiga.setJeObrisan(false);
		
		
		this.knjige.add(knjiga);
		this.upišiKnjigu();
	}
//---------------------------------------------------
	public void brisanjeKnjige(String id) {
		this.učitajKnjige();
		for (Knjiga knjiga : this.knjige) {
			if (knjiga.getId().equals(id)) {
				
				knjiga.setJeObrisan(true);
				this.upišiKnjigu();
			}
		}
	}
//---------------------------------------------------
	public void ažurirajKnjigu(String id, String [] izmene) {
		this.učitajKnjige();
		for (Knjiga knjiga : this.knjige) {
			if (knjiga.getId().equals(id)) {
				knjiga.setNaslov(izmene[1]);
				knjiga.setOpis(izmene[4]);
			}
		}
		this.upišiKnjigu();
	}
//--------------CRUD-abilnost PRIMERAK KNJIGE--------------
	public void učitajPrimerkeKnjiga() {
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
				
				boolean check = true;
				for (PrimerakKnjige pk : this.primerakKnjige) {
					if(pk.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {								
					this.primerakKnjige.add(primerakKnjige);
				}
				
			}
			reader.close(); 
		}
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
	}
//---------------------------------------------------
	public void novPrimerak(String [] izmene, Integer [] intIzmene, Jezik [] jezikIzmene, TipPoveza [] povezIzmene, Knjiga [] knjigaIzmene) {
		this.učitajPrimerkeKnjiga();
		for (PrimerakKnjige primerak : this.primerakKnjige) {
			if(primerak.getId().equals(izmene[0])) {
				System.out.println("Primerak već postoji!");
				return;	
			}
		}
		
		PrimerakKnjige primerak = new PrimerakKnjige();
		
		primerak.setId(izmene[0]);
		primerak.setGodinaŠtampe(intIzmene[1]);
		primerak.setIznajmljenost(false);
		primerak.setNazivKnjige(izmene[3]);
		primerak.setBrojStrana(intIzmene[4]);
		primerak.setJeObrisan(false);
		primerak.setJezikŠtampe(jezikIzmene[6]);
		primerak.setKnjiga(knjigaIzmene[7]);
		primerak.setTipPoveza(povezIzmene[8]);
		
		this.primerakKnjige.add(primerak);
		this.upišiPrimerakKnjige();
	}
//---------------------------------------------------
	public void brisanjePrimerka(String id) {
		this.učitajPrimerkeKnjiga();
		for (PrimerakKnjige primerak : this.primerakKnjige) {
			if (primerak.getId().equals(id)) {
				
				primerak.setJeObrisan(true);
				this.upišiPrimerakKnjige();
			}
		}
	}
//---------------------------------------------------
	public void ažurirajPrimerak(String id, String [] izmene, boolean iznajmljenostIzmene, TipPoveza [] povezIzmene) {
		this.učitajPrimerkeKnjiga();
		for (PrimerakKnjige primerak : this.primerakKnjige) {
			if (primerak.getId().equals(id)) {
				primerak.setIznajmljenost(iznajmljenostIzmene);
				primerak.setNazivKnjige(izmene[3]);
				primerak.setTipPoveza(povezIzmene[8]);
			}
		}
		this.upišiPrimerakKnjige();
	}
//--------------CRUD-abilnost ČLAN--------------
	public void učitajČlanove() {
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
				Pol pol = Pol.valueOf(splitovanRed[9]);
				
				
				TipČlanarine tipČlanarine = null;
				String tipČlanarineID = splitovanRed[10];
				for (TipČlanarine t : this.tipČlanarine) {
					if (t.getId().equals(tipČlanarineID)) {
						tipČlanarine = t;
					}
				}
				
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[11]);
				
				Član član = new Član(ime, prezime, JMBG, adresa, id, brojČlanskeKarte, datumPoslednjeUplate, važenjeUplate, aktivan, pol, tipČlanarine, jeObrisan);		
				boolean check = true;
				for (Član č : this.članovi) {
					if(č.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {								
					this.članovi.add(član);
				}
		
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}	
	}
//---------------------------------------------------
	public void noviČlan(String [] izmene, Integer [] intIzmene, LocalDate [] datumIzmene, Pol [] polIzmene, TipČlanarine [] članarinaIzmene) {
		this.učitajČlanove();
		for (Član član : this.članovi) {
			if(član.getId().equals(izmene[0])) {
				if(član.getBrojČlanskeKarte().equals(izmene[5])) {
					if(član.getJMBG().equals(izmene[2])) {
						System.out.println("Član već postoji!");
						return;	
					}
				}
			}
		}
		
		Član član = new Član();
		
		član.setId(izmene[0]);
		član.setIme(izmene[1]);
		član.setPrezime(izmene[2]);
		član.setJMBG(izmene[3]);
		član.setAdresa(izmene[4]);
		član.setBrojČlanskeKarte(izmene[5]);
		član.setDatumPoslednjeUplate(datumIzmene[6]);
		član.setBrojMeseciVaženjaUplate(intIzmene[7]);
		član.setAktivan(true);
		član.setPol(polIzmene[8]);
		član.setTipČlanarine(članarinaIzmene[9]);
		član.setJeObrisan(false);
		
		this.članovi.add(član);
		this.upišiČlanove();
	}
//---------------------------------------------------
	public void brisanjeČlana(String id) {
		this.učitajČlanove();
		for (Član član : this.članovi) {
			if (član.getId().equals(id)) {
				
				član.setJeObrisan(true);
				this.upišiČlanove();
			}
		}
	}
//---------------------------------------------------
	public void ažurirajČlana(String id, String [] izmene, Integer [] intIzmene, TipČlanarine članarinaIzmene, LocalDate [] datumIzmene, boolean aktivnost, Pol [] polIzmene) {
		this.učitajČlanove();
		for (Član član : this.članovi) {
			if (član.getId().equals(id)) {
				član.setIme(izmene[0]);
				član.setPrezime(izmene[1]);
				član.setAdresa(izmene[3]);
				član.setBrojČlanskeKarte(izmene[5]);
				član.setDatumPoslednjeUplate(datumIzmene[6]);
				član.setBrojMeseciVaženjaUplate(intIzmene[7]);
				član.setAktivan(aktivnost);
				član.setPol(polIzmene[9]);
				član.setTipČlanarine(članarinaIzmene);
			}
		}
		this.upišiČlanove();
	}
//--------------CRUD-abilnost IZNAJMLJIVANJE--------------
	public void učitajIznajmljivanje() {
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
				
				ArrayList<PrimerakKnjige> primerak = new ArrayList<PrimerakKnjige>();
				String strKnjige = splitovanRed[5];
				
				for (String idKnjige : strKnjige.split(";")) {
					
					for(PrimerakKnjige a : this.primerakKnjige) {
						if(a.getId().equals(idKnjige)) {
							primerak.add(a);
						}
						
					}
					
				}
				
				
				boolean jeObrisan = Boolean.parseBoolean(splitovanRed[6]);
				
						
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVraćanja, zaposleni, članovi, primerak, jeObrisan);
				boolean check = true;
				for (Iznajmljivanje i : this.iznajmljivanje) {
					if(i.getId().equals(id)) {
						check = false;
						break;
					}
				}
				if(check) {								
					this.iznajmljivanje.add(iznajmljivanje);					
				}
			}
			
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
	}
//---------------------------------------------------
	public void novoIznajmljivanje(String [] izmene, Zaposleni [] zaposleniIzmene, ArrayList<PrimerakKnjige> primerakIzmene, LocalDate [] datumIzmene, Član [] članIzmene, boolean iznajmljenost, TipČlanarine [] članarinaIzmene) {
		this.učitajIznajmljivanje();
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			if(iznajmljivanje.getId().equals(izmene[0])) {
				if(iznajmljivanje.getČlan().equals(članIzmene[1])) {
					System.out.println("Iznajmljivanje već postoji!");
					return;	
				}
			}
		}
		
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
		
		iznajmljivanje.setId(izmene[0]);
		iznajmljivanje.setDatumIznajmljivanja(datumIzmene[1]);
		iznajmljivanje.setDatumVraćanja(datumIzmene[2]);
		iznajmljivanje.setZaposleni(zaposleniIzmene[3]);
		iznajmljivanje.setČlan(članIzmene[1]);
		iznajmljivanje.setPrimerci(primerakIzmene);
		iznajmljivanje.setJeObrisan(false);
		
		this.iznajmljivanje.add(iznajmljivanje);
		this.upisiIznajmljivanje();
	}
//---------------------------------------------------
	public void brisanjeIznajmljivanja(String id) {
		this.učitajIznajmljivanje();
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			if (iznajmljivanje.getId().equals(id)) {
				
				iznajmljivanje.setJeObrisan(true);
				for (PrimerakKnjige pk : iznajmljivanje.getPrimerci()) {
					pk.setIznajmljenost(false);
				}
				this.upisiIznajmljivanje();
			}
		}
	}
//---------------------------------------------------
	public void ažurirajIznajmljivanje(String id, LocalDate datumIzmene, ArrayList<PrimerakKnjige> primerakIzmene) {
		this.učitajIznajmljivanje();
		for (Iznajmljivanje iznajmljivanje : this.iznajmljivanje) {
			if (iznajmljivanje.getId().equals(id)) {
				for (PrimerakKnjige primerak : iznajmljivanje.getPrimerci()) {
					primerak.setIznajmljenost(false);
				}
				iznajmljivanje.setDatumVraćanja(datumIzmene);
				iznajmljivanje.setPrimerci(primerakIzmene);
				for (PrimerakKnjige primerak : iznajmljivanje.getPrimerci()) {
					primerak.setIznajmljenost(true);
				}
			}
		}
		this.upisiIznajmljivanje();
	}
}

