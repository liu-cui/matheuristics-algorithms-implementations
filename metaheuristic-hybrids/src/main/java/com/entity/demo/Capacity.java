package com.entity.demo;

import java.util.List;

/**
 * @author liucui
 * @date 2022/12/27 18:59
 * @desc Capacity
 */

public class Capacity {
    private String name;
    private Integer numcli;
    private Integer numserv;
    private List<List<Integer>> cost;
    private List<List<Integer>> req;
    private List<Integer> cap;

    public Capacity(){}

    public Capacity(String name, Integer numcli, Integer numserv, List<List<Integer>> cost, List<List<Integer>> req, List<Integer> cap) {
        this.name = name;
        this.numcli = numcli;
        this.numserv = numserv;
        this.cost = cost;
        this.req = req;
        this.cap = cap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumcli() {
        return numcli;
    }

    public void setNumcli(Integer numcli) {
        this.numcli = numcli;
    }

    public Integer getNumserv() {
        return numserv;
    }

    public void setNumserv(Integer numserv) {
        this.numserv = numserv;
    }

    public List<List<Integer>> getCost() {
        return cost;
    }

    public void setCost(List<List<Integer>> cost) {
        this.cost = cost;
    }

    public List<List<Integer>> getReq() {
        return req;
    }

    public void setReq(List<List<Integer>> req) {
        this.req = req;
    }

    public List<Integer> getCap() {
        return cap;
    }

    public void setCap(List<Integer> cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "name='" + name + '\'' +
                ", numcli=" + numcli +
                ", numserv=" + numserv +
                ", cost=" + cost +
                ", req=" + req +
                ", cap=" + cap +
                '}';
    }
}
