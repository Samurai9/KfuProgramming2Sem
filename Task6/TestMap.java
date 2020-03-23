package Task6;

public class TestMap {
    public static void main(String[] args) {
        TestMap testMap = new TestMap();
        MyMap<Integer,Integer> map = new MyMap<>();
        System.out.println(map.isEmpty());
        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.remove(2);
        map.remove(1);
        testMap.showMap(map);
        System.out.println(map.containsKey(2));
        System.out.println(map.containsKey(5));
        System.out.println(map.get(3));
        System.out.println(map.size());
        map.replace(1,1);
        testMap.showMap(map);
    }

    private void showMap(MyMap map){
        for (int i = 0; i < map.size(); i++) {
            System.out.println(i + ") " + map.get(i));
        }

    }
}
