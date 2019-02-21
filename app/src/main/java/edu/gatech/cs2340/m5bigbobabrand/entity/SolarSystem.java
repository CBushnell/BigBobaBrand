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

    public SolarSystem(Coordinates coordinate) {
        this.name = randomName();
        this.techLevel = techLevel;
        this.resourceLevel = resourceLevel;
        this.coordinate = coordinate;
    }

    private String randomName() {
        int length = (int) (Math.random() * 17) + 3;
        String name = "";
        for (int i = 0; i < length; ++i) {
            String letter = "" + (char) ((Math.random() * 123) + 97);
            if (i == 0) {
                letter.toUpperCase();
            }
            name += letter;
        }
        return name;
    }

    private TechLevel randomTech() {
        return null;
    }

    private ResourceLevel randomResource() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals() {

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

    public Coordiates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordiates coordinate) {
        this.coordinate = coordinate;
    }
}
