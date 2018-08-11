package com.ultrapower.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by User on 2018/8/10.
 */
public class JsonHelper {

    private JsonHelper(){}

    public static Object str2object(String str,Object obj){

        ObjectMapper mapper = new ObjectMapper();
        Object jobj= null;
        try {
            jobj = mapper.readValue(str,obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobj;
    }

}
