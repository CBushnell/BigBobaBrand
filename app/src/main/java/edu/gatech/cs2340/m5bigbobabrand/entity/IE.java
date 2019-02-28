package edu.gatech.cs2340.m5bigbobabrand.entity;

/** enum class to hold valid catastrophic events (IE) values
 * @author Charlie Comeau
 * @version 1.0
 */
public enum IE {
    DROUGHT("DROUGHT"),
    COLD("COLD"),
    CROPFAIL("CROP-FAIL"),
    WAR("WAR"),
    BOREDOM("BOREDOM"),
    PLAGUE("PLAGUE"),
    LACKOFWORK("LACK-OF-WORK"),
    RETIREMENT("RETIREMENT"),
    SNOWINATLANTA("SNOW-IN-ATLANTA!"),
    SADBOIHOURS("SAD-BOI-HOURS");

    private String IEname;

    private IE(String IEname) {
        this.IEname = IEname;
    }

    /**
     * getter method for IE name
     * @return IE name
     */
    public String getIEName() {
        return IEname;
    }

}
