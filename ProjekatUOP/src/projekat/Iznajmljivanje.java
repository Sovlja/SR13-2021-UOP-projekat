
import java.util.*;

/**
 * 
 */
public class Iznajmljivanje {

    /**
     * Default constructor
     */
    public Iznajmljivanje() {
    }

    /**
     * 
     */
    protected String imeZaposlenog;

    /**
     * 
     */
    protected String imeČlana;

    /**
     * 
     */
    protected LocalDate datumIznajmljivanja;

    /**
     * 
     */
    protected LocalDate datumVraćanja;

    /**
     * 
     */
    protected Administratori admini;

    /**
     * 
     */
    protected Bibliotekari bibliotekari;

    /**
     * 
     */
    protected Članovi članovi;

    /**
     * 
     */
    protected Set<Primerak knjige> iznajmljeno;

}