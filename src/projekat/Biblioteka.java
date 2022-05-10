package projekat;

import java.time.LocalTime;
import java.util.*;

public class Biblioteka {

    public Biblioteka() {
    }

    /**
     * 
     */
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
    protected Set<Administratori> admini;

    /**
     * 
     */
    protected Set<Bibliotekari> bibliotekari;

    /**
     * 
     */
    protected Set<Knjige> knjige;

}