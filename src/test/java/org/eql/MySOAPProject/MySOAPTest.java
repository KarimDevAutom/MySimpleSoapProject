package org.eql.MySOAPProject;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MySOAPTest {

	/**
	 * Rigorous Test :-)
	 */

	/*
	 * @Test public void testTestCaseRunnerTest() throws Exception {
	 * System.out.println("********** DEBUT DU TEST **********"); WsdlProject
	 * project = new
	 * WsdlProject("src/test/resources/Projet-SOAP-TP-soapui-project.xml");
	 * List<TestSuite> testSuites = project.getTestSuiteList(); for (TestSuite suite
	 * : testSuites) { List<TestCase> testCases = suite.getTestCaseList(); for
	 * (TestCase testCase : testCases) {
	 * System.out.println("********** RUNNING SOAPUI TEST [" + testCase.getName() +
	 * "] - START - **********"); TestRunner runner2 = testCase.run(new
	 * PropertiesMap(), false); assertEquals(Status.FINISHED, runner2.getStatus());
	 * System.out.println("********** RUNNING SOAPUI TEST [" + testCase.getName() +
	 * "] -SUCCESS - **********"); } } }
	 */

	/*
	 * @Test public void testRunner() throws Exception {
	 * System.out.println("********** DEBUT TEST 1 **********");
	 * SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
	 * runner.setProjectFile("src/test/resources/Projet-SOAP-TP-soapui-project.xml")
	 * ; runner.run(); System.out.println("********** FIN DU TEST 1 **********"); }
	 */

	/*
	 * @Test public void test() throws XmlException {
	 * 
	 * System.out.println("********** DEBUT TEST 1 **********");
	 * SoapUITestCaseRunner testCaseRunner = new SoapUITestCaseRunner();
	 * System.out.println("********** Fin initialisation **********");
	 * testCaseRunner.setProjectFile(
	 * "src/test/resources/Projet-SOAP-TP-soapui-project.xml"); try {
	 * System.out.println("********* RUN **********"); testCaseRunner.run(); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * System.out.println("********** FIN DU TEST 1 **********"); }
	 */
	
	@Test
	public void test2() throws XmlException, IOException, SoapUIException {

		System.out.println("********** DEBUT DU TEST 2 **********");
		System.out.println(
				"********** Creer une nouvelle instance de WsdlProject en specifiant le chemin absolu du projet SoapUI **********");
		WsdlProject project = new WsdlProject("src/test/resources/Projet-SOAP-TP-soapui-project.xml");

		System.out.println("********** Recupere tous les TestSuites inclus dans le projet SoapUI **********");
		List<TestSuite> testSuiteList = project.getTestSuiteList();

		System.out.println("********** Iteration sur tous les TestSuites du projet **********");
		for (TestSuite ts : testSuiteList) {

			System.out.println("*********** Running " + ts.getName() + " ***********");
			/*
			 * Recupere tous les TestCases d'une TestSuite
			 */
			List<TestCase> testCaseList = ts.getTestCaseList();
			/*
			 * Iteration sur tous les TestCases d'un TestSuite particulier
			 */
			for (TestCase testcase : testCaseList) {

				System.out.println("*********** Running " + testcase.getName() + " ***********");
				/*
				 * Execute le TestCase specifie
				 */
				TestRunner testCaseRunner = testcase.run(new PropertiesMap(), false);
				/*
				 * Verifie si le TestCase s'est termine correctement ou s'il a echoue a cause
				 * d'un echec d'assertion
				 */
				assertEquals(TestRunner.Status.FINISHED, testCaseRunner.getStatus());

				System.out.println("********** LE TEST " + testcase.getName() + " S'EST TERMINE AVEC SUCCES **********");
			}
		}

		System.out.println("********** FIN DU TEST 2 **********");
	}

}
