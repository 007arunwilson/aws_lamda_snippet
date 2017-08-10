package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import javax.json.*;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class SnippetFunctionHandlerTest {

    private static Object input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
    	
    	JsonObject json_s = Json.createObjectBuilder()
    		     .add("name", "Falco")
    		     .add("age", "12")
    		     .add("biteable", Boolean.FALSE).build();
        
    	String greeting = "Hello world!";
    	//int int_1 = 2;
    	
    	//Json json_obj

    	input = json_s;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testSnippetFunctionHandler() {
        SnippetFunctionHandler handler = new SnippetFunctionHandler();
        Context ctx = createContext();

        String output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals("Hello from Lambda!", output);
    }
}
