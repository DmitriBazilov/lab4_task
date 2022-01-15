import java.lang.reflect.*;

public class Main {
	
	public static void main(String[] args) {
		MyTestSuite testSuite = new MyTestSuite();

		TestRunner testRunner = new TestRunner();

		testRunner.runTests(testSuite);

	}

}
