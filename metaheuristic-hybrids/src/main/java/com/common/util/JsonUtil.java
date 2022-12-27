package com.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * @author liucui
 * @date 2022/12/27 18:44
 * @desc JSON工具类
 */

public class JsonUtil {
    private static final ObjectMapper MAPPER = newMapper();

    public static ObjectMapper newMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

    public static String toJson(Object obj){
        String result;
        try{
            result = MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            result = e.getMessage();
        }
        return result;
    }

    public static <T> T toObject(String json, Class<T> clazz){
        try {
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
