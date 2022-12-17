package com.entity.tsp;

import java.util.List;

/**
 * @author liucui
 */

public class TravellingSalesmanProblem {
    private int size;
    private List<Integer> cityIdList;
    private List<City> cityList;

    public TravellingSalesmanProblem(){}

    public TravellingSalesmanProblem(int size, List<Integer> cityIdList, List<City> cityList){
        this.size = size;
        this.cityIdList = cityIdList;
        this.cityList = cityList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }


    public void setCityIdList(List<Integer> cityIdList) {
        this.cityIdList = cityIdList;
    }

    public List<City> getCityList() {
        return cityList;
    }


    public List<Integer> getCityIdList() {
        return cityIdList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "TravellingSalesmanProblem{" +
                "size=" + size +
                ", cityIdList=" + cityIdList +
                ", cityList=" + cityList +
                '}';
    }
}
