package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.util.Random;

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
    private Coordiate coordinate;

    public SolarSystem(String name, TechLevel techLevel, ResourceLevel resourceLevel,
                       Coordinate coordinate) {
        this.name = name;
        this.techLevel = techLevel;
        this.resourceLevel = resourceLevel;
        this.coordinate = coordinate;
    }

    @Override
    public int hashCode() {
        ;
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

    public Coordiate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordiate coordinate) {
        this.coordinate = coordinate;
    }
}
