
import java.util.*;

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
    protected localDate datumPoslednjeUplate;

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
    public enum Tip članarine {
        PENZIONERSKA - 100,
        DECA DO 14 GODINA - 150,
        OSTALI ČLANOVI - 250
    }

}