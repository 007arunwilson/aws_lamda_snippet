package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.lambda.demo.ConfigProperties;
//import com.amazonaws.services.s3.model.AmazonS3Exception;
//import com.amazonaws.services.s3.model.Bucket;
//import java.util.List;

public class SnippetFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        JSONParser parser = new JSONParser();
        String input_stringified = input.toString();
        
        ConfigProperties conf_property_inst = new ConfigProperties();
        
        try {
			conf_property_inst.consoleConfiguration();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
        
//        
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAIUWD4QO5AD4SJ5WQ", "VErBdUSW8MSuqYxTemBee3zLRMZZk3irk7yfqYst");
//        final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                .withRegion("us-east-1")
//                .build();
//        
//        
//        
//        try {
//        
//        Object obj = parser.parse(input_stringified);
//        context.getLogger().log(obj.toString());
//        
//        JSONObject jsonObject = (JSONObject) obj;
//        
//        String bucket_name = jsonObject.get("bucket_name").toString();
//        
//        
//        
//        
//        //Bucket b = null;
//        if (s3Client.doesBucketExist(bucket_name)) {
////            System.out.format("Bucket %s already exists.\n", bucket_name);
////            b = getBucket(bucket_name);
//        	
//        	context.getLogger().log("Bucket Exist");
//        	
//        } else {
//        	
//        	context.getLogger().log("Bucket Not Exist");
//        	
////            try {
////                b = s3.createBucket(bucket_name);
////            } catch (AmazonS3Exception e) {
////                System.err.println(e.getErrorMessage());
////            }
//        	
//        	
//        }
//        
//        context.getLogger().log(jsonObject.get("louis").toString());
//        
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //context.getLogger().log("Input: " + input);
//        // TODO: implement your handler
//        return null;
    }

}
