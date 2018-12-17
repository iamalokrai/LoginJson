package com.cg.login.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.cg.login.other.GetPropertiesValue;
import com.cg.login.pojo.Transaction;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class LoginMain {

	public static void main(String[] args) throws IOException {
				
		GetPropertiesValue pvalue = new GetPropertiesValue();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of records required");
		int noOfEntries = scanner.nextInt();
		scanner.close();*/
		
		OutputStream fos = new FileOutputStream(args[0]); 
		
		//Create generator instance
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(fos);
		jsonGenerator.writeStartArray();
				
		for(int i = 1;i <= (2*Integer.parseInt(args[1]));i++) {
			
		Transaction transaction = pvalue.getPropValues(i,Integer.parseInt(args[3]),args[4],args[5]); //Generate login details
		ow.writeValue(jsonGenerator, transaction);
		
		}
		
		jsonGenerator.writeEndArray();
		jsonGenerator.close();
		//System.out.println("File Successfully Created with "+noOfEntries+" records.");

	}
	
}