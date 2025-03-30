package InterviewQuestionsPractise.AbstractionConcept;

public class TestAbstractionClass {
    public static void main(String[] args) {
        AbstractClassInheritor abstractClassInheritor = new AbstractClassInheritor();
        abstractClassInheritor.concreteMethod();
        abstractClassInheritor.concreteMethodInInheritor();
        abstractClassInheritor.abstractMethod(); //This is an overriden method from AbstractClass in AbstractClassInheritor class
        abstractClassInheritor.anotherAbstractMethod(); //This is an overriden method from AbstractClass in AbstractClassInheritor class

        //Dynamic Polymorphism
        AbstractClass ab = new AbstractClassInheritor();
        ab.abstractMethod();
        ab.anotherAbstractMethod();
        ab.concreteMethod();
        /*
         * Why this example was written because when calling abstract methods via dynamic polymorphism then it was called
         * as overriden method from the child class.
         *
         * Note: AbstractClass or parent class is not able to call method of child class via "ab" because ab is reference of
         * AbstractClass, though it is creating object with new keyword of AbstractClassInheritor but "ab" is reference
         * of AbstractClass
         * */


        //Interface class object assign and calling the overriden method from an interface in the child class
        ClassForInterface classForInterface = new ClassForInterface();
        classForInterface.abstractMethodFromInterfaceClass();
        classForInterface.anotherAbstractMethodFromInterfaceClass();

    }
}
