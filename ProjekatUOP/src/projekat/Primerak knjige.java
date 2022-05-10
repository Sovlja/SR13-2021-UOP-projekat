
import java.util.*;

/**
 * 
 */
public class Primerak knjige {

    /**
     * Default constructor
     */
    public Primerak knjige() {
    }

    /**
     * 
     */
    protected int brojStrana;

    /**
     * 
     */
    protected int godinaŠtampe;

    /**
     * 
     */
    protected boolean iznajmljenost;

    /**
     * 
     */
    protected String nazivKnjige;

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    public enum Jezik štampe {
        SRPSKI JEZIK,
        ENGLESKI JEZIK,
        NEMAČKI JEZIK,
        RUSKI JEZIK,
        FRANCUSKI JEZIK
    }

    /**
     * 
     */
    public enum Tip poveza {
        MEKI POVEZ,
        TVRDI POVEZ
    }

}