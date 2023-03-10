package com.entity.tsp;

/**
 * @author liucui
 */
public class City {
    private Double x;
    private Double y;
    public City(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
