package Task7;

import Task6.MyMap;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MapKeyConcatenation {
 /*   private class MyNewMap<K,V> extends MyMap<K, V> {
        private Integer[] getKeys(){
            return keySet();
        }
    }*/

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("one",1);
        hashMap.put("two",2);
        hashMap.put("three",3);

        ArrayList<String> keyList = new ArrayList<String>(hashMap.keySet());

        System.out.println(keyList.stream().reduce((first, second) -> first+second).orElse(""));



    }
}
