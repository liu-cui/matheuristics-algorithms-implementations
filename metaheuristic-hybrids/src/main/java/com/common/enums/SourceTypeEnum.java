package com.common.enums;

import java.util.Arrays;

/**
 * @author liucui
 */

public enum SourceTypeEnum {
    /**
     * tsp source data and opt tour solution
     */
    TSP_ATT_48(0, "att48.tsp.gz"),
    TSP_ATT_48_OPT_TOUR(1, "att48.opt.tour.gz");

    /**
     * vrp source data and opt tour solution
     */


    private Integer code;
    private String name;

    SourceTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SourceTypeEnum getEnumByName(String name){
        return Arrays.stream(SourceTypeEnum.values())
                .filter(s->name.equals(s.getName()))
                .findFirst()
                .orElse(null);
    }
}
