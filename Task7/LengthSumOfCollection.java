package Task7;

import java.util.ArrayList;
import java.util.Collection;

public class LengthSumOfCollection {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<String>();
        collection.add("aaaaaaaa");
        collection.add("bb");
        collection.add("ccccc");
        collection.add("dddd");
        collection.add("eeeeeeeee");
        System.out.println(collection.stream().map(String::length).filter(x -> x > 5).count());
    }
}
