package com.entity.tsp.model;

import java.util.List;

/**
 * @author liucui
 */

public class TravellingSalesmanProblem {
    private List<Integer> cityIdList;
    private List<City> cityList;

    public TravellingSalesmanProblem(){}

    public TravellingSalesmanProblem(List<Integer> cityIdList, List<City> cityList){
        this.cityIdList = cityIdList;
        this.cityList = cityList;
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
                "cityIdList=" + cityIdList +
                ", cityList=" + cityList +
                '}';
    }
}
