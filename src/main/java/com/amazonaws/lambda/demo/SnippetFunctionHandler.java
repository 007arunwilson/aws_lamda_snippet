package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import javax.json.*;
import java.io.*;
import javax.json.stream.*;
import javax.json.stream.JsonParser;
import javax.json.spi.*;
import java.lang.reflect.Field;
import java.util.List;
import org.glassfish.json.api.*;
import java.math.*;

public class SnippetFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        //context.getLogger().log("Input: " + input);
        
        final JsonParser parser = Json.createParser(new StringReader(input.toString()));
    	
        String key = null;
        String value = null;
        while (parser.hasNext()) {
            String parser_name = parser.next().name();
            switch (parser_name) {
               case "KEY_NAME":
                    key = parser.getString();
                    System.out.println(key);
                    break;
               case "VALUE_STRING":
                    String string = parser.getString();
                    System.out.println(string);
                    break;
               case "VALUE_NUMBER":
                   BigDecimal number = parser.getBigDecimal();
                   System.out.println(number);
                   break;
               case "VALUE_TRUE":
                   System.out.println(true);
                   break;
               case "VALUE_FALSE":
                   System.out.println(false);
                   break;
               }
            	
            
            context.getLogger().log("Parser Name: " + parser_name);
           }
           parser.close();
        //console.log(javax.json.stream.JsonParser));
        
        //Json input_;
        //Object in_ = input_.createReader('{}');
        
        //String result = input..toString();
        //context.getLogger().log(result);
        
        //Class cls = input.getClass();
        //String cls_name = cls.getName();
        
        //context.getLogger().log(cls_name);
        
        
        //Json json_ = input;
        
        //new JSONObject(input);
        
//        JsonReader jsonReader = Json.createReader(new StringReader("{\"name\":\"Falco\",\"age\":3,\"bitable\":false}"));
//        JsonObject jobj = jsonReader.readObject();
//        context.getLogger().log(jobj.asJsonArray().toString());
//        
//        final JsonParser parser = Json.createParser(input);
        		//Json.getJSONObject("LabelData").getString("slogan");

        // TODO: implement your handler
        return "Hello from Lambda!-";
    }

}
