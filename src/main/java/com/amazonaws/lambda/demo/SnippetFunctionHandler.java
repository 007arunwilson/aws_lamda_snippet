package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SnippetFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        JSONParser parser = new JSONParser();
        String input_stringified = input.toString();
        
        try {
        
        Object obj = parser.parse(input_stringified);
        context.getLogger().log(obj.toString());
        
        JSONObject jsonObject = (JSONObject) obj;
        
        context.getLogger().log(jsonObject.get("louis").toString());
        
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //context.getLogger().log("Input: " + input);
        // TODO: implement your handler
        return null;
    }

}
