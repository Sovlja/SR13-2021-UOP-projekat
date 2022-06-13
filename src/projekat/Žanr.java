package projekat;

/**
 * 
 */
public class Žanr {

    protected String oznaka;
    protected String opis;
    protected String id;
    protected boolean jeObrisan;

	public Žanr(String oznaka, String opis, String id, boolean jeObrisan) {
		this.oznaka = oznaka;
		this.opis = opis;
		this.id = id;
		this.jeObrisan = jeObrisan;
	}


	public Žanr() {
		this.oznaka = "";
		this.opis = "";
		this.id = "";
		this.jeObrisan = false;
	}


	public String getOznaka() {
		return oznaka;
	}


	public String getOpis() {
		return opis;
	}


	public String getId() {
		return id;
	}


	public boolean isJeObrisan() {
		return jeObrisan;
	}


	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}


	@Override
	public String toString() {
		return "Žanr [oznaka=" + oznaka + ", opis=" + opis + ", id=" + id + ", jeObrisan=" + jeObrisan + "]";
	}


	


	
    
	
    
}