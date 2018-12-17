package com.cg.login.other;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.cg.login.pojo.Environment;
import com.cg.login.pojo.Error;
import com.cg.login.pojo.Extension;
import com.cg.login.pojo.Interface;
import com.cg.login.pojo.Transaction;
import com.cg.login.pojo.TransactionDetails;

public class CreateLoginTransaction {
	
	private Transaction transaction = new Transaction();
	private int count = 36;
	LocalDate localDate = LocalDate.now();
	
	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789-";
	
	//to generate random string for correlationId
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
		}
		return builder.toString();
	}
	
	// get the property value and print it out
	public void setTransactionEnv(Properties envprop) {
		
		Environment environment = new Environment();
		environment.setOrganizationId(envprop.getProperty("organizationId"));
		environment.setBusinessUnitId(envprop.getProperty("businessUnitId"));
		environment.setProjectId(envprop.getProperty("projectId"));
		environment.setEnvironmentId(envprop.getProperty("environmentId"));
		environment.setServerId(envprop.getProperty("serverId"));
		transaction.setEnvironment(environment);
		transaction.setVersionId("1.0");
		
	}
	
	public void setTransactionInterface(Properties intprop) {
		
		Interface iinterface = new Interface();
		iinterface.setInterfaceId(intprop.getProperty("interfaceId"));
		iinterface.setSourceId(intprop.getProperty("sourceId"));
		iinterface.setTargetId(intprop.getProperty("targetId"));
		transaction.setIinterface(iinterface);
		
	}
	
	public TransactionDetails setTransactionDetail(Properties tdprop,String startDate,String endDate) {
		
		TransactionDetails transactionDetails = new TransactionDetails();
		
		transactionDetails.setCorrelationId(randomAlphaNumeric(count));
		transactionDetails.setBusinessId(tdprop.getProperty("businessId"));
		
		long offset = Timestamp.valueOf(DateTimeFormatter.ofPattern(startDate+" 00:00:00").format(localDate)+"").getTime();
		long end = Timestamp.valueOf(DateTimeFormatter.ofPattern(endDate+" 23:60:60").format(localDate)+"").getTime();
		long diff = end - offset + 1;
		Timestamp timestamp = new Timestamp(offset + (long) (Math.random() * diff));
		
		transactionDetails.setExecutionTime(timestamp+"");
		transactionDetails.setExecutionPoint(tdprop.getProperty("executionPoint"));
		transactionDetails.setExecutionMessage(tdprop.getProperty("executionMessage"));
		transactionDetails.setExecutionStatus(tdprop.getProperty("executionStatus"));
		transactionDetails.setPayload(tdprop.getProperty("payload"));
		
		Extension extension = new Extension();
		extension.setTotalRecords(tdprop.getProperty("extension.TotalRecords"));
		extension.setSuccessRecords(tdprop.getProperty("extension.SuccessRecords"));
		extension.setFailedRecords(tdprop.getProperty("extension.FailedRecords"));
		transactionDetails.setExtension(extension);
		
		transaction.setTransactionDetails(transactionDetails);
		return transactionDetails;
	}
	
	public void setTransactionError(Properties errorprop) {
		
		Error error = new Error();
		
		error.setErrorType(errorprop.getProperty("errorType"));
		error.setErrorCode(errorprop.getProperty("errorCode"));
		error.setErrorText(errorprop.getProperty("errorText"));

		transaction.setError(error);
	}
	
	public Transaction showTransaction() {
		System.out.println(transaction.toString());
		return transaction;
	}

}
