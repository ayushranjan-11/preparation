package InterviewQuestionsPractise.AbstractionConcept;

/*
 * Rules for abstract class:
 * 1. "abstract" keyword should be used in class name
 * 2. One method of the class has to be abstract method
 * 2.1 Abstract method are method which don't have body, only method declaration
 * 2.2 One method is mandatory, abstract class can have more than 1 abstract method but 1 is minimum required
 * 2.3 Return type for abstract method can be any primitive data type
 * 2.4 Direct object of abstract class is not allowed (Ex: AbstractClass ab = new AbstractClass(); {This is not allowed})
 * 2.5 Abstract class allows to define data types with static and final
 * */

public abstract class AbstractClass {

    int a = 10;
    String b = "Hello";
    final int c = 30;
    static String f = "Test String";


    //This is how abstract method is defined, and are mandatory with abstract class.
    public abstract String abstractMethod();

    public abstract void anotherAbstractMethod();

    //This is a non-abstract method in abstract class
    public void concreteMethod() {
        System.out.println("This is concrete method");
    }
}
