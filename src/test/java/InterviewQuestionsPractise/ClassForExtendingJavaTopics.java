package InterviewQuestionsPractise;

//Using multiple interfaces on the class with implements along with parent class
public class ClassForExtendingJavaTopics extends JavaTopics implements Interface, InterfaceTwo {
    static JavaTopics javaTopics = new JavaTopics();

    public static void main(String[] args) {
        //Calling static methods directly from the parent class
        System.out.println(stringCompare("a", "a"));

        stringReverse("macbook");
        ClassForExtendingJavaTopics classForExtendingJavaTopics = new ClassForExtendingJavaTopics();
        classForExtendingJavaTopics.nonStaticMethod();
        //Making non-static method call
        //javaTopics.nonStaticMethod();
        classForExtendingJavaTopics.printMethod("Extend class calling interface implemented methods");
    }

    @Override
    public void nonStaticMethod() {
        System.out.println("Print from override method");
    }

    @Override
    public int integerReturnMethod(int i) {
        return 0;
    }

    @Override
    public void printMethod(String str) {
        System.out.println("Method from interface");
    }
}
