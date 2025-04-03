package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit =2;

	@Override
	public boolean retry(ITestResult result) {
		LoggerReader.info("Retry method starts From RetryAnalyzer Class");
		if(counter< retryLimit) {
			counter++;
			LoggerReader.info("Retry:"+counter+" On the failed test case \""+result.getName()+"\"");
			return true;
		}
		LoggerReader.info("Test case \""+result.getName()+"\": Failed. After "+counter+"retries");
		return false;
	}
}