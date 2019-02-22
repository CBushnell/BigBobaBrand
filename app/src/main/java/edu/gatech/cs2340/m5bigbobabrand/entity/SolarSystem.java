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
    private static final int INDUSTRIAL_CHANCE = 95;
    private static final int POSTINDUSTRIAL_CHANCE = 98;

    public SolarSystem(Coordinates coordinate) {
        this.name = randomName();
        this.techLevel = techLevel;
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
        } else if (probability >= PREAGRICULTURE_CHANCE && probability < AGRICULTURE_CHANCE) {

        } else if (probability >= AGRICULTURE_CHANCE && probability < MEDIEVAL_CHANCE) {

        } else if (probability >= MEDIEVAL_CHANCE && probability < RENAISSANCE_CHANCE) {

        } else if (probability >= RENAISSANCE_CHANCE && probability < EARLYINDUSTRIAL_CHANCE) {

        } else if (probability >= EARLYINDUSTRIAL_CHANCE
                    && probability < AGRICULTURE_CHANCE) {

        }
    }

    private ResourceLevel randomResource() {
        return null;
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
