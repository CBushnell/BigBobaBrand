package edu.gatech.cs2340.m5bigbobabrand.entity;

public enum Item {
    WATER(0,0,2,30,3,4, IE.DROUGHT, ResourceLevel.LOTSOFWATER, ResourceLevel.DESERT, 30, 50,0),
    FURS(0,0,0,250,10,10, IE.COLD,ResourceLevel.RICHFAUNA, ResourceLevel.LIFELESS, 230, 280,1),
    FOOD(1,0,1,100,5,5, IE.CROPFAIL, ResourceLevel.RICHSOIL, ResourceLevel.POORSOIL, 90, 160,2),
    ORE(2,2,3,350,20,10, IE.WAR, ResourceLevel.MINERALRICH, ResourceLevel.MINERALPOOR, 350, 420,3),
    GAMES(3,1,6,250,-10,5, IE.WAR, ResourceLevel.ARTISTIC, ResourceLevel.NEVER, 160, 270,4),
    FIREARMS(3,1,5,1250,-75,100, IE.BOREDOM, ResourceLevel.WARLIKE, ResourceLevel.NEVER, 600, 1100,5),
    MEDICINE(4,1,6,650,-20,10, IE.PLAGUE, ResourceLevel.LOTSOFHERBS, ResourceLevel.NEVER, 400, 700,6),
    MACHINES(4,3,5,900,-30,5, IE.LACKOFWORK,ResourceLevel.NEVER, ResourceLevel.NEVER, 600, 800,7),
    NARCOTICS(5,0,5,3500,-125,150, IE.BOREDOM,ResourceLevel.WEIRDMUSHROOMS, ResourceLevel.NEVER, 2000, 3000,8),
    ROBOTS(6,4,7,5000,-150,100, IE.LACKOFWORK, ResourceLevel.NEVER, ResourceLevel.NEVER, 3500, 5000,9);

    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int var;
    private IE cat;
    private ResourceLevel hap;
    private ResourceLevel plan;
    private int MTL;
    private int MTH;
    private int ords;


    Item(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
         IE cat, ResourceLevel hap, ResourceLevel plan, int MTL, int MTH, int ords) {
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.var = var;
        this.cat = cat;
        this.hap = hap;
        this.plan = plan;
        this.MTL = MTL;
        this.MTH = MTH;
        this.ords = ords;
    }

    public int getMTLP() {
        return MTLP;
    }

    public void setMTLP(int MTLP) {
        this.MTLP = MTLP;
    }

    public int getMTLU() {
        return MTLU;
    }

    public void setMTLU(int MTLU) {
        this.MTLU = MTLU;
    }

    public int getTTP() {
        return TTP;
    }

    public void setTTP(int TTP) {
        this.TTP = TTP;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getIPL() {
        return IPL;
    }

    public void setIPL(int IPL) {
        this.IPL = IPL;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public IE getCat() {
        return cat;
    }

    public void setCat(IE cat) {
        this.cat = cat;
    }

    public ResourceLevel getHap() {
        return hap;
    }

    public void setHap(ResourceLevel hap) {
        this.hap = hap;
    }

    public ResourceLevel getPlan() {
        return plan;
    }

    public void setPlan(ResourceLevel plan) {
        this.plan = plan;
    }

    public int getMTL() {
        return MTL;
    }

    public void setMTL(int MTL) {
        this.MTL = MTL;
    }

    public int getMTH() {
        return MTH;
    }

    public void setMTH(int MTH) {
        this.MTH = MTH;
    }

    public int getOrds() {
        return ords;
    }

    public void setOrds(int ords) {
        this.ords = ords;
    }
}
