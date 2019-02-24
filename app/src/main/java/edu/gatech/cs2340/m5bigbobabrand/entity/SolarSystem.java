package edu.gatech.cs2340.m5bigbobabrand.entity;

/**
 * @author Connor Bushnell
 * @version 1.0
 *
 * A SolarSystem class for holding planets (currently synonymous with planets)
 */
public class SolarSystem {

    private String name;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private Coordinates coordinate;

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 17;

    //TechLevel probabilities
    private static final int PREAGRICULTURE_CHANCE = 50;
    private static final int AGRICULTURE_CHANCE = 60;
    private static final int MEDIEVAL_CHANCE = 70;
    private static final int RENAISSANCE_CHANCE = 85;
    private static final int EARLYINDUSTRIAL_CHANCE = 90;
    private static final int INDUSTRIAL_CHANCE = 94;
    private static final int POSTINDUSTRIAL_CHANCE = 97;
    private static final int HITECH_CHANCE = 99;

    //Resource probabilities
    private static final int NOSPECIALRESOURCES = 40;
    private static final int DESERT = 50;
    private static final int MINERALRICH = 55;
    private static final int MINERALPOOR = 60;
    private static final int LOTSOFWATER = 62;
    private static final int RICHSOIL = 66;
    private static final int RICHFAUNA = 72;
    private static final int LIFELESS = 85;
    private static final int WEIRDMUSHROOMS = 87;
    private static final int LOTSOFHERBS = 92;
    private static final int ARTISTIC = 96;
    private static final int WARLIKE = 100;

    public SolarSystem(Coordinates coordinate) {
        this.name = randomName();
        this.techLevel = randomTech();
        this.resourceLevel = resourceLevel;
        this.coordinate = coordinate;
    }

    private String randomName() {
        int length = (int) (Math.random() * NAME_MAX_LENGTH) + NAME_MIN_LENGTH;
        String name = "";
        for (int i = 0; i < length; ++i) {
            String letter = "" + (char) ((Math.random() * 26) + 97);
            if (i == 0) {
                letter = letter.toUpperCase();
            }
            name += letter;
        }
        return name;
    }

    private TechLevel randomTech() {
        int probability = (int) (Math.random() * 101) + 1;
        if (probability < PREAGRICULTURE_CHANCE) {
            return TechLevel.PREAGRICULTURE;
        } if (probability >= PREAGRICULTURE_CHANCE && probability < AGRICULTURE_CHANCE) {
            return TechLevel.PREAGRICULTURE;
        } if (probability >= AGRICULTURE_CHANCE && probability < MEDIEVAL_CHANCE) {
            return TechLevel.AGRICULTURE;
        } if (probability >= MEDIEVAL_CHANCE && probability < RENAISSANCE_CHANCE) {
            return TechLevel.MEDIEVAL;
        } if (probability >= RENAISSANCE_CHANCE && probability < EARLYINDUSTRIAL_CHANCE) {
            return TechLevel.RENAISSANCE;
        } if (probability >= EARLYINDUSTRIAL_CHANCE && probability < INDUSTRIAL_CHANCE) {
            return TechLevel.EARLYINDUSTRIAL;
        } if (probability >= INDUSTRIAL_CHANCE && probability < POSTINDUSTRIAL_CHANCE) {
            return TechLevel.INDUSTRIAL;
        } if (probability >= POSTINDUSTRIAL_CHANCE && probability < HITECH_CHANCE) {
            return TechLevel.POSTINDUSTRIAL;
        }
        return TechLevel.HITECH;
    }

    private ResourceLevel randomResource() {
        int probability = (int) (Math.random() * 101) + 1;
        if (probability < NOSPECIALRESOURCES) {
            return ResourceLevel.NOSPECIALRESOURCES;
        } if (probability >= NOSPECIALRESOURCES && probability < DESERT) {
            return ResourceLevel.DESERT;
        } if (probability >= DESERT && probability < MINERALRICH) {
            return ResourceLevel.MINERALRICH;
        } if (probability >= MINERALRICH && probability < MINERALPOOR) {
            return ResourceLevel.MINERALPOOR;
        } if (probability >= MINERALPOOR && probability < LOTSOFWATER) {
            return ResourceLevel.LOTSOFWATER;
        } if (probability >= LOTSOFWATER && probability < RICHSOIL) {
            return ResourceLevel.RICHSOIL;
        } if (probability >= RICHSOIL && probability < RICHFAUNA) {
            return ResourceLevel.RICHFAUNA;
        } if (probability >= RICHFAUNA && probability < LIFELESS) {
            return ResourceLevel.LIFELESS;
        } if (probability >= LIFELESS && probability < WEIRDMUSHROOMS) {
            return ResourceLevel.WEIRDMUSHROOMS;
        } if (probability >= WEIRDMUSHROOMS && probability < LOTSOFHERBS) {
            return ResourceLevel.LOTSOFHERBS;
        } if (probability >= LOTSOFHERBS && probability < ARTISTIC) {
            return ResourceLevel.ARTISTIC;
        }
        return ResourceLevel.WARLIKE;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public ResourceLevel getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }
}
