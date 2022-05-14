package projekat;

import java.time.LocalTime;
import java.util.*;

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

    /**
     * 
     */
    protected LocalTime radnoVreme;

    /**
     * 
     */
    protected Set<Administrator> admini;

    /**
     * 
     */
    protected Set<Bibliotekar> bibliotekari;

    /**
     * 
     */
    protected Set<Knjiga> knjige;
    
    
    protected Set<Iznajmljivanje> iznajmljivanje;
    
    
    protected Set<Član> članovi;
    
    
    protected Set<PrimerakKnjige> primerakKnjige;


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


	public Set<Administrator> getAdmini() {
		return admini;
	}


	public void setAdmini(Set<Administrator> admini) {
		this.admini = admini;
	}


	public Set<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}


	public void setBibliotekari(Set<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}


	public Set<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(Set<Knjiga> knjige) {
		this.knjige = knjige;
	}


	public Set<Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanje;
	}


	public void setIznajmljivanje(Set<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}


	public Set<Član> getČlanovi() {
		return članovi;
	}


	public void setČlanovi(Set<Član> članovi) {
		this.članovi = članovi;
	}


	public Set<PrimerakKnjige> getPrimerakKnjige() {
		return primerakKnjige;
	}


	public void setPrimerakKnjige(Set<PrimerakKnjige> primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}


	@Override
	public String toString() {
		return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", brTelefona=" + brTelefona + ", radnoVreme="
				+ radnoVreme + ", admini=" + admini + ", bibliotekari=" + bibliotekari + ", knjige=" + knjige
				+ ", iznajmljivanje=" + iznajmljivanje + ", članovi=" + članovi + ", primerakKnjige=" + primerakKnjige
				+ "]";
	}


	

	
    

}