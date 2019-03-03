package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * @author Connor Bushnell
 * @version 1.0
 *
 * A SolarSystem class for holding planets (currently synonymous with planets)
 * Have markets where players can trade goods
 */
public class SolarSystem implements Serializable {

    private String name;
    private TechLevel techLevel;
    private ResourceLevel resourceLevel;
    private Coordinates coordinates;
    private PoliticalSystem politicalSystem;
    private Market market;
    private int id;

    private static final int HASH_SEED = 31;
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

    /**
     * Constructor for fully customizing SolarSystems.
     *
     * @param name The name of the SolarSystem
     * @param techLevel The Tech Level of the SolarSystem
     * @param resourceLevel The Resource Level of the SolarSystem
     * @param coordinates The coordinates of the SolarSystem within the universe
     */
    public SolarSystem(String name, TechLevel techLevel, ResourceLevel resourceLevel,
                       PoliticalSystem politicalSystem, Coordinates coordinates) {
        this.name = name;
        this.techLevel = techLevel;
        this.resourceLevel = resourceLevel;
        this.coordinates = coordinates;
        this.politicalSystem = politicalSystem;
        id = hashCode();
    }

    /**
     * Constructor for a SolarSystem. Generates random values for name, TechLevel, and ResourceLevel
     *
     * @param coordinates The coordinates the SolarSystem will be located at within the universe
     */
    public SolarSystem(Coordinates coordinates) {
        this(randomName(), randomTech(), randomResource(), randomPoliticalSystem(), coordinates);
    }

    /**
     * Generates a random name for a SolarSystem
     *
     * @return Randomly generated name
     */
    private static String randomName() {
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

    /**
     * Generates a random Tech Level for the SolarSystem
     *
     * @return Random tech level
     */
    private static TechLevel randomTech() {
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

    /**
     * Generates a random Resource Level for the SolarSystem
     *
     * @return
     */
    private static ResourceLevel randomResource() {
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

    /**
     * gives a random political system
     * @return a random political system
     */
    private static PoliticalSystem randomPoliticalSystem() {
        PoliticalSystem[] politicalSystemsArr = PoliticalSystem.values();
        return politicalSystemsArr[(int) (Math.random() * 17)];
    }


    @Override
    public int hashCode() {
        int base = HASH_SEED;
        base *= name.charAt(0);
        base *= name.charAt(name.length() - 1);
        base *= techLevel.getTechLevelNum();
        base *= resourceLevel.getResourceInt();
        base *= coordinates.getX();
        base *= coordinates.getY();
        return base;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        SolarSystem solsys = (SolarSystem) other;
        return (solsys.getName().equals(this.name) && solsys.getId() == this.id);
    }

    /**
     * @return SolarSystem's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Sets name of the SolarSystem
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Tech Level of the SolarSystem
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel Sets Tech Level of the SolarSystem
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @return SolarSystem's name
     */
    public ResourceLevel getResourceLevel() {
        return resourceLevel;
    }

    /**
     * @param resourceLevel Sets Resource Level of the SolarSystem
     */
    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
     * @return SolarSystem's coordinates;
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates Sets coordinates of the SolarSystem within the universe;
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * @param politicalSystem the political system to give the solar system
     */
    public void setPoliticalSystem(PoliticalSystem politicalSystem) {
        this.politicalSystem = politicalSystem;
    }

    /**
     *
     * @return the political system of the solar system
     */
    public PoliticalSystem getPoliticalSystem() {
        return this.politicalSystem;
    }


    /**
     * @return Id of the SolarSystem
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Sets of the id of the SolarSystem
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name + " at " + this.coordinates.toString() + " (" + this.resourceLevel.toString() + ", "
                + this.techLevel.toString() + ", " + this.politicalSystem.toString() + ")";
    }
}
