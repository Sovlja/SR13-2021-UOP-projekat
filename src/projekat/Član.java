package projekat;

import java.time.LocalDate;

/**
 * 
 */
public class Član extends Osoba {

    
    protected String brojČlanskeKarte;

    /**
     * 
     */
    protected LocalDate datumPoslednjeUplate;

    /**
     * 
     */
    protected int brojMeseciVaženjaUplate;

    /**
     * 
     */
    protected boolean aktivan;

	public Član(String ime, String prezime, String jMBG, String adresa, String id, String brojČlanskeKarte,
			LocalDate datumPoslednjeUplate, int brojMeseciVaženjaUplate, boolean aktivan) {
		super(ime, prezime, jMBG, adresa, id);
		this.brojČlanskeKarte = brojČlanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciVaženjaUplate = brojMeseciVaženjaUplate;
		this.aktivan = aktivan;
	}
	
	public Član() {
		super();
		this.brojČlanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciVaženjaUplate = 0;
		this.aktivan = false;
	}

	public String getBrojČlanskeKarte() {
		return brojČlanskeKarte;
	}

	public void setBrojČlanskeKarte(String brojČlanskeKarte) {
		this.brojČlanskeKarte = brojČlanskeKarte;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojMeseciVaženjaUplate() {
		return brojMeseciVaženjaUplate;
	}

	public void setBrojMeseciVaženjaUplate(int brojMeseciVaženjaUplate) {
		this.brojMeseciVaženjaUplate = brojMeseciVaženjaUplate;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	@Override
	public String toString() {
		return "Član [brojČlanskeKarte=" + brojČlanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseciVaženjaUplate=" + brojMeseciVaženjaUplate + ", aktivan=" + aktivan + ", ime=" + ime
				+ ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", id=" + id + "]";
	}

}