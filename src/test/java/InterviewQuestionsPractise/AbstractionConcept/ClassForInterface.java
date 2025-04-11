package InterviewQuestionsPractise.AbstractionConcept;


/* Same as abstract class and method when another class implements an interface class then all methods are mandatory
to be Overriden in the implemented class
Along with Override method, user defined method can also be defined in the class.
* */
public class ClassForInterface implements InterfaceClass {
    @Override
    public void abstractMethodFromInterfaceClass() {
        System.out.println("This is abstract method from interface class and can be overriden in implemented class");
        System.out.println(InterfaceClass.CONSTANT);
    }

    @Override
    public void anotherAbstractMethodFromInterfaceClass() {
        System.out.println("This is another abstract method from interface class and can be overriden in implemented class");
    }
}
