package InterviewQuestionsPractise.AbstractionConcept;

/*
//Abstract class can be extended to the child class, Interface classes are implemented with the child class
* Whenever extending abstract class in any class then abstract methods are mandatory to be added in the child class
* with "@Override" annotation. Not mandatory to have annotation.
Along with Override method, user defined method can also be defined in the class.
*/

public class AbstractClassInheritor extends AbstractClass {
    //In this override method, it can be seen to extend the abstract method of abstract class
    @Override
    public String abstractMethod() {
        System.out.println("This is abstract method in inheritor");
        return "This is abstract method in inheritor";
    }

    @Override
    public void anotherAbstractMethod() {
        System.out.println("This is another abstract method in inheritor");
    }

    public void concreteMethodInInheritor() {
        System.out.println("This is concrete method in inheritor class");
    }
}
