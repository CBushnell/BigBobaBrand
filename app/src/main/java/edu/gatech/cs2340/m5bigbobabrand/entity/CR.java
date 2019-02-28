package edu.gatech.cs2340.m5bigbobabrand.entity;

/**
 * @author Chieng Chang
 * @version 1.0
 *
 * enum class to hold CR (a condition when prices of resources are low) values
 */
public enum CR {
    LOTSOFWATER("DROUGHT", 0),
    RICHFAUNA("RICH-FAUNA", 1),
    RICHSOIL("RICH-SOIL", 2),
    MINERALRICH("MINERAL-RICH", 3),
    ARTISTIC("ARTISTIC", 4),
    WARLIKE("WARLIKE", 5),
    LOTSOFHERBS("LOTS-OF-HERBS", 6),
    WEIRDMUSHROOMS("WEIRD-MUSHROOMS", 7);

    private String CRname;
    private int CRnum;

    CR(String CRname, int CRnum) {
        this.CRname = CRname;
        this.CRnum = CRnum;
    }

    /**
     * getter method for CR name
     * @return CR name
     */
    public String getCRName() {
        return CRname;
    }

    /**
     * getter method for CR num
     * @return CR num
     */
    public int getCRnum() {
        return CRnum;
    }
}
