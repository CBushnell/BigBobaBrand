package edu.gatech.cs2340.m5bigbobabrand.entity;
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        // x-coordinate of planet
        this.x = x;
        // y-coordinate of planet
        this.y = y;
    }

    /**
     * Set x-coordinate of planet
     * @param x x-coordinate of planet
     */
    public void setX(int x) {
        if (x >= 0 && x <= 150) {
            this.x = x;
        }
    }

    /**
     * Set y-coordinate of planet
     * @param y y-coordinate of planet
     */
    public void setY(int y) {
        if (y >= 0 && y <= 100) {
            this.y = y;
        }
    }

    /**
     * Get x-coordinate of planet
     * @return x-coordinate of planet
     */
    public int getX() {
        return x;
    }

    /**
     * Get y-coordinate of planet
     * @return y-coordinate of planet
     */
    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + x + y;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Coordinates coor = (Coordinates) o;
        return x == coor.x && y == coor.y;
    }
}
