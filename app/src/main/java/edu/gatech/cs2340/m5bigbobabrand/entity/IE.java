package edu.gatech.cs2340.m5bigbobabrand.entity;

/** enum class to hold valid catastrophic events (IE) values
 * @author Charlie Comeau
 * @version 1.0
 */
public enum IE {
    DROUGHT("DROUGHT", 0),
    COLD("COLD", 1),
    CROPFAIL("CROP-FAIL", 2),
    WAR("WAR", 3),
    BOREDOM("BOREDOM", 4),
    PLAGUE("PLAGUE", 5),
    LACKOFWORK("LACK-OF-WORK", 6),
    RETIREMENT("RETIREMENT", 7),
    SNOWINATLANTA("SNOW-IN-ATLANTA!", 8),
    SADBOIHOURS("SAD-BOI-HOURS", 9),
    NONE("NONE", 10);

    private String IEname;
    private int IEnum;

    IE(String IEname, int IEnum) {
        this.IEname = IEname;
        this.IEnum = IEnum;
    }

    /**
     * getter method for IE name
     * @return IE name
     */
    public String getIEName() {
        return IEname;
    }

    /**
     * getter method for IE num
     * @return IE num
     */
    public int getIEnum() {
        return IEnum;
    }

}
