package InterviewQuestionsPractise.ConstructorLearning;

public class CallingConstructor {
	String browserSelection = "firefox";

	ClassWithConstructor classWithConstructor = new ClassWithConstructor(browserSelection);

	public static void main(String[] args) {
		CallingConstructor callingConstructor = new CallingConstructor();
		callingConstructor.navigateToTheURL();
		// classWithConstructor.BrowserOpen();
	}

	void navigateToTheURL() {
		classWithConstructor.driver.get("https://www.google.co.in");
	}

}
