package projekat;

/**
 * 
 */
public class Žanr {

    protected String oznaka;


    protected String opis;

    
    protected String id;


	public Žanr(String oznaka, String opis, String id) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
		this.id = id;
	}


	public Žanr() {
		super();
		this.oznaka = "";
		this.opis = "";
		this.id = "";
	}


	public String getOznaka() {
		return oznaka;
	}


	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Žanr [oznaka=" + oznaka + ", opis=" + opis + ", id=" + id + "]";
	}


	
    
	
    
}