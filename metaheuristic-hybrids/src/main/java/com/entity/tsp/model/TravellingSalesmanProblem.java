package com.entity.tsp.model;

import java.util.List;
import java.util.Map;

/**
 * @author liucui
 */

public class TravellingSalesmanProblem {
    private List<Integer> cityIdList;
    private List<City> cityList;
    private Map<Integer, City> cityMap;

    public TravellingSalesmanProblem(){}

    public TravellingSalesmanProblem(List<Integer> cityIdList, List<City> cityList, Map<Integer, City> cityMap){
        this.cityIdList = cityIdList;
        this.cityList = cityList;
        this.cityMap = cityMap;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public void setCityMap(Map<Integer, City> cityMap) {
        this.cityMap = cityMap;
    }

    public void setCityIdList(List<Integer> cityIdList) {
        this.cityIdList = cityIdList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public Map<Integer, City> getCityMap() {
        return cityMap;
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
                "cityIdList=" + cityIdList +
                ", cityList=" + cityList +
                ", cityMap=" + cityMap +
                '}';
    }
}
