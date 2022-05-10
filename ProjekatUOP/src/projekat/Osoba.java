
import java.util.*;

/**
 * 
 */
public abstract class Osoba {

    /**
     * Default constructor
     */
    public Osoba() {
    }

    /**
     * 
     */
    protected String ime;

    /**
     * 
     */
    protected String prezime;

    /**
     * 
     */
    protected String JMBG;

    /**
     * 
     */
    protected String adresa;

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    public enum Pol {
        MUŠKI,
        ŽENSKI
    }

}