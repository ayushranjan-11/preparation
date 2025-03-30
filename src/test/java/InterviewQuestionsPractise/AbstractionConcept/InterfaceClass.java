package InterviewQuestionsPractise.AbstractionConcept;

//In interface only abstract method can be defined and no other methods are allowed
//No need to define methods with abstract keyword, by default only abstract methods are allowed.
//Direct object of interface class is not allowed (Ex: InterfaceClass ic = new InterfaceClass(); {This is not allowed})
//Only final and static are allowed to be defined in the interface class

public interface InterfaceClass {
    final int CONSTANT = 10;
    static final String STATIC_CONSTANT = "Static Constant";
    static boolean isStatic = true;

    public void abstractMethodFromInterfaceClass();
    public void anotherAbstractMethodFromInterfaceClass();

}
