package dataScriptsTestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzerTest implements IRetryAnalyzer{

	
	int retryAttemptCounter = 0;
	int maxRetryCount = 1;

	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()) {
			if(retryAttemptCounter<maxRetryCount) {
				retryAttemptCounter++;
				return true;
			}
		}
		return false;
	}
}
