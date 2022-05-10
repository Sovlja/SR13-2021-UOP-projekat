package projekat;

public class Primerak_Knjige {

   
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
    public enum Jezikštampe {
        SRPSKI_JEZIK,
        ENGLESKI_JEZIK,
        NEMAČKI_JEZIK,
        RUSKI_JEZIK,
        FRANCUSKI_JEZIK
    }

    /**
     * 
     */
    public enum Tippoveza {
        MEKI_POVEZ,
        TVRDI_POVEZ
    }

}