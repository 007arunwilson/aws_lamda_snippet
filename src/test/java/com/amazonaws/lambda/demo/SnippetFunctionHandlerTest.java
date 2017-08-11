package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

import org.json.*;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class SnippetFunctionHandlerTest {

    private static Object input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
    	
    	String input_string = "{\"bucket_name\":\"louis-philipy\"}";
    	input = input_string;
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
