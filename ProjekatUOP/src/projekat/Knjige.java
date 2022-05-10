
import java.util.*;

/**
 * 
 */
public class Knjige {

    /**
     * Default constructor
     */
    public Knjige() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String naslov;

    /**
     * 
     */
    protected String originalniNaslov;

    /**
     * 
     */
    protected int godinaObjavljivanja;

    /**
     * 
     */
    protected String opis;

    /**
     * 
     */
    protected String jezikOriginala;

    /**
     * 
     */
    protected Pisac autor;

    /**
     * 
     */
    protected Žanr žanr;

    /**
     * 
     */
    protected Set<Primerak knjige> primerak;

}