package com.entity.tsp;

import java.util.List;

/**
 * @author liucui
 */

public class TravellingSalesmanProblem {
    private String type;
    private int size;
    private List<Integer> cityIdList;
    private List<City> cityList;

    public TravellingSalesmanProblem(){}

    public TravellingSalesmanProblem(String type, int size, List<Integer> cityIdList, List<City> cityList){
        this.type = type;
        this.size = size;
        this.cityIdList = cityIdList;
        this.cityList = cityList;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type=" + type +
                "size=" + size +
                ", cityIdList=" + cityIdList +
                ", cityList=" + cityList +
                '}';
    }
}
