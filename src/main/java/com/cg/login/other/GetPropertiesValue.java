package com.cg.login.other;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.cg.login.pojo.Transaction;
import com.cg.login.pojo.TransactionDetails;

public class GetPropertiesValue {
	
	private InputStream inputStream;
	private Transaction tempTransaction;
 
	public Transaction getPropValues(int i,int timeGap,String startDate,String endDate) throws IOException {
		
		CreateLoginTransaction loginTransaction = new CreateLoginTransaction();
		Properties envprop = new Properties();
		String propFileName = "environment.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		envprop.load(inputStream);
		loginTransaction.setTransactionEnv(envprop);
		
		Properties intprop = new Properties();
		propFileName = "interface.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		intprop.load(inputStream);
		loginTransaction.setTransactionInterface(intprop);
		
		Properties tdprop = new Properties();
		if(i%2==0) 
			propFileName = "successTransaction.properties";		
		else
			propFileName = "inprogTransaction.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		tdprop.load(inputStream);
		TransactionDetails transactionDetails = loginTransaction.setTransactionDetail(tdprop,startDate,endDate);
		if(i%2==0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = null;
			try {
				parsedDate = dateFormat.parse(tempTransaction.getTransactionDetails().getExecutionTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    
		    //timestamp.setNanos(timestamp.getNanos()+9900000);
		    Random rand = new Random();
		    transactionDetails.setExecutionTime(Timestamp.from(timestamp.toInstant().plusMillis(rand.nextInt(timeGap)))+"");
			transactionDetails.setCorrelationId(tempTransaction.getTransactionDetails().getCorrelationId());
		}
		
		
		Properties errorprop = new Properties();
		propFileName = "error.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		errorprop.load(inputStream);
		loginTransaction.setTransactionError(errorprop);
		
		Transaction transaction = loginTransaction.showTransaction();
		tempTransaction = transaction;

		//result = "Company List = ";
		//System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
		inputStream.close();

		return transaction;
	}

}
