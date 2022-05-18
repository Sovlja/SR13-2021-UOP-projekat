package projekat;

import java.time.LocalDate;

/**
 * 
 */
public class Član extends Osoba {

    
	protected String brojČlanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciVaženjaUplate;
    protected boolean aktivan;
	protected TipČlanarine tipČlanarine;
	

	public Član(String ime, String prezime, String jMBG, String adresa, String id, String brojČlanskeKarte,
			LocalDate datumPoslednjeUplate, int brojMeseciVaženjaUplate, boolean aktivan, boolean pol, TipČlanarine tipČlanarine, boolean jeObrisan) {
		super(ime, prezime, jMBG, adresa, id, pol, jeObrisan);
		this.brojČlanskeKarte = brojČlanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciVaženjaUplate = brojMeseciVaženjaUplate;
		this.aktivan = aktivan;
		this.tipČlanarine = tipČlanarine;
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

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public int getBrojMeseciVaženjaUplate() {
		return brojMeseciVaženjaUplate;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public TipČlanarine getTipČlanarine() {
		return tipČlanarine;
	}


	public void setBrojČlanskeKarte(String brojČlanskeKarte) {
		this.brojČlanskeKarte = brojČlanskeKarte;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public void setBrojMeseciVaženjaUplate(int brojMeseciVaženjaUplate) {
		this.brojMeseciVaženjaUplate = brojMeseciVaženjaUplate;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public void setTipČlanarine(TipČlanarine tipČlanarine) {
		this.tipČlanarine = tipČlanarine;
	}

	@Override
	public String toString() {
		return "Član [jeMuško=" + jeMuško + ", brojČlanskeKarte=" + brojČlanskeKarte + ", datumPoslednjeUplate="
				+ datumPoslednjeUplate + ", brojMeseciVaženjaUplate=" + brojMeseciVaženjaUplate + ", aktivan=" + aktivan
				+ ", tipČlanarine=" + tipČlanarine + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG
				+ ", adresa=" + adresa + ", id=" + id + "]";
	}

	

}