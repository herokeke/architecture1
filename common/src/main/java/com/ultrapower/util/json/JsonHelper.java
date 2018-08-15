package com.ultrapower.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by User on 2018/8/10.
 */
public class JsonHelper {


    private JsonHelper(){}

    public static String object2str(Object obj){
        String retStr = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            retStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return retStr;
    }

    public static Object str2object(String str,Class cls){
        Object retObj = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            retObj = mapper.readValue(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retObj;
    }

}
