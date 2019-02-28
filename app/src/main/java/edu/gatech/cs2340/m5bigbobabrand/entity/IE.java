package edu.gatech.cs2340.m5bigbobabrand.entity;

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

    IE(String IEname) {
        this.IEname = IEname;
    }

}
