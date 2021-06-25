package dataScriptsTestNG;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {


	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for(ISuite suite:suites) {
		String suiteName = suite.getName();
		Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			for(ISuiteResult result:suiteResults.values()) {
				
				ITestContext tc = result.getTestContext();
				System.out.println("Passed test Cases : "+ suiteName + tc.getPassedTests().getAllResults().size());
				System.out.println("Failed test Cases : "+ suiteName + tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped test Cases : "+ suiteName + tc.getSkippedTests().getAllResults().size());
			}
		}
	}

}
