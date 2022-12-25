package com.supermarket.pos.util;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class MessageUtil {
    public JsonObjectBuilder buildJsonObject(String state, String message, String data){

        JsonObjectBuilder obj = Json.createObjectBuilder();

        obj.add("state", state);
        obj.add("message", message);
        obj.add("data", data);

        return obj;

    }
}
