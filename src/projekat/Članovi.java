package projekat;

import java.time.LocalDate;

/**
 * 
 */
public class Članovi extends Osoba {

    /**
     * Default constructor
     */
    public Članovi() {
    }

    /**
     * 
     */
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


    /**
     * 
     */
    public enum Tipčlanarine {
        PENZIONERSKA_100, 
        DECA_150,
        OSTALIČLANOVI
    }

}