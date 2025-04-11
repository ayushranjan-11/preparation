package InterviewQuestionsPractise;

import java.util.*;

public class SetExample {

    Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) {
        Set<String> collectionString = new HashSet<>();
        collectionString.add("A");
        collectionString.add("B");
        collectionString.add("C");
        collectionString.add("D");

        SetExample setExample = new SetExample();
        setExample.usingHashSet(collectionString);

    }

    public void usingHashSet(Set<String> collection) {
        stringSet.addAll(collection);

        //Accessing set content with for each loop
        for (String name : collection) {
            System.out.println(name);
        }

        //Accessing set content with iterator
        Iterator<String> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {
            System.out.println(collectionIterator.next());
        }
    }
}
